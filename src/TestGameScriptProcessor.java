import static org.junit.jupiter.api.Assertions.*;

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
		GameScriptProcessor proc = new GameScriptProcessor("");
		Assertions.assertEquals(0, proc.BlueScore());		
		Assertions.assertEquals(0, proc.RedScore());		
	}
	

}
