/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A06
*******************************************************/

package unitTesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import distanceInfo.Distance;
import exceptions.EmptyLinkedListException;
import genericSLL.Node;
import genericSLL.SinglyLinkedList;

public class SLLTester {
	/**
	 * create fields to store 2 types of lists(numbers and words)
	 */
	private SinglyLinkedList <Integer> sll;
	private SinglyLinkedList <String> sllString;
	
	/**
	 * Default constructor that initializes the 2 singly linked lists
	 * with 3 nodes each.
	 */
	public SLLTester ()
	{
		sll = new SinglyLinkedList <Integer> ();
		sll.addToFront(5);
		sll.addToFront(10);
		sll.addToFront(20);
		sllString = new SinglyLinkedList <String> ();
		sllString.addToFront("cat");
		sllString.addToFront("dog");
		sllString.addToFront("unicorn");
	}
	
	/**
	 * tests the remove from front method for a list
	 * @throws EmptyLinkedListException 
	 */
	@Test
	public void testStringRemoveFromFront() throws EmptyLinkedListException 
	{
		int actualSize = sll.size();
		sll.removeFromFront();
		assertEquals((actualSize - 1), sll.size());
	}

	/**
	 * tests the constructor for the singly linked word
	 * list
	 */
	@Test
	public void testConstructor() 
	{
		SLLTester test = new SLLTester();
		assert(!sll.isEmpty());
		assertEquals(3, sll.size());
		assertEquals(3, sllString.size());
	}
	
	/**
	 * Tests that a node is added to the list
	 */
	@Test
	public void testAddToFront() 
	{
		Node<String> temp = new Node<String> ("five");
		sllString.addToFront(temp);
		assertEquals(4, sllString.size());
	}
	
	/**
	 * test that the default constructor can print a singly 
	 * linked list
	 */
	@Test
	public void testToString() 
	{
		assertEquals(20 + "\n" + 10 + "\n" + 5 + "\n", sll.toString());
		assertEquals("unicorn"  + "\n" + "dog"  + "\n" + "cat"  + "\n", sllString.toString());
	}
	
}