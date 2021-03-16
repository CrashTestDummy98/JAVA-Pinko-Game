package set;

import list.Iterator;

/**
 * A collection with no duplicates. Ordering
 * of the values need not be maintained
 * 
 * @author Shane Tomasello
 * @version Nov 10, 2020
 * 
 */
public interface Set<E> {
	
	/**
	 * @return true iff this Set contains the given
	 * object.
	 */
	boolean contains(Object obj);
	
	/**
	 * Add the given value to this Set, if not already in
	 * this Set.
	 * @return true iff it was added.
	 */
	boolean add(E value);
	
	/**
	 * Remove the given object from this Set, if possible.
	 * @return true iff it was removed.
	 */
	boolean remove(Object obj);
	
	/**
	 * @return an Iterator for this Set
	 */
	Iterator<E> iterator();
	
	/**
	 * @return true iff obj is a Set which contains the same values as this Set,
	 * and only those values which are in this Set
	 */
	boolean equals(Object obj);
	
	/**
	 * Clear this Set
	 */
	void clear();
	
	/**
	 * @return true iff this Set is Empty
	 */
	boolean isEmpty();
	
	/**
	 * @return the number of values in the Set
	 */
	int size();

}
