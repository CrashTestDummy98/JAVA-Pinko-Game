package sort;



import list.List;
import list.ListIterator;

/**
 * 
 * @author Shane Tomasello
 * @version 10/5/20
 * 
 * Sort a LinkedList in time O(n^2), using a ListIterator.
 * This will be slow for an ArrayList.
 */

public class BubbleSortLinked<E extends Comparable> implements Sorter<E>{
	
	List<E> list;
	
	public void sort(List<E> list) {
		this.list = list;
		E left, right;		//Neighboring values
		ListIterator<E> itty;
		for(int i=0; i<list.size()-1; i++) {		//Same loop control
			itty = list.listIterator();
			right = itty.next();
			for(int j=0; j<list.size()-i-1; j++) {
				left = right;
				right = itty.next(); 	//Neighbors
				if(left.compareTo(right) > 0) {
					itty.remove();			//Swap left and right
					itty.previous();
					itty.add(right);
					right = itty.next();
				}
			}
				
		}
	}
}
