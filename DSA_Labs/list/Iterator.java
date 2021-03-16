package list;
/**
 * 
 * @author Shane Tomasello
 *
 * @param <E>
 */

public interface Iterator<E> {
	
	boolean hasNext();
	
	E next();
	
	void remove();
	
	/**
	 * @return true iff there are at least two more values
	 * to be obtained
	 */
	boolean has2More();
	
	/** Remove the last value obtained by a call to

	  * next(), and the following value.

	  * Pre: There are two such values remaining in the List

	  * Pre:  The next() method has been called at least once since the last call to remove() or remove2()

	  */

	void remove2();

}
