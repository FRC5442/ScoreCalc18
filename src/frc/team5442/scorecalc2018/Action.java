package frc.team5442.scorecalc2018;

public class Action  {
	private Alliance _alliance; 
	private ActionType _action;
	
	public Alliance get_alliance() {
		return _alliance;
	}

	public ActionType get_action() {
		return _action;
	}
	
	public Action(String alliance, String action) {
		if (alliance.toLowerCase().equals("blue"))
			_alliance = Alliance.Blue;
		else
			_alliance = Alliance.Red;
		switch(action.toLowerCase()) {
		case "crossline" :
			_action = ActionType.CrossLine;
			break;
		case "scale" :
			_action = ActionType.Scale;
			break;
		case "blueswitch" :
			_action = ActionType.BlueSwitch;
			break;
		case "redswitch" :
			_action = ActionType.RedSwitch;
			break;
		case "boost1" :
			_action = ActionType.Boost1;
			break;
		case "boost2" :
			_action = ActionType.Boost2;
			break;
		case "boost3" :
			_action = ActionType.Boost3;
			break;
		case "force1" :
			_action = ActionType.Force1;
			break;
		case "force2" :
			_action = ActionType.Force2;
			break;
		case "force3" :
			_action = ActionType.Force3;
			break;
		case "climb" :
			_action = ActionType.Climb;
			break;
		case "levitate" :
			_action = ActionType.Levitate;
			break;
		case "park" :
			_action = ActionType.Park;
			break;
		case "vault" :
			_action = ActionType.Vault;
			break;
		}
	}
	
	public Action(Alliance alliance, ActionType action) {
		_alliance = alliance;
		_action = action;
	}
}
