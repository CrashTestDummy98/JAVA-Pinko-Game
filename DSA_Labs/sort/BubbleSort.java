package sort;

import list.List;

/**
 * 
 * @author Shane Tomasello
 * @version 10/5/20 
 * 
 * Implementation of the Bubble sort Algorithm
 */

public class BubbleSort<E extends Comparable> implements Sorter<E> {
	
	List<E> list;
	
	/**
	 * @param list of values to be sorted.
	 * Post: Items in the list will be arranged in
	 * increasing order
	 */
	public void sort(List<E> list) {
		this.list =list;
		for(int ndx=0; ndx<list.size()-1; ndx++) {
			boolean isSorting = false;
				for(int i=0; i<list.size()-ndx-1; i++) {
					if(list.get(i+1).compareTo(list.get(i))>0) {
						swap(i,i+1);		
						isSorting = true;
					}
				}
			
			if(!isSorting) {
				break;
			}
		}
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
