package list;
/**
 * 
 * @author Shane Tomasello
 *
 * @param <E>
 */

class ArrayListIterator<E> extends ArrayIterator<E> implements ListIterator<E>{
	
	private boolean forward = true;
	
	ArrayListIterator(List<E> list) {
		super (list);
	}
	
	ArrayListIterator (List<E> list, int start) {
		super(list);
		ndx = start -1;
	}
	
	public E next() {
		forward = true;
		return super.next();
	}
	
	/**
	 * Checks to see if there is a previous value in the ArrayList
	 * @return true if there is a previous value
	 */
	public boolean hasPrevious() {
		return ndx >= 0;
	}
	
	public E pervious() {
		forward = false;
		ndx--;
		return list.get(ndx+1);
	}
	/**
	 * Removes the current value during Iteration
	 */
	public void remove() {
		if(forward) {
			list.remove(ndx);
			ndx--;
		}
		else {
			list.remove(ndx+1);
		}
	}
	/**
	 * Moves the Iterator backwards to previous element
	 * @return previous value
	 */
	public E previous() {
		forward = false;
		ndx--;
		return list.get(ndx+1);
	}
	
	/**
	 * Adds a value in the point of iteration to the ArrayList
	 */
	public void add(E value) {
			next();
			list.add(ndx, value);
	}
}
