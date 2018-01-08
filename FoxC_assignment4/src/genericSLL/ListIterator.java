/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A04
*******************************************************/

package genericSLL;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<E> implements Iterator<E> 
{
	private Node<E> nextNode;  
    private Node<E> lastReturnedNode;  
    private Node<E> previousNode;  
    private int removed = 0;  
  
    /**
     * Constructor for the list iterator assigns the 
     * node passed to the parameter as the next node
     * @param node
     */
    public ListIterator(Node<E> node)
    {  
        this.nextNode = node;  
    }   
     
    /**
     * Returns whether or not there is another
     * node in the list
     */
    public boolean hasNext ()  
    {  
        return nextNode != null;  
    }  
  
    /**
     * If the item is not found a no such element 
     * exception is thrown, but will iterate through 
     * the list as long as there are nodes.
     */
    public E next () throws NoSuchElementException  
    {  
        if (!this.hasNext ())  
        {
            throw new NoSuchElementException ("That item could not be found.");
        }
        
        else
        {
	        previousNode = lastReturnedNode;  
	        lastReturnedNode = nextNode;  
	        nextNode = nextNode.getNext();
        }
        
		return null;
   
    }  
  
    /**
     * If last returned node can't be set the state 
     * the remove is in is illegal and throws and exception
     */
    public void remove() throws IllegalStateException  
    {  
        removed++;  
        if (lastReturnedNode == null)
        {
            throw new IllegalStateException ("Improper iterator state for remove operation");  
        }  
        else
        {  
            lastReturnedNode = null;  
        }  

    }  
      
}
