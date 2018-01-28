import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import frc.team5442.scorecalc2018.GameScriptProcessor;

class TestGameScriptProcessor {

	@Test
	void test() {
		//fail("Not yet implemented");
	}
	
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
		Assertions.assertEquals(83, proc.RedScore());		
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
	public ArrayList<String> addScaleEvents1(ArrayList<String> script) {
		script.add("15,red,scale");
		script.add("30,blue,scale");
		script.add("56,red,scale");
		script.add("76,blue,scale");
		script.add("80,red,scale");
		script.add("80,blue,scale");
		script.add("103,red,scale");
		return script;
	}
}
