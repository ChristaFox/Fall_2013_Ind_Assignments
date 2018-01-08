/*******************************************************
* Name: Christa Fox
* Course: CSIS 1420
* Assignment: A03
*******************************************************/

package classes;

import java.util.Comparator;
import java.util.InputMismatchException;

/*Distance class with feet and inches*/
public class Distance implements Comparator{

	private int feet;
	private int inches;
	private final int DEFAULT_IN = 1;
	private final int DEFAULT_FT = 1;

	/*constructor uses default values of 1 and 1*/	
	public Distance()
	{
		inches = DEFAULT_IN;
		feet = DEFAULT_FT;
	}

	/*constructor uses set method to catch negative numbers,
	 *  and replace them with default values*/	
	public Distance( int ft, int in )
	{
		setFeet(ft);
		setInches(in);
	}
	
	/* Set feet with non-negative integers.  
	 * If integers do not pass; the final integers are passed 
	 */
	private void setFeet(int ft) {
		if(ft >= 0)
		{
			feet = ft;
		}
		else
		{
			throw new InputMismatchException("That is not a valid amount of feet.");
		}
	}
	
	/* Set inches with non-negative integers.
	 * If integers do not pass; the final integers are passed 
	 */
	private void setInches(int in) {
		if(in >= 0)
		{
			inches = in;
		}
		else
		{
			throw new InputMismatchException("That is not a valid amount of inches.");
		}
	}
	
	/*get private int for feet*/
	public int getFeet() {
		return this.feet;
	}

	/*get private int for inches*/
	public int getInches() {
		return this.inches;
	}
	
	/*method to add two distance objects in inches,
	 *  and then converts them back to feet and inches*/
	public Distance addDistance(Distance a, Distance b){
		int c;
		c = getDistance(a) + getDistance(b);
		feet = (c / 12);
		inches = (c % 12);
		Distance d = new Distance(feet, inches);
		return d;
		
	}
	
	/*method to subtract two distance objects in inches,
	 *  and then converts them back to feet and inches*/
	public Distance subDistance(Distance a, Distance b){
		int c;
		if(a.getFeet() > b.getFeet()){
			c = getDistance(a) - getDistance(b);
			feet = (c / 12);
			inches = (c % 12);
		}
		else{
			c = getDistance(b) - a.getDistance(a);
			feet = (c / 12);
			inches = (c % 12);
		}
		Distance d = new Distance(feet, inches);
		return d;
	}

	private int getDistance(Distance d) {
		int distance;
		distance = (d.getInches() + (d.getFeet() * 12));
		return distance;
	}
	
	/* Computer's attempt at a unique code, which may sometimes fail.*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 7;
		result = prime * result + DEFAULT_FT;
		result = prime * result + DEFAULT_IN;
		result = prime * result + feet;
		result = prime * result + inches;
		return result;
	}
	
	/*compares 2 distance objects to see if they are equal*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distance other = (Distance) obj;
		if (feet != other.feet)
			return false;
		if (inches != other.inches)
			return false;
		return true;
	}
	
	/*compareTo() - compares two distance objects ( <, > )*/
	@Override
	
	public int compare(Object o1, Object o2) {
		int dis1 = (((Distance) o1).getFeet() * 12) + ((Distance) o1).getInches(); 
		int dis2 = (((Distance) o2).getFeet() * 12) + ((Distance) o2).getInches(); 
		int compared = 2;
	    if (dis1 == dis2) 
	    {
	        compared = 0;
	    }
	    
	    else if (dis1 > dis2) 
	    {
	        compared = 1;
	    }
	    
	    else if (dis1 < dis2)
	    {
	    	compared = -1;
	    }
	    return compared;
	}

	/*display the whole numbers for feet and inches with the symbols as labels.*/
	
	@Override public String toString()
	{
		return String.format("%d' %d\"", feet, inches );
	}
	
}