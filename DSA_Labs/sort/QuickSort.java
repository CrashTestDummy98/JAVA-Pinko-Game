package sort;

import list.List;


/**
 * @author Shane Tomasello
 * @version 10/13/20
 * 
 * Implementation of the QuickSort Algorithm 
 */

public class QuickSort<E extends Comparable> implements Sorter<E> {
	List<E> list;
	
	public void sort(List<E> list) {
		this.list = list;
		qSort(0, list.size()-1);
	}
	
	private void qSort(int start, int end) {
		if (start >= end)		//Base case
			return;
		int p = partition (start, end);
		qSort(start,p-1);		//Left part
		qSort(p+1,end);			//Right part
	}
	
	/**
	 * Partition the value from start to end about a pivot value.
	 * @param start
	 * @param end
	 * @return the pivot position.
	 */
	public int  partition(int start, int end) {
		int mid = (start+end)/2;  		//pivot position
		int p = start;
		E pivot = list.get(mid);			//pivot value
		list.set(mid, list.get(start));
		for (int i=start+1; i<=end; i++) {
			if (pivot.compareTo(list.get(i))>0) {
				list.set(p,list.get(i));
				p++;
				list.set(i, list.get(p));
			}
		}
		list.set(p, pivot);			//Put pivot back into the list.
		return p;
	}

}
