package com.simonirvinvitela.junit_test2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RectangleTest {
	/*public void areaOfRectangleShouldBeEqual() {
		
	}*/
	
	@Test
	public void testForGetArea() {
		//Arrange
		Rectangle rectangle = new Rectangle();
		
		//Act
		int actualResult = rectangle.getArea(10, 30);
		
		//Assert
		assertEquals(actualResult, 300);
	}
	
	@Test
	public void testForGetAreaWithMultipleValues() {
		Rectangle rectangle = new Rectangle();
		assertEquals(rectangle.getArea(10, 50), 500);
		assertEquals(rectangle.getArea(20, 50), 1000);
		assertEquals(rectangle.getArea(2, 3), 6);
	}
	
	public void testForGetParameterArea() {
		
	}
}
