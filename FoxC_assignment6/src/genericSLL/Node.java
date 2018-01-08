/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A06
*******************************************************/

package genericSLL;

public class Node <T> 
{
	/**
	 * creates 3 feilds to store the data passed to the node, 
	 * the reference or next node, and the node element.
	 */
	private Node <T> next;
	private T data;
	private Node<T> element;
	
	/**
	 * creates a default node that will initialize without having 
	 * a next or data
	 * @param n
	 */
	public Node (T n)
	{
		data = n;
		next = null;
	}
	
	/**
	 * sets which node will be next in the list or the reference to it
	 * in the node
	 * @param n
	 */
	public void setNext (Node <T> n)
	{
		next = n;
	}
	
	/**
	 * returns the next node
	 * @return
	 */
	public Node <T> getNext ()
	{
		return next;
	}
	
	
	/**
	 * assigns that the toString should print the data 
	 * passed to the node.
	 */
	public String toString ()
	{
		return data + "\n";
	}
	
	/**
	 * If the next node is not available; you are at the 
	 * end of the list.  This states whether or not this 
	 * is a true statement.
	 * @return
	 */
	public boolean isLast ()
	{
		return next == null;
	}

	/**
	 * returns the data stored in the node.
	 * @return
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * returns the node
	 * @return
	 */
	public Node<T> getElement() 
	{
		return element;
	}

	/**
	 * sets an element
	 * @param element
	 */
	public void setElement(Node<T> element) 
	{
		this.element = element;
	}	

}
