import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import frc.team5442.scorecalc2018.GameScriptProcessor;

class TestGameScriptProcessor {

	@Test
	void EmptyInputShouldReturnZeroScore() {
		GameScriptProcessor proc = new GameScriptProcessor(new ArrayList<String>());
		Assertions.assertEquals(0, proc.BlueScore());		
		Assertions.assertEquals(0, proc.RedScore());		
	}
	
	@Test
	void CrossingLineShouldIncreaseScore() {
		ArrayList<String> gameScript = new ArrayList<>();
		gameScript = addCrosslineEvents(gameScript);
		GameScriptProcessor proc = new GameScriptProcessor(gameScript);
		proc.Run();
		Assertions.assertEquals(5, proc.BlueScore());		
		Assertions.assertEquals(10, proc.RedScore());		
	}
	
	@Test
	void ControllingScaleGainsPoints() {
		ArrayList<String> gameScript = new ArrayList<>();
		gameScript = addScaleEvents1(gameScript);
		GameScriptProcessor proc = new GameScriptProcessor(gameScript);
		proc.Run();
		Assertions.assertEquals(53, proc.BlueScore());		
		Assertions.assertEquals(82, proc.RedScore());		
	}
	
	@Test
	void ControllingBlueSwitchGainsPoints() {
		ArrayList<String> gameScript = new ArrayList<>();
		gameScript = addBlueSwitchEvents1(gameScript);
		GameScriptProcessor proc = new GameScriptProcessor(gameScript);
		proc.Run();
		Assertions.assertEquals(79, proc.BlueScore());		
		Assertions.assertEquals(0, proc.RedScore());		
	}
	
	@Test
	void ParkingGivesYouPoints() {
		ArrayList<String> gameScript = new ArrayList<>();
		gameScript = addParkEvents(gameScript);
		GameScriptProcessor proc = new GameScriptProcessor(gameScript);
		proc.Run();
		Assertions.assertEquals(10, proc.BlueScore());		
		Assertions.assertEquals(5, proc.RedScore());		
	}
	
	@Test
	void LevitateGivesYouPoints() {
		ArrayList<String> gameScript = new ArrayList<>();
		gameScript = addLevitateEvents(gameScript);
		GameScriptProcessor proc = new GameScriptProcessor(gameScript);
		proc.Run();
		Assertions.assertEquals(30, proc.BlueScore());		
		Assertions.assertEquals(30, proc.RedScore());		
	}
	
	@Test
	void ClimbGivesYouPoints() {
		ArrayList<String> gameScript = new ArrayList<>();
		gameScript = addClimbEvents(gameScript);
		GameScriptProcessor proc = new GameScriptProcessor(gameScript);
		proc.Run();
		Assertions.assertEquals(30, proc.BlueScore());		
		Assertions.assertEquals(60, proc.RedScore());		
	}
	
	@Test
	void ControllingScaleDuringAutoGainsExtraPoints() {
		ArrayList<String> gameScriptTeleop = new ArrayList<>();
		gameScriptTeleop = addScaleEventsTeleop1(gameScriptTeleop);
		GameScriptProcessor procTeleop = new GameScriptProcessor(gameScriptTeleop);
		procTeleop.Run();
		ArrayList<String> gameScriptAuto = new ArrayList<>();
		gameScriptAuto = addScaleEventsAuto1(gameScriptAuto);
		GameScriptProcessor procAuto = new GameScriptProcessor(gameScriptAuto);
		procAuto.Run();
		Assertions.assertEquals(22, procAuto.RedScore()-procTeleop.RedScore());
	}
	
	
	@Test
	void ControllingSwitchesDuringAutoGainsExtraPoints() {
		ArrayList<String> gameScriptTeleop = new ArrayList<>();
		gameScriptTeleop = addSwitchEventsTeleop1(gameScriptTeleop);
		GameScriptProcessor procTeleop = new GameScriptProcessor(gameScriptTeleop);
		procTeleop.Run();
		ArrayList<String> gameScriptAuto = new ArrayList<>();
		gameScriptAuto = addSwitchEventsAuto1(gameScriptAuto);
		GameScriptProcessor procAuto = new GameScriptProcessor(gameScriptAuto);
		procAuto.Run();
		Assertions.assertEquals(22, procAuto.RedScore()-procTeleop.RedScore());
		Assertions.assertEquals(20, procAuto.BlueScore()-procTeleop.BlueScore());
	}
	
	@Test
	void ControllingRedSwitchGainsPoints() {
		ArrayList<String> gameScript = new ArrayList<>();
		gameScript = addRedSwitchEvents1(gameScript);
		GameScriptProcessor proc = new GameScriptProcessor(gameScript);
		proc.Run();
		Assertions.assertEquals(0, proc.BlueScore());		
		Assertions.assertEquals(124, proc.RedScore());		
	}
	
