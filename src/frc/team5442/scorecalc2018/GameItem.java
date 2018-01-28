package frc.team5442.scorecalc2018;

public class GameItem {
	private GameItemType _type;
	private Side _owner;
	
	public Side get_owner() {
		return _owner;
	}
	public void set_owner(Side owner) {
		this._owner = owner;
	}
	public void set_owner(Alliance owner) {
		if (owner == Alliance.Blue)
			this._owner = Side.Blue;
		else
			this._owner = Side.Red;
	}
	public GameItem(GameItemType type) {
		_type = type;
		_owner = Side.Neutral;
	}
	public int RedScore() {
		if (_owner == Side.Red) return 1;
		else return 0;
	}
	public int BlueScore() {
		if (_owner == Side.Blue) return 1;
		else return 0;
	}
}
