/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A04
*******************************************************/

package app;

import javax.management.InstanceNotFoundException;

import genericSLL.Node;
import genericSLL.SinglyLinkedList;

import distanceInfo.Distance;
import errorHandling.DoesNotContainNode;
import errorHandling.EmptyLinkedListException;

	/**
	 * begin app
	 */
public class SinglyLinkedListApp<T> 
{
	
	/**
	 * Field to store singly linked list
	 */
	private SinglyLinkedList<Distance> sll;
	
	/**
	 * Creates 5 hard-coded distance objects, 
	 */
	public SinglyLinkedListApp()
	{
		sll = new SinglyLinkedList<Distance>();
		Distance temp1 = new Distance();
		Distance temp2 = new Distance(0, 1);
	    Distance temp3 = new Distance(5, 5);
	    Distance temp4 = new Distance(1, 5);
	    Distance temp5 = new Distance(2, 10);
	    sll.addToFront(temp1);
	    sll.addToFront(temp2);
	    sll.addToFront(temp3);
	    sll.addToFront(temp4);
	    sll.addToFront(temp5);

	}
	
	/**
	 * Begin main
	 * @throws InstanceNotFoundException 
	 */
	public static void main(String[] args) throws InstanceNotFoundException 
	{
		SinglyLinkedListApp<Distance> sllApp = new SinglyLinkedListApp<Distance>();
		try
		{
			sllApp.makeAChoice();
		} 
		catch (EmptyLinkedListException e) 
		{
			e.printStackTrace();
		}
		
	/**
	 * end main
	 */
	}
	
	/**
	 * displays the menu utilizing the IO class file 
	 */
	public static void displayMenu() 
	{
	distanceInfo.IO.menu("1.\tAdd an item\n2.\tDelete an item\n3.\tFind an item\n4.\tDisplay the list\n5.\tExit\n", 
			1, 5);	
		
	}
	
	/**
	 * controls what each of the menu items do
	 * @throws EmptyLinkedListException 
	 * @throws InstanceNotFoundException 
	 */
	public void makeAChoice() throws EmptyLinkedListException, InstanceNotFoundException
	{
		int selection = 0;
		do
		{	
			displayMenu();
			
			switch(selection = distanceInfo.IO.getChoice()) 
			{
				case 1: addDistanceItem(sll);
						break;
				case 2:	removeFromList(sll);
						break;
				case 3:	find();
						break;
				case 4: System.out.println(sll.toString());
						break;
				case 5: System.exit(0);
				
			}
		
		}while(selection != 5);
	
	}
		
	/**
	 * takes a Singly Linked List in as the argument and removes the first item from the list.
	 */
	private void removeFromList(SinglyLinkedList<?> list) {
		try 
		{
			list.removeFromFront();
		}
		catch (EmptyLinkedListException e) 
		{
			e.printStackTrace();
		}
	}
	 
	private <T> void find()
	{

		try 
		{
			Node<Distance> n = sll.find(createTargetNode().getData());
			findMessage(n);
		} 
		catch (DoesNotContainNode | EmptyLinkedListException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Produces a message to let the user know if the item was found.
	 * @param result
	 */
	private void findMessage(Node<Distance> n)
	{
		if(n == null)
		{
			System.out.println("Item was not found");
		}
		else
		{
			System.out.printf("The distance item %s was found.", n.toString());
		}
	}
	
	/**
	 * Create a node item of type Distance to find
	 * @param <T>
	 * @return
	 */
	public Node<Distance> createTargetNode()
	{
		distanceInfo.IO.fetchIntInput("Please select the feet for the target distance item", 
				0, Integer.MAX_VALUE);
		int feet = distanceInfo.IO.getChoice();
		distanceInfo.IO.fetchIntInput("Please select the inches for the target distance item", 
				0, Integer.MAX_VALUE);
		int inches = distanceInfo.IO.getChoice();
		Distance dis = new Distance(feet, inches);
		Node<Distance> tar = new Node<Distance>(dis);
		return (Node<Distance>) tar;
	}
	
	/**
	 * Takes a Singly Linked List in as the argument.  
	 * Adds the new object to the front of the list.
	 */
	private void addDistanceItem(SinglyLinkedList<Distance> l) 
	{
		distanceInfo.IO.fetchIntInput("Please select the amount of feet for your distance item", 
				0, Integer.MAX_VALUE);
		int feet = distanceInfo.IO.getChoice();
		distanceInfo.IO.fetchIntInput("Please select the amount of inches for your distance item", 
				0, Integer.MAX_VALUE);
		int inches = distanceInfo.IO.getChoice();
		Distance dis = new Distance(feet, inches);
		genericSLL.Node<Distance> temp = new genericSLL.Node<Distance>(dis);
		l.addToFront(temp);
		System.out.printf("You have added %s.", temp.toString());	
	}
	
	/**
	 * end app
	 */
}

