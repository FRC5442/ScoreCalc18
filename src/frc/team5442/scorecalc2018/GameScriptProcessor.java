package frc.team5442.scorecalc2018;

import java.util.ArrayList;
import java.util.HashMap;

public class GameScriptProcessor {
	private ArrayList<String> _gameScript;
	private HashMap<Integer, Action> _tickMap;
	private int _redScore;
	private int _blueScore;
	private String _script;
	private GameItem _scale;
	
	public GameScriptProcessor(ArrayList<String> gameScript) {
		_scale = new GameItem(GameItemType.Scale);
		
		_gameScript = gameScript;
		_tickMap = new HashMap<>();
	
		for(String s : _gameScript) {
			Integer index = Integer.parseInt( s.split(",")[0]);
			Action action = new Action(s.split(",")[1], s.split(",")[2]);
			_tickMap.put(index,action);
		}
	}
	public void Run() {
		for(int tick = 1; tick <= 150; tick++) {
			Action currentAction = _tickMap.get(tick);
			if(currentAction != null) {
				switch(currentAction.get_action()) {
				case CrossLine:
					if(currentAction.get_alliance().equals("red")) {
						_redScore += 5;
					}
					if(currentAction.get_alliance().equals("blue")) {
						_blueScore += 5;
					}
					break;
				case Scale:
					_scale.set_owner(currentAction.get_alliance());
				default:
					break;
				
				}
			}
			_redScore += _scale.RedScore();
			_blueScore += _scale.BlueScore();
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
