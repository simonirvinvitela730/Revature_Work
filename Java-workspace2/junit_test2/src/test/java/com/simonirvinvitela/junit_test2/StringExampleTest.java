package com.simonirvinvitela.junit_test2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class StringExampleTest {
	
		@Test
		public void TestForCompareFirstAndLastCharactersAreSame() {
			StringExample se = new StringExample();
			boolean actualValue = se.compareFirstAndLastCharactersAreSame("ABAB");
			boolean expectedValue= true;
			
			assertEquals(actualValue, true);
		}
}
