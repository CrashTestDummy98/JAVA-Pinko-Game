package list;
/**
 * 
 * @author Shane Tomasello
 * @version 9/29/20
 */

public class LinkedList <E> implements List <E>{
	int size = 0;
	Node<E> head = new Node<E> (null, null, null);
	Node<E> tail = new Node<E>(null, null, head);
	private Node<E> ref;
	
	public LinkedList() {
		head.next = tail;
	}

	private void setRef(int ndx) {
		if (ndx < size/2) {
		ref = head.next;
			for (int i=0; i<ndx; i++) {
			ref=ref.next;
			}
		}
		else {
			ref = tail.prev;
			for (int i=size-1; i>ndx; i--) {
				ref=ref.prev;
			}
		}
	}
	
	public void add(E value) {
		Node<E> temp = new Node<E> (value, tail, tail.prev);
		tail.prev.next = temp;
		tail.prev = temp;
		size++;
	}
	
	public void add(int ndx, E value) {

			setRef(ndx);
			Node<E> temp = new Node<E> (value, ref, ref.prev);
			ref.prev.next = temp;
			ref.prev = temp;
			size++;

	}
	
	public E get(int ndx) {
		setRef(ndx);
		return ref.value;
	}
	
	public E set(int ndx, E value) {
		setRef(ndx);
		ref.value = value;
		E result = ref.value;
		return result;
	}
	
	public E remove(int ndx) {
		setRef(ndx);
		ref.next.prev = ref.prev;
		ref.prev.next = ref.next;
		size--;
		return ref.value;
		
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		head.next = tail;
		tail.prev = head;
		size = 0;
		
	}
	
	public boolean isEmpty() {
		if(size==0)
	           return true;
	       
	       return false;
	}

	
	public int indexOf(Object obj) {
		ref = head.next;
		for(int i=0; i<size; i++) {
			if(ref.value.equals(obj) )
				return i;
			else {
				ref = ref.next;
			}
		}
		return -1;
	}
	

	public boolean contains(Object obj) {
		boolean isTrue = false;
		if(!(this.indexOf(obj) == -1)) {
			isTrue = true;
		}
		return isTrue;
	}
	public String toString() {
		   String a = "[";
		   ref = head.next;
		   for (int i=0; i<=size-1; i++) {
			   if(i<size-1) {
				 a+=ref.value + ", ";
			   	 ref = ref.next;
			   }
			   else {
				   a+=ref.value;
			   }
			  
		   }
		   a+="]";
		   return a;
			
	   }
	
	public boolean remove(Object obj) {
		boolean isTrue;
		
		if (!(this.indexOf(obj) == -1)) {
			this.remove(indexOf(obj));
			isTrue = true;
		}
		else {
			isTrue = false;
		}
		return isTrue;
	}
	
	public int indexOfLast(Object obj) {
		ref = tail.prev;
		for(int i =size-1; i > 0; i--) {
			if(ref.value.equals(obj)) {
				return i;
			}
			else {
				ref = ref.prev;
			}
		}
		
		return -1;
	}
	public Iterator<E> iterator() {
		return new RefIterator<E> (this);
	}
	
	public ListIterator<E> listIterator() {
		return new RefListIterator<E> (this);
	}
	
	public ListIterator<E> listIterator(int start){
		return new RefListIterator<E> (this, start);
	}
	
	
	public boolean equals (Object obj) {
		boolean isTrue = true;
		Iterator<E> it = this.iterator();
		if(!(obj instanceof List)) {
			isTrue = false;
		}
		else {
			List otherList = (List)obj;
			Iterator<E> otherIt = otherList.iterator();
			while(it.hasNext()) {
				if(otherIt.hasNext() && it.next().equals(otherIt.next())) {
					isTrue = true;
				}
				else {
					isTrue = false;
					return isTrue;
				}
			}
		}
		return isTrue;
		
	}
	
	/**
	 * @return the position of the first occurrence of the given object
	 * in this ArrayList, or -1 if not found.
	 */
	public int indexOf(Object obj) {
		return indexOf(obj, head.next, 0);
	}
	
	//Recursive helper method
	private int indexOf(Object obj, Node<E> ref, int ctr) {
		if (ref == tail)		//Base case
			return -1;
		//Recursive case
		return indexOf (obj, ref.next, ctr+1);
	}
	
	public void addAll(List<E> a) {
		add(a.get(size-1));
	}
}
