/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A04
*******************************************************/

package errorHandling;

public class EmptyLinkedListException extends Exception {
	
	/**
	 * This creates a custom exception to handle if the 
	 * list is empty.
	 */
	private static final long serialVersionUID = 1L;

	public EmptyLinkedListException ()
	{
		super ();
	}
	
	public EmptyLinkedListException (String s)
	{
		super (s);
	}

}
