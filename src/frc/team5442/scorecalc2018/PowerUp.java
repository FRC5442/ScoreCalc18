package frc.team5442.scorecalc2018;

public class PowerUp {
	private int _tickEvent;
	private int _tickStart;
	private ActionType _type;
	private Alliance _owner;
	private int _level;
	
	public PowerUp (int tick, Alliance owner, ActionType type) {
		_type = type;
		_tickEvent = tick;
		_owner = owner;
		
		switch(_type) {
		case Boost1:
		case Force1:
			_level = 1;
			break;
		case Boost2:
		case Force2:
			_level = 2;
			break;
		case Boost3:
		case Force3:
			_level = 3;
			break;
		default:
			break;
		}
	}
	
	public int get_tickStart() {
		return _tickStart;
	}

	public int get_tickEnd() {
		return _tickStart + 10;
	}

	public void set_tickStart(int _tickStart) {
		this._tickStart = _tickStart;
	}

	public int get_level() {
		return _level;
	}

	public int get_tickEvent() {
		return _tickEvent;
	}

	public Alliance get_owner() {
		return _owner;
	}

	public ActionType get_type() {
		return _type;
	}
}