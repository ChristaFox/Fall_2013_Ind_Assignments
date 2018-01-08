/*******************************************************
* Name: Christa Fox
* Course: CSIS 1420
* Assignment: A03
*******************************************************/

package testing;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Before;
import org.junit.Test;

import classes.Distance;

public class DistanceJUnitTests {
	int expectedFeet;
	int actualFeet;
	int expectedInches;
	int actualInches;

//	/*Create a new distance object of 0 feet, 0 inches.*/
//	@Before
//	public void setUpd1() {
//		Distance d1 = new Distance(0, 0);
//		int expectedFeet = 0;
//		int actualFeet = d1.getFeet();
//		int expectedInches = 0;
//		int actualInches = d1.getInches();
//	}
//	
//	/*Create a distance object with the default values.*/
//	@Before
//	public void setUpd2() {
//		Distance d2 = new Distance();
//		int expectedFeet = 1;
//		int actualFeet = d2.getFeet();
//		int expectedInches = 1;
//		int actualInches = d2.getInches();
//	}
//	
//	/*Create a new distance object of 3 feet, 2 inches.*/
//	@Before
//	public void setUpd3() {
//		Distance d3 = new Distance(3, 2);
//		int expectedFeet = 3;
//		int actualFeet = d3.getFeet();
//		int expectedInches = 2;
//		int actualInches = d3.getInches();
//	}
//	
//	/*Create a distance object with the default values 
//	 * when invalid input is received.*/
//	@Before
//	public void setUpd4() {
//		Distance d4 = new Distance(-1, 1);
//		int expectedFeet = 1;
//		int actualFeet = d4.getFeet();
//		int expectedInches = 1;
//		int actualInches = d4.getInches();
//	}
//	
//	/*Create a distance object of many feet and 1 inch.*/
//	@Before
//	public void setUpd5() {
//		Distance d5 = new Distance(Integer.MAX_VALUE, 1);
//		int expectedFeet = Integer.MAX_VALUE;
//		int actualFeet = d5.getFeet();
//		int expectedInches = 1;
//		int actualInches = d5.getInches();
//	}
//	
//	/*Create a distance object with the default values when 
//	 * invalid input is received.*/
//	public void setUpd6() {
//		Distance d6 = new Distance(Integer.MIN_VALUE, 1);
//		int expectedFeet = 0;
//		int actualFeet = d6.getFeet();
//		int expectedInches = 0;
//		int actualInches = d6.getInches();
//	}
	
	/*Add 2 distance methods.  It converts them to inches, 
	 *and then back to inches and feet in the getDistance method.*/
	@Test
	public void testAddDistance1() {
		Distance d1 = new Distance(0, 0);
		Distance d2 = new Distance();
		expectedFeet = 1;
		expectedInches = 1;
		Distance d = d1.addDistance(d1, d2);
		assertEquals(expectedFeet, d.getFeet());
		assertEquals(expectedInches, d.getInches());
	}
	
	
	/*Add 2 distance methods. It converts them to inches, and then 
	back to inches and feet in the getDistance method.*/
	@Test (expected = InputMismatchException.class)
	public void testAddDistance2() {
		Distance d3 = new Distance(3, 2);
		Distance d4 = new Distance(-1, 1);
		expectedFeet = 4;
		expectedInches = 3; 
		Distance d = d3.addDistance(d3, d4);
		assertEquals(expectedFeet, d.getFeet());
		assertEquals(expectedInches, d.getInches());
	}
	
	/*Add 2 distance methods it converts them to inches, and then 
	back to inches and feet in the getDistance method.*/
	@Test (expected = InputMismatchException.class)
	public void testAddDistance3() {
		Distance d5 = new Distance(Integer.MAX_VALUE, 1);
		Distance d6 = new Distance(Integer.MIN_VALUE, 1);
		expectedFeet = 0;
		expectedInches = 2;
		Distance d = d5.addDistance(d5, d6);
		assertEquals(expectedFeet, d.getFeet());
		assertEquals(expectedInches, d.getInches());
	}
	
	/*Subtract 2 distance methods.  It converts them to inches, and then 
	back to inches and feet in the getDistance method.*/
	@Test
	public void testSubDistance1() {
		Distance d1 = new Distance(0, 0);
		Distance d2 = new Distance();
		expectedFeet = 1;
		expectedInches = 1;
		Distance d = d1.addDistance(d1, d2);
		assertEquals(expectedFeet, d.getFeet());
		assertEquals(expectedInches, d.getInches());		
	}
	
	/*Subtract 2 distance methods it converts them to inches, and then 
	back to inches and feet in the getDistance method.*/
	@Test
	public void testSubDistance2() throws InputMismatchException 
	{
		try 
		{
			Distance d3 = new Distance(3, 2);
			Distance d4 = new Distance(-1, 1);
			expectedFeet = 2;
			expectedInches = 1;
			Distance d = d3.addDistance(d3, d4);
		}
		
		catch (InputMismatchException e)
		{
			assertEquals(e.getMessage(), "That is not a valid amount of feet.");
		}
		
    }
	
	/*Subtract 2 distance methods it converts them to inches, and then 
	back to inches and feet in the getDistance method.*/
	@Test (expected = InputMismatchException.class)
	public void testSubDistance3() {
		Distance d5 = new Distance(Integer.MAX_VALUE, 1);
		Distance d6 = new Distance(Integer.MIN_VALUE, 1);
		expectedFeet = 0;
		expectedInches = 0;
		Distance d = d5.addDistance(d5, d6);
		assertEquals(expectedFeet, d.getFeet());
		assertEquals(expectedInches, d.getInches());
	}
	
	/**
	 * test less than zero
	 */
	@Test (expected = InputMismatchException.class)
	public void testLessThanZero(){
		Distance d = new Distance(-1, 1);
		
	}
	
	/*Check that 2 methods that are not equal are defined as such.*/
	@Test
	public void testEquals1() {
		Distance d1 = new Distance(0, 0);
		Distance d2 = new Distance();
		assertEquals(false, d1.equals(d2));
	}
	
	/*Check that 2 methods that are equal are defined as such.*/
	@Test (expected = InputMismatchException.class)
	public void testEquals2() {
		Distance d2 = new Distance();
		Distance d4 = new Distance(-1, 1);
		assertEquals(true, d2.equals(d4));
	}

}
