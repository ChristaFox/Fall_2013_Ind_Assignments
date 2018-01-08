/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A04
*******************************************************/

package genericSLL;

import errorHandling.DoesNotContainNode;
import errorHandling.EmptyLinkedListException;

/**
 *Start generic singly linked list class 
 */
public class SinglyLinkedList <T> 
{
	/**
	 *Create field to store the first item in the list.
	 */
	private Node <T> head;
	
	/**
	 *Create constructor
	 */
	public SinglyLinkedList ()
	{
		head = null;
	}
	
	/**
	 *Method used to see if the List Contains Nodes.
	 */
	public boolean isEmpty ()
	{
		return head == null;
	}
	
	/**
	 *Adds a node to the front of the singly linked list using data.
	 */
	public void addToFront (T data)
	{
		Node <T> temp = new Node <T> (data);
		this.addToFront(temp);
	}
	
	/**
	 *Adds a node to the front of the singly linked list using a node.
	 */
	public void addToFront (Node <T> temp)
	{

		if (isEmpty())
		{
			head = temp;
		}
		//not empty
		else
		{
			temp.setNext (head);
			head = temp;
		}
	}
	
	/**
	 * Takes a Singly Linked List in as the argument and finds a the first matching node
	 * in the Singly Linked List.
	 * @param <T>
	 * @return 
	 * @throws EmptyLinkedListException 
	 */
	public Node<T> find (T target) throws DoesNotContainNode, EmptyLinkedListException
	{

		Node<T> current = head;
			if (isEmpty())
			{
				throw new EmptyLinkedListException ("The linked list is empty.  Please add items to search for.");
			}
			else
			{
				while(!current.isLast())
				{
					if(current.getData().equals(target))
					{
						return current;
					}
					
					else
					{
						current = current.getNext();
					}					
				}
				
			}
			
			/**
			 * returns the node if it is found
			 */
			if (current.getData().equals(target)){
				return current;
			}
			
			/**
			 * provides the user with a message if the list 
			 * does not contain the node.
			 */
			else 
				throw new DoesNotContainNode ("This list did not contain that distance node.");
	}
	
	/**
	 * Removes the first item in the list, unless 
	 * the list is empty.
	 * @throws EmptyLinkedListException
	 */
	public void removeFromFront () throws EmptyLinkedListException
	{
		if (isEmpty())
		{
			throw new EmptyLinkedListException ("Cannot remove from an empty linked list");
		}
		else
		{
			head = head.getNext();
		}
		
	}
	
	/**
	 * returns the size of the singly linked
	 * list for jUnit tests
	 * @return
	 */
	public int size()
	{
		int s = 0;
		if (isEmpty())
		{
			return s;
		}
		else
		{
			Node <T> current = head;
			s++;
			while (!current.isLast())
			{
				current = current.getNext();
				s++;
				
			}
		}
		return s;
	}
	
	/**
	 * This will print all of the nodes in the list.
	 */
	public String toString ()
	{
		String answer = "";
		if (isEmpty())
		{
			answer = "SLL is empty";
		}
		else
		{
			Node <T> current = head;
			answer += current;
			while (!current.isLast())
			{
				current = current.getNext();
				answer += current;
				
			}
		}
		return answer;
	}

}
