package list;
/**
 * 
 * @author Shane Tomasello
 *
 * @param <E>
 */

public interface ListIterator<E> extends Iterator<E> {
	/**
	 * Searches List for a previous element and returns true if found.
	 * @return true if found.
	 */
	boolean hasPrevious();
	
	/**
	 * Iterates to the previous element with in a given list and returns the E.
	 * @return previous value
	 */
	public E previous();
	
	/**
	 * Insert the given value just prior to the implicit cursor position. A subsequent
	 * call to previous() should return the inserted value, and a subsequent call to the next()
	 * should be unaffected.
	 * @param value
	 */
	
	public void add(E value);


}
