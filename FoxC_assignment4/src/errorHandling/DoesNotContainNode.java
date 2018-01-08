/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A04
*******************************************************/

package errorHandling;

public class DoesNotContainNode extends Exception {

	/**
	 * If the node is not found throw this exception
	 */
	private static final long serialVersionUID = 7698654084922498127L;

	/**
	 * default returns a null exception
	 */
	public DoesNotContainNode ()
	{
		super ();
	}
	
	/**
	 * return the exception and the reason
	 * @param s
	 */
	public DoesNotContainNode (String s)
	{
		super (s);
	}
	
	

}
