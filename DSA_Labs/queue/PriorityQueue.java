package queue;

import graph.Airport;
import list.ArrayList;
import list.Iterator;
import list.List;

/**
 * A PriorityQueue is a Queue, in which each item has
 * a priority. When removing, the value with the highest
 * priority is removed (not FIFO)
 * 
 * @author Shane Tomasello
 * @version Nov 24, 2020
 */
public class PriorityQueue<E extends Comparable> implements QueueADT<E> {
	List <E> values = new ArrayList<E> ();
	
	public E remove () {
		E result = values.get(0);		//Hightest priority
		int last = values.size() - 1;
		int avail = 0;					//Position of an available slot.
		int bc = biggerChild(0);		//Position of a bigger child.
		while (2*avail+1 < last && greater(bc, last)) {
			values.set(avail, values.get(bc));
			avail = bc;					//avail moves down
			bc = biggerChild(avail);
		}
		values.set(avail, values.get(last));
		values.remove(last); 
		return result;
	}
	
	public void add(E value) {
		int added, parent;
		values.add(value);
		added = values.size() -1;
		parent = (added-1) / 2;
		while (added>0 && greater (added,parent)) {
			swap (added,parent);			//Added moves up
			added = parent;
			parent = (added-1) / 2;
		}
	}
	
	/**
	 * @return position of parent's bigger child
	 */
	private int biggerChild (int parent) {
		int left = 2*parent + 1,			//left Child
				right = left + 1;
		if(right >= values.size())			//has a right child?
			return left;					//No
		if(greater (left, right))			//left > right?
			return left;					
		return right;
	}
	
	/**
	 * @return true iff the values at position x is
	 * greater than the value at position y
	 */
	private boolean greater (int x, int y) {
		return values.get(x).compareTo(values.get(y)) > 0;
	}
	
	private void swap(int x, int y) {
		E temp = values.get(x);
		values.set(x, values.get(y));
		values.set(y, temp);
	}
	
	public E peek() {
		if (values.isEmpty()) 
			return null;
		return values.get(0);
	}

	public int size() {
		return values.size();
	}

	public void clear() {
		values.clear();
	}

	public boolean isEmpty() {
		return values.isEmpty();
	}
	
	public String toString() {
		String a = "[";
		for(int i=0; i<values.size(); i++) {
			a += values.get(i);
			if(i<values.size()-1)
				a += ", ";
		}
		return a += "]";
	}

	public Iterator<E> iterator() {
		return values.iterator();
	}
	
	public List<E> getValues() {
		List<E> temp = new ArrayList<E>();
		Iterator<E> it = this.iterator();
		while(it.hasNext()) {
			temp.add(it.next());
		}
		return temp;
	}

}
