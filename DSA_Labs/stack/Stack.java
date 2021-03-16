package stack;

import list.ArrayList;
import list.LinkedList;
import list.List;

/**
 * 
 * @author Shane Tomasello
 * @version 9/21/20
 * An implementation of the StackADT interface using a List.
 * CLient may opt for an ArrayList or a LinkedList.
 */

public class Stack<E> implements StackADT<E>{
	
	List<E> values = new ArrayList<E>();
	
	/**
	 * Default constructor.
	 * Use an ArrayList.
	 */
	public Stack() 
	{		}
	
	/**
	 * Constructor
	 * @param arrayBased	=>	Use an ArrayList
	 * 			!arrayBased		=>	Use a LinkedList.
	 */
	public Stack(boolean arrayBased) {
		if (!arrayBased) {
			values = new LinkedList<E>();
		}
	}
	
	public E push(E value) {
		values.add(value);
		return value;
	}
	
	public E pop() {
		return values.remove(values.size() - 1);
	}
	
	public E peek() {
		return values.get(values.size() - 1);
	}

	
	public boolean isEmpty() {
		return values.isEmpty();
	}

	
	public void clear() {
		values.clear();
		
	}

	
	public int size() {
		return values.size();
	}
	
	public String toString() {
		return values.toString();
	}

}
