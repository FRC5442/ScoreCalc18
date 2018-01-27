package frc.team5442.scorecalc2018;

public class GameScriptProcessor {
	private String _gameScript;
	private int _redScore;
	private int _blueScore;
	
	public GameScriptProcessor(String gameScript) {
		_gameScript = gameScript;
	}
	
	public void Run() {
		
	}
	
	public int RedScore() {
		return _redScore;
	}
	
	public int BlueScore() {
		return _blueScore;
	}
}
