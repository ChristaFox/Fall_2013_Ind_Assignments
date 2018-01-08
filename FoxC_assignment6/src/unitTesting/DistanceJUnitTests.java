/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A06
*******************************************************/

package unitTesting;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Test;

import distanceInfo.Distance;

public class DistanceJUnitTests {
	int expectedFeet;
	int actualFeet;
	int expectedInches;
	int actualInches;
	
	/**Add 2 distance methods.  It converts them to inches, 
	 *and then back to inches and feet in the getDistance 
	 *method.
	 */
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
	
	
	/**
	 * Add 2 distance methods. It converts them to 
	 * inches, and then back to inches and feet in 
	 * the getDistance method.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAddDistance2() {
		Distance d3 = new Distance(3, 2);
		Distance d4 = new Distance(-1, 1);
		d3.addDistance(d3, d4);
	}
	
	/**
	 * Add 2 distance objects the feet are the max and 
	 * minimum values that Java allows for.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAddDistance3() {
		Distance d5 = new Distance(Integer.MAX_VALUE, 1);
		Distance d6 = new Distance(Integer.MIN_VALUE, 1);
		d5.addDistance(d5, d6);
	}
	
	/**
	 * Subtract 2 distance methods.  It converts them to 
	 * inches, and then back to inches and feet in the 
	 * getDistance method.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSubDistance1() {
		Distance d1 = new Distance(0, 0);
		Distance d2 = new Distance();
		d1.subDistance(d1, d2);		
	}
	
	/**
	 * Subtract 2 distance methods it converts them to inches, 
	 * and then back to inches and feet in the getDistance method.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSubDistance2() throws InputMismatchException 
	{
		Distance d3 = new Distance(3, 2);
		Distance d4 = new Distance(-1, 1);
		d3.subDistance(d3, d4);
		
    }
	
	/**Subtract 2 distance methods it converts them to inches, and then
	 * back to inches and feet in the getDistance method.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSubDistance3() {
		Distance d5 = new Distance(Integer.MAX_VALUE, 1);
		Distance d6 = new Distance(Integer.MIN_VALUE, 1);
		d5.subDistance(d5, d6);
	}
	
	/**
	 * test less than zero
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testLessThanZero(){
		Distance d = new Distance(-1, 1);
		
	}
	
	/**
	 * Check that 2 methods that are not equal are defined as such.
	 */
	@Test
	public void testEquals1() {
		Distance d1 = new Distance(0, 0);
		Distance d2 = new Distance();
		assertEquals(false, d1.equals(d2));
	}
	
	/**
	 * Check that 2 methods that are equal are defined as such.
	 */
	@Test
	public void testEquals2() {
		Distance d2 = new Distance();
		Distance d4 = new Distance(1, 1);
		assertEquals(true, d2.equals(d4));
	}

}
