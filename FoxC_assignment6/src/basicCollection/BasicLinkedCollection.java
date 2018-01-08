/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A06
*******************************************************/

package basicCollection;

import java.util.*;

public class BasicLinkedCollection <T> extends AbstractCollection<T> implements Cloneable
{
	private final static int DEFAULT_SIZE = 100;
	
	/**
	 * The array where the elements will be stored
	 */
	private T[] collection;
	
	/**
	 * The number of elements in the collection.
	 */
	private int size;
	
	/**
	 * This field will track the number of changes made, 
	 * to ensure that it is fail-safe.
	 */
	protected transient int modCount;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(collection);
		result = prime * result + size;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicLinkedCollection<T> other = (BasicLinkedCollection<T>) obj;
		if (!Arrays.equals(collection, other.collection))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	/**
	 * default constructor
	 */
	public BasicLinkedCollection()
	{
		 collection = (T[])(new Object[100]);
		 size = 0;
		 modCount = 0;
	}
	
	/**
	 * The constructor is initialized with a provided collection
	 * @param c
	 * @return
	 */
	public BasicLinkedCollection(Collection<? extends T> c)
	{
		if(c == null)
			throw new IllegalArgumentException();
		int size = c.size() > DEFAULT_SIZE ? (c.size() * 110)/100 : DEFAULT_SIZE;
		collection = (T[])new Object[DEFAULT_SIZE];
		c.toArray(collection);
		modCount = 0;
	}
	
	/**
	 * Checks that the collection has changed when a non-null item is added
	 * @return
	 */
	public boolean add(T element)
	{
		try
		{
			if (element == null)
			{
				throw new IllegalArgumentException();
			}
			//if the collection is at capacity make it bigger
			if (this.size == collection.length)
				resize(this.size + (this.size/ 2));
			collection[size] = element;
			size++;
			modCount++;
			return true;
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * remove an element
	 * @return
	 */
	public boolean remove(Object element)
	{
		try
		{
			if (element == null)
				throw new IllegalArgumentException();
			int p = find(element);
			if (p == -1) return false;
			for (int i = p; i < size - 1; i++)
				collection[i] = collection[i + 1];
			collection[size - 1] = null;
			size--;
			modCount++;
			return true;
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Creates and returns a copy of the object
	 * @return
	 */
	public Object clone()
	{
		BasicLinkedCollection<T> c = null;
		try
		{
			c = (BasicLinkedCollection<T>) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		c.collection = (T[]) this.collection.clone();
		return c;
	}
	
	/**
	 * returns the number of elements in the collection
	 * @return
	 */
	@Override
	public int size()
	{
		return size;
	}
	
	/**
	 * returns an iterator over the elements contained in this
	 * collection
	 */
	@Override
	public Iterator<T> iterator()
	{
		return new LinkedIterator ();
	}
	
	/**
	 * resizes the array
	 * @param new_length
	 */
	private void resize(int new_length)
	{
		T[] temp = (T[]) new Object[new_length];
		for(int i = 0; i < collection.length; i++)
		{
			temp[i] = collection[i];
			collection[i] = null;
		}
		collection = temp;
		
	}
	
	public boolean contains(Object target)
	{
		LinkedIterator iter = new LinkedIterator();
		while (iter.hasNext())
		{
			if (target.equals(iter.next()));
			{
				return true;
			}
		}
		return false;
			
	}
	
	private int find(Object element)
	{
		if(!contains(element))
			return -1;
		int i;
		for (i = 0; i < size; i++)
			if (element.equals(collection[i]))
					return i;
		return -1;
	}
	
	/**
	 * cursor accesses the next element in the sequence
	 * Cursor and modCount are also changed by this.
	 */
	private class LinkedIterator implements Iterator<T>
	{
		private int cursor;
		private int expectedModCount;
		/**
		 * In order to meet the contract of remove, this 
		 * call must have been preceded by a next.  Two calls 
		 * of remove before a next is called is not permissible 
		 * either.
		 */
		private boolean okToRemove;
		
		public LinkedIterator()
		{
			cursor = 0;
			expectedModCount = modCount;
			okToRemove = false;
		}
		
		public boolean hasNext()
		{
			return cursor != size;
		}
		
		public T next()
		{
			if (expectedModCount != modCount)
				throw new java.util.ConcurrentModificationException();
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			okToRemove = true;
			
			//get the element in the cursor's position
			T element = collection[cursor];
			//advance cursor
			cursor++;
			return element;
		}
		
		/**
		 * remove the element by the last call to next
		 */
		public void remove()
		{
			if (expectedModCount != modCount)
				throw new java.util.ConcurrentModificationException();
			if (!okToRemove)
				throw new IllegalStateException();
			
			okToRemove = false;
			
			--cursor;
			BasicLinkedCollection.this.remove (collection[cursor]);
			expectedModCount++;
		}
		
	}
	
}	
