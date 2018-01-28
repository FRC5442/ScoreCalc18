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
		case "boost" :
			_action = ActionType.Boost;
			break;
		case "force" :
			_action = ActionType.Force;
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
