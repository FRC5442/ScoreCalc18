package frc.team5442.scorecalc2018;

import java.util.ArrayList;
import java.util.HashMap;

public class GameScriptProcessor {
	private ArrayList<String> _gameScript;
	private HashMap<Integer, ArrayList<Action>> _tickMap;
	private int _redScore;
	private int _blueScore;
	private String _script;
	
	private GameItem _scale;
	private GameItem _redSwitch;
	private GameItem _blueSwitch;
	
	public GameScriptProcessor(ArrayList<String> gameScript) {
		_scale = new GameItem(GameItemType.Scale);
		_redSwitch = new GameItem(GameItemType.RedSwitch);
		_blueSwitch = new GameItem(GameItemType.BlueSwitch);
		
		_gameScript = gameScript;
		_tickMap = new HashMap<>();
	
		for(String s : _gameScript) {
			Integer index = Integer.parseInt( s.split(",")[0]);
			Action action = new Action(s.split(",")[1], s.split(",")[2]);
			ArrayList<Action> currentTickActions = _tickMap.get(index);
			if (currentTickActions == null) currentTickActions = new ArrayList();
			currentTickActions.add(action);
			_tickMap.put(index, currentTickActions);
		}
	}
	public void Run() {
		for(int tick = 1; tick <= 150; tick++) {
			ArrayList<Action> tickActions = _tickMap.get(tick);
			if(tickActions != null) {
				for(Action currentAction : tickActions) {
					switch(currentAction.get_action()) {
					case CrossLine:
						if(currentAction.get_alliance() == Alliance.Red) {
							_redScore += 5;
						}
						if(currentAction.get_alliance() == Alliance.Blue) {
							_blueScore += 5;
						}
						break;
					case Scale:
						_scale.set_owner(currentAction.get_alliance());
						break;
					case BlueSwitch:
						_blueSwitch.set_owner(currentAction.get_alliance());
						break;
					case RedSwitch:
						_redSwitch.set_owner(currentAction.get_alliance());
						break;
					default:
						break;
					
					}
				}
			}
			_redScore += _scale.RedScore() + _blueSwitch.RedScore() + _redSwitch.RedScore();
			_blueScore += _scale.BlueScore() + _blueSwitch.BlueScore() + _redSwitch.BlueScore();
		}
		
	}
	public String script() {
		return _script;
	}
	public ArrayList<String> gamerArray() {
		return _gameScript;
	}
	public int RedScore() {
		return _redScore;
	}
	public int BlueScore() {
		return _blueScore;
	}
}
