package queue;

import list.LinkedList;
import list.List;

/**
 * An implementation  of the QueueADT interface,
 * using a LinkedList
 * @author Shane Tomasello
 * @version 9/23/20
 */

public class Queue<E> implements QueueADT<E>{
	
	List<E> values = new LinkedList<E>();
	
	//front is at position 0	 (head)
	//back is at position size-1 (tail)
	
	/**
	 * Adds a value at the end of the queue to the linked list.
	 */
	public void add(E value) {
		values.add(value);
	}
	
	/**
	 * @return value at position 0 to be removed
	 */
	public E remove() {
		return values.remove(0);
	}
	
	/** 
	 * @return null if empty or returns position zero.
	 */
	public E peek() {
		if (values.isEmpty()) {
			return null;
		}
		return values.get(0);
	}

	
	public int size() {
		return values.size();
	}

	public void clear() {
		values.clear();
	}

	public boolean isEmpty() {
		return values.isEmpty();
	}
	
	public String toString() {
		return values.toString();
	}

	@Override
	public List<E> getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}
