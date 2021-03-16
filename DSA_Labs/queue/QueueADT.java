package queue;

import graph.Flight;
import list.List;

/**
 * A First-in First-out List.
 * @author Shane Tomasello
 * @version 9/23/20
 */

public interface QueueADT<E> {
	
	/**
	 * Add the given value at the back of this QueueADT
	 */
	void add (E value);
	
	/**
	 * Remove the value which is aat the front of this QueueADT.
	 * @return The value which was removed.
	 * Pre: This QueueADT is not empty.
	 */
	E remove();
	
	/**
	 * @return the value which as at the front of this QueueADT,
	 * or null if this QueueADT is empty.
	 */
	E peek();
	
	/**
	 * @return the size of the QueueADT
	 */
	int size();
	
	/**
	 * Clear this QueueADT
	 */
	void clear();
	
	/**
	 * @return true iff this QueueADT is Empty
	 */
	boolean isEmpty();
	
	/**
	 * @return a String with a toString method
	 */
	String toString();

	List<E> getValues();

}