	@Test
	void ThisMatchWithLostOfEvents() {
		ArrayList<String> gameScript = new ArrayList<>();
		gameScript = addCrosslineEvents(gameScript);
		gameScript = addScaleEvents1(gameScript);
		gameScript = addScaleEventsAuto1(gameScript);
		gameScript = addBlueSwitchEvents1(gameScript);
		gameScript = addRedSwitchEvents1(gameScript);
		gameScript = addLevitateEvents(gameScript);
		gameScript = addClimbEvents(gameScript);
		GameScriptProcessor proc = new GameScriptProcessor(gameScript);
		proc.Run();
		Assertions.assertEquals(197, proc.BlueScore());		
		Assertions.assertEquals(328, proc.RedScore());		
	}
	
	@Test
	void BoostedGivesYouMegaPoints() {
		ArrayList<String> gameScript = new ArrayList<>();
		gameScript = addUnboostedEvents(gameScript);
		GameScriptProcessor procUnboosted = new GameScriptProcessor(gameScript);
		procUnboosted.Run();
		ArrayList<String> gameScriptBoost = new ArrayList<>();
		gameScriptBoost = addUnboostedEvents(gameScriptBoost);
		gameScriptBoost = addBoostedEvents(gameScriptBoost);
		GameScriptProcessor procBoosted = new GameScriptProcessor(gameScriptBoost);
		procBoosted.Run();
		Assertions.assertEquals(30, procBoosted.RedScore()-procUnboosted.RedScore());
		Assertions.assertEquals(10, procBoosted.BlueScore()-procUnboosted.BlueScore());
	}
		

	public ArrayList<String> readFileString() {
		String filePath = "C:\\Users\\tunruh\\Desktop\\match01.csv";
		String line;
		ArrayList<String> gameScript = new ArrayList<>();;
		try {
            FileReader reader;
			reader = new FileReader( filePath );
            BufferedReader br = new BufferedReader(reader);
            
            while ((line = br.readLine()) != "") {
            	gameScript.add(line);
            }
            
            br.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return gameScript;
	}
	
	public ArrayList<String> addCrosslineEvents(ArrayList<String> script) {
		script.add("5,red,crossline");
		script.add("7,blue,crossline");
		script.add("10,red,crossline");
		return script;
	}
	//lemmings are furry friends
	public ArrayList<String> addScaleEvents1(ArrayList<String> script) {
		script.add("16,red,scale");
		script.add("30,blue,scale");
		script.add("56,red,scale");
		script.add("76,blue,scale");
		script.add("80,red,scale");
		script.add("80,blue,scale");
		script.add("103,red,scale");
		return script;
	}
	public ArrayList<String> addParkEvents(ArrayList<String> script) {
		script.add("120,red,park");
		script.add("130,blue,park");
		script.add("140,blue,park");
		return script;
	}
	public ArrayList<String> addLevitateEvents(ArrayList<String> script) {
		script.add("120,red,levitate");
		script.add("130,blue,levitate");
		return script;
	}
	public ArrayList<String> addClimbEvents(ArrayList<String> script) {
		script.add("120,red,climb");
		script.add("130,blue,climb");
		script.add("140,red,climb");
		return script;
	}
	public ArrayList<String> addScaleEventsAuto1(ArrayList<String> script) {
		script.add("5,red,scale");
		return script;
	}
	public ArrayList<String> addScaleEventsTeleop1(ArrayList<String> script) {
		script.add("16,red,scale");
		return script;
	}
	public ArrayList<String> addSwitchEventsAuto1(ArrayList<String> script) {
		script.add("5,red,redSwitch");
		script.add("6,blue,blueSwitch");
		return script;
	}
	public ArrayList<String> addSwitchEventsTeleop1(ArrayList<String> script) {
		script.add("16,red,redSwitch");
		script.add("16,blue,blueSwitch");
		return script;
	}
	public ArrayList<String> addBlueSwitchEvents1(ArrayList<String> script) {
		script.add("20,blue,blueswitch");
		script.add("56,red,blueswitch");
		script.add("86,blue,blueswitch");
		script.add("90,red,blueswitch");
		script.add("91,blue,blueswitch");
		script.add("130,red,blueswitch");
		return script;
	}
	public ArrayList<String> addRedSwitchEvents1(ArrayList<String> script) {
		script.add("16,red,redswitch");
		script.add("55,blue,redswitch");
		script.add("56,red,redswitch");
		script.add("76,blue,redswitch");
		script.add("79,red,redswitch");
		script.add("133,blue,redswitch");
		script.add("140,red,redswitch");
		return script;
	}
	public ArrayList<String> addUnboostedEvents(ArrayList<String> script) {
		script.add("120,red,redswitch");
		script.add("130,blue,blueswitch");
		script.add("140,red,scale");
		return script;
	}
	public ArrayList<String> addBoostedEvents(ArrayList<String> script) {
		script.add("120,red,boost3");
		script.add("130,blue,boost3");
		script.add("140,red,boost3");
		return script;
	}
}
