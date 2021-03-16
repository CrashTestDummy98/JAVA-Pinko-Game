package queue;

import list.ArrayList;
import list.List;

/**
 * An implementation of the QueueADT interface,
 * using ArrayList
 * @author Shane Tomasello
 * @version 9/23/20
 *
 */

public class ArrayQueue<E> implements QueueADT<E> {
	
	List<E> values = new ArrayList<E>();
	
	int front=0;
	int back=0;
	int size=0;
	
	public void add(E value) {
		if (size==values.size()) {					//ArrayList is full?
			values.add(back, value);				//Insert
			front = (front+1) % values.size();		//Wrap around
		}
		else
			values.set(back, value); 				//Clobber
		back = (back+1) % values.size(); 			//Wrap around
		size++;
	}
	
	public E remove() {
		E result = values.get(front);
		front = (front+1) % values.size();
		size--;
		return result;
	}
	
	public E peek() {
		if(size>0)
			return values.get(front);
		return null;
	}

	public int size() {
		return values.size();
	}

	public void clear() {
		values.clear();
		size = 0;
	}

	public boolean isEmpty() {
		return values.isEmpty();
	}
	
	public String toString() {
		String a = "";
		int index = (front+1) % values.size();
		a+= values.get(front);
		for(int i = 0; i<size-1; i++) {
			a+= ", ";
			a+=values.get(index);
			index = (index+1) % values.size();
		}
		
		return "[" + a +"]";
	}

	@Override
	public List<E> getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}
