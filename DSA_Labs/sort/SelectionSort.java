package sort;

import list.List;

/**
 * 
 * @author Shane Tomasello
 * @version 10/5/20
 * 
 *Implementation of the Selection Sort Algorithm
 */

public class SelectionSort<E extends Comparable> implements Sorter<E> {
	
	List<E> list;
	
	/**
	 * @param list of values to be sorted.
	 * Post: Items in the list will be arranged in increasing order
	 */
	public void sort (List<E> list) {
		this.list = list;
		for(int ndx = 0; ndx<list.size()-1; ndx++) {
			swap(posSmallest(ndx),ndx);
		}
	}
	
	/**
	 * @return position of the smallest item from
	 * the given start position to the end of the
	 * list.
	 */
	private int posSmallest(int start) {
		int result = start;
		for(int i = start+1; i<list.size(); i++)
			if(list.get(i).compareTo(list.get(result))<0)
				result=i;
		return result;
				
	}
	
	/**
	 * Exchange the item at the given positions in the list
	 */
	private void swap(int x, int y) {
		E temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	}
}
