package frc.team5442.scorecalc2018;

import java.util.ArrayList;
import java.util.HashMap;

public class GameScriptProcessor {
	private ArrayList<String> _gameScript;
	private HashMap<Integer, ArrayList<Action>> _tickMap;
	private PowerUps _powerUps;
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
		_powerUps = new PowerUps();
		
		_gameScript = gameScript;
		_tickMap = new HashMap<>();
	
		for(String s : _gameScript) {
			Integer index = Integer.parseInt( s.split(",")[0]);
			Action action = new Action(s.split(",")[1], s.split(",")[2]);
			switch(action.get_action()) {
			case Boost1:
			case Boost2:
			case Boost3:
			case Force1:
			case Force2:
			case Force3:
				_powerUps.Add(new PowerUp(index, action.get_alliance(), action.get_action()));
				break;
			default:
				ArrayList<Action> currentTickActions = _tickMap.get(index);
				if (currentTickActions == null) currentTickActions = new ArrayList<Action>();
				currentTickActions.add(action);
				_tickMap.put(index, currentTickActions);
			}
		}
	}
	public void Run() {
		for(int tick = 1; tick <= 150; tick++) {
			ArrayList<Action> tickActions = _tickMap.get(tick);
			if(tickActions != null) {
				for(Action currentAction : tickActions) {
					switch(currentAction.get_action()) {
					case CrossLine:
					case Park:
						if(currentAction.get_alliance() == Alliance.Red) {
							_redScore += 5;
						}
						if(currentAction.get_alliance() == Alliance.Blue) {
							_blueScore += 5;
						}
						break;
					case Levitate:
					case Climb:
						if(currentAction.get_alliance() == Alliance.Red) {
							_redScore += 30;
						}
						if(currentAction.get_alliance() == Alliance.Blue) {
							_blueScore += 30;
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
						
					default:
						break;
					
					}
				}
			}
			if(tick <= 15) {
				_redScore += (_scale.RedScore() + _redSwitch.RedScore()) * 2;
				_blueScore += (_scale.BlueScore() + _blueSwitch.BlueScore()) * 2;
			}
			else {
				_redScore += _scale.RedScore() + _redSwitch.RedScore();
				_blueScore += _scale.BlueScore() + _blueSwitch.BlueScore();
				
				PowerUp currentPowerUp = _powerUps.get_currentPowerUp(tick);
				if (currentPowerUp != null) {
					switch(currentPowerUp.get_type()) {
					case Boost1:
						if (currentPowerUp.get_owner() == Alliance.Red) _redScore += _redSwitch.RedScore();
						else _blueScore += _blueSwitch.BlueScore();
						break;
					case Boost2:
						if (currentPowerUp.get_owner() == Alliance.Red) _redScore += _scale.RedScore();
						else _blueScore += _scale.BlueScore();
						break;
					case Boost3:
						if (currentPowerUp.get_owner() == Alliance.Red) _redScore += _scale.RedScore() + _redSwitch.RedScore();
						else _blueScore += _scale.BlueScore() + _blueSwitch.BlueScore();
						break;
					default:
						break;
					}
				}
			}
			
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
