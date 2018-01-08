/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A06
*******************************************************/

package distanceInfo;

import java.util.Comparator;

/**
 * Distance class with feet and inches
 */
public class Distance implements Comparator<Distance>
{

	private int feet;
	private int inches;
	private final int DEFAULT_IN = 1;
	private final int DEFAULT_FT = 1;

	/**
	 * constructor uses final int values of 1 and 1
	 */	
	public Distance()
	{
		inches = DEFAULT_IN;
		feet = DEFAULT_FT;
	}

	/**
	 *constructor uses set method to catch negative numbers,
	 *and replace them with default values
	 */	
	public Distance( int ft, int in )
	{
		setFeet(ft);
		setInches(in);
	
	}
	
	/** 
	 * Set feet with non-negative integers.  
	 * If they are negative Illegal Argument Exception is thrown.
	 */
	private void setFeet(int ft)
	{
		if(ft < 0)
		{
			throw new IllegalArgumentException("Can't set a negative number.");
		}
		else
		{
			feet = ft;
		}
	}
	
	/** 
	 * Set inches with non-negative integers.
	 * If they are negative  Illegal Argument Exception is thrown.
	 */
	private void setInches(int in) 
	{
		if(in < 0)
		{
			throw new IllegalArgumentException("Can't set a negative number.");
		}
		else
		{
			inches = in;
		}
	}
	
	/**
	 * get private int for feet
	 */
	public int getFeet() {
		return this.feet;
	}

	/**
	 * get private int for inches
	 */
	public int getInches() 
	{
		return this.inches;
	}
	

	/**
	 *Method to add two distance objects in inches,
	 *and then converts them back to feet and inches
	 */
	public Distance addDistance(Distance a, Distance b)
	{
		int add = ((a.getFeet() + b.getFeet()) * 12);
		int c = (add + a.getInches() + b.getInches());
		feet = (c / 12);
		inches = (c % 12);
		Distance added = new Distance(feet, inches);
		return added;
		
	}
	
	/**
	 *Method to subtract two distance objects in inches,
	 *and then converts them back to feet and inches
	 */
	public Distance subDistance(Distance a, Distance b){
		int sub = ((a.getFeet() - b.getFeet()) * 12);
		int sub1 = (a.getInches() - b.getInches());
		int addSub = (sub + sub1);
		feet = (addSub / 12);
		inches = (addSub % 12);
		Distance subItem = new Distance(feet, inches);
		return subItem;

	}
	
	/**
	 * Computer's attempt at a unique code, which may sometimes fail.
	 */
	@Override
	public int hashCode() 
	{
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
	
	/**
	 * compareTo() - compares two distance objects ( <, > )
	 */
	@Override
	public int compare(Distance o1, Distance o2) 
	{
		int one = (o1.getFeet()*12 + o1.getInches());
		int two = (o2.getFeet()*12 + o2.getInches());
		if(one > two)
		{
			return 1;
		}
		else if(one == two)
		{
			return 0;
		}
		else
		{
			return -1;
		}
		
	}
	

	/*display the whole numbers for feet and inches with the symbols as labels.*/
	
	@Override public String toString()
	{
		return String.format("%d' %d\"", feet, inches );
	}

}
