package unitTesting;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import exceptions.EmptyLinkedListException;

import basicCollection.BasicLinkedCollection;
import junit.framework.TestCase;

public class BasicLinkedCollectionTester<T> extends TestCase
{
	/**
	 * Create the test fixture and fields to test
	 */
	private BasicLinkedCollection<String> c;
	private BasicLinkedCollection<String> cEmpty;
	Iterator iter;
	/**
	 * Creates a constructor that calls super
	 */
	public BasicLinkedCollectionTester(String name)
	{
		super(name);
	}
	
	/**
	 * Instantiates data to test
	 */
	public void setUp()
	{
		c = new BasicLinkedCollection<String>();
		c.add(new String("A"));
		c.add(new String("B"));
		c.add(new String("C"));
		cEmpty = new BasicLinkedCollection<String>();
	}
	
	/**
	 * resets the field c when the test is complete.
	 */
	public void tearDown()
	{
		c = null;
	}
	
	/**
	 * Tests if the default constructor will instantiate correctly
	 * (that it is empty)
	 */
	@Test (expected = EmptyLinkedListException.class)
	public void testDefaultConstructor()
	{
		assertTrue(cEmpty.isEmpty());	
	}
	
	/**
	 * Tests if the parameterized constructor will instantiate 
	 * correctly
	 */
	public void testParameterizedConstructor1()
	{
		assertFalse(c.isEmpty());
	}
	
	/**
	 * Tests if the parameterized constructor has the 
	 * correct amount of elements
	 */
	public void testParameterizedConstructor2()
	{
		assertEquals(3, c.size());
	}
	
	/**
	 * tests that an empty collection returns a size
	 * of 0
	 */
	public void testSize1()
	{
		assertEquals(0, cEmpty.size());
	}
	
	/**
	 * tests that a collection returns the right size
	 */
	public void testSize2()
	{
		assertEquals(3, c.size());
	}
	
	/**
	 * test iterator method for an empty collection
	 */
	public void testIteratorEmptyCollection1()
	{
		iter = cEmpty.iterator();
		assertFalse(iter.hasNext());
	}
	
	/**
	 * test iterator method for a collection
	 */
	public void testIteratorEmptyCollection2()
	{
		iter = c.iterator();
		assertTrue(iter.hasNext());
	}
	
	/**
	 * test add method with a null object
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAddNull()
	{
		c.add(null);
		assertEquals(3, c.size());
	}
	
	/**
	 * test add method
	 */
	public void testAddElement()
	{
		c.add("D");
		assertEquals(4, c.size());
	}
	
	/**
	 * test remove a null element
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testRemoveNullElement()
	{
		c.remove(null);
	}
	
	/**
	 * test remove the head of the collection
	 */
	public void testRemoveAtHead()
	{
		c.remove("A");
		assertEquals("[B, C]", c.toString());
	}
	
	/**
	 * test remove the tail element
	 */
	public void testRemoveTail()
	{
		c.remove("C");
		assertEquals("[A, B]", c.toString());
	}
	
	/**
	 * test remove the middle object
	 */
	public void testRemoveMiddle()
	{
		c.remove("B");
		assertEquals("[A, C]", c.toString());
	}
	
	/**
	 * test that objects that are not in the collection 
	 * can't be removed
	 */
	public void testRemoveMissingObject()
	{
		c.remove("missing");
		assertEquals("[A, B, C]", c.toString());
	}
	
	/**
	 * test hasNext with an empty collection
	 */
	public void testEmptyCollectionHasNext()
	{
		iter = cEmpty.iterator();
		assertFalse(iter.hasNext());
	}
	
	/**
	 * test hasNext when there are more items
	 */
	public void testHasNextWithCollection()
	{
		iter = c.iterator();
		assertTrue(iter.hasNext());
	}
	
	/**
	 * test hasNext when there no more items
	 */
	public void testHasNextWithCollectionTail()
	{
		iter = c.iterator();
		for (int i = 0; i < c.size(); i++)
		{
			iter.next();
		}
		assertFalse(iter.hasNext());
	}
	
	/**
	 * test boolean isEmpty()
	 * @return
	 */
	public void testBooleanIsEmpty()
	{
		assertTrue(cEmpty.isEmpty());
	}
	
	/**
	 * test that addAll will add all of the String elements
	 * @return
	 */
	public void testAddAll()
	{
		c.addAll(Arrays.asList("red", "cat", "dog"));
		assertEquals(6, c.size());
		assertEquals("[A, B, C, red, cat, dog]", c.toString());
	}
	
	/**
	 * test that removeAll will remove all of the String elements
	 * @return
	 */
	public void testRemoveAll()
	{
		c.removeAll(c);
		assertTrue(c.isEmpty());
		assertEquals("[]", c.toString());
		assertEquals(0, c.size());
	}
	
	/**
	 * compares the size and toStrings() of a collections
	 * that are created by using a toArray vs. using a 
	 * BasicLinkedCollection 
	 * @return
	 */
	public void CheckStringCollectionToArray()
	{
	    BasicLinkedCollection<String> blc = new BasicLinkedCollection<>();
	    blc.add("red");
	    blc.add("door");
	    blc.add("window");
	    Object[] AsArray = blc.toArray();
	    assertEquals(blc.size(), AsArray.length); 
	    assertEquals(blc.toString(), AsArray.toString());
	}
	
	/**
	 * T [ ] toArray (T [ ])
	 */
	public void StringCollectionToAndFromArray()
	{
		String[] countryTestArr = new String[] 
				{ "New Zealand", "Australia", "United States", "England", "India" };
		AbstractCollection<T> countryTestCol = new BasicLinkedCollection<T>();
		assertEquals(countryTestCol.toString(), countryTestArr.toString());
		Object[] countryTestArr2 = countryTestCol.toArray();
		for (int i = 0; i < countryTestArr2.length; i++)
		{ 
			assertEquals(countryTestArr2[i], countryTestArr[i]);
		}
	}
	
	/**
	 * Test that you can clear all of the elements of 
	 * the collection.
	 * @param o
	 * @return
	 */
	public void testClear()
	{
		c.clear();
		assertTrue(c.isEmpty());
		assertEquals(0, c.size());
	}
	
	/**
	 * Checks whether an element is contained 
	 * in the collection.
	 * @return
	 */
	public void testContains()
	{
		assertTrue(c.contains("A"));
	}
	
	/**
	 * Checks to see if all of the elements in each
	 * collection are the same.
	 * @return
	 */
	public void testContainsAll()
	{
		cEmpty.add("A");
		cEmpty.add("B");
		cEmpty.add("C");
		assertTrue(c.containsAll(cEmpty));
	}
	
	/**
	 * Will check of only the retained items are kept
	 * in a collection.
	 * boolean retainAll (Collection <? extends T>)
	 */
	public void testRetainAll()
	{
		cEmpty.addAll(c);
		cEmpty.add("hello");
		cEmpty.add("name");
		assertEquals(5, cEmpty.size());
		c.retainAll(cEmpty);
	}
	
}
