package list;
/**
 * An ADT for the Collection in which
 * duplicates are permitted, and order
 * is Maintained
 * @author Shane Tomasello
 * @version (9/3/20)
 */
public interface List <E>{
	/**
	 * @return the value at the given index in this List 
	 * @param 0 <= ndx < size
	 */
	E get(int ndx);
	
	/** 
	 * Set the value at the given index
	 * to the given value.
	 * @return the old value
	 * @param 0 <= ndx < size
	 */
	E set (int ndx, E value);
	
	/**
	 * Add the given value at the end of
	 * this List.
	 */
	void add (E value);
	
	/**
	 * Insert the given value at the given
	 * index in this List
	 * @param 0 <= ndx <= size
	 */
	void add (int ndx, E value);
	
	/** 
	 * Remove the value at the given index from
	 * this List.
	 * @return the Value which was removed.
	 * @param 0 <= ndx < size.
	 */
	E remove (int ndx);
	
	/**
	 * @return the size of the List
	 */
	int size();
	
	/**
	 * Clear List
	 */
	void clear();
	
	/**
	 * @return if List is empty
	 */
	boolean isEmpty();
	
	/** 
	 * @ return the position of the first occurrence of the given Object in this List,
	 * or -1 if it is not in this List
	 */
	int indexOf(Object obj);
	
	/** 
	 * @return only if the given Obj is with in List
	 */
	boolean contains(Object obj);
	
	boolean remove (Object obj);
	
	//int indexOfLast(Object obj);
	
	Iterator<E> iterator();
	
	public ListIterator<E> listIterator();
	
	public ListIterator<E> listIterator(int start);
	
	/**@return true only if the parameter obj is a List and contains the same 
	 * elements   
	 *   * (in the same sequence) as this List.     */
	boolean equals (Object obj);
	
	/**
	 * Add all values from the given list to this list
	 * @param list
	 */
	void addAll(List<E> list);
}
