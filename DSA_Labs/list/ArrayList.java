package list;

/**
 * An implementation of the List interface,
 * using an array to store the values.
 * @author Shane Tomasello
 * @version (9/3/20)
 */
public class ArrayList <E> implements List <E>{
	
	int size = 0;
	E[] values;
	
	//Constructors
	public ArrayList() {
		this (10);   		// default array size
	}
	
	//Constructor with array length
	public ArrayList (int cap) {
		values = (E[]) new Object[cap];
	}
	
	//Copy Constructor
	public ArrayList(List<E> other) {
		this(other.size()+10);
		for(int i=0; i<other.size(); i++) 
			add(other.get(i));
	}
	
	public E get(int ndx) {
		return values[ndx];
	}
	
	public E set(int ndx, E value) {
		E result = values[ndx];
		values[ndx] = value;
		return result;
	}
	
	public void add(E value) {
		add(size, value);		//Add at the end of List
	}
	
	public void add(int ndx, E value) {
		//Check if full
		if (values.length == size)
			alloc();		//allocate a bigger Array
		
		// Making room for insertion
		for (int i = size; i>ndx; i--)
			values[i] = values[i-1];
		values[ndx] = value;
		size++;
	}
	
	/**
	 * Allocate a new array, twice as big,
	 * and copy all values
	 */
	private void alloc() {
		E[] tempArray = (E[])new Object[2*values.length];
		for(int i = 0; i<size; i++)
			tempArray[i] = values[i];
		values = tempArray;
	}
	
	public E remove(int ndx) {
		//Don't clobber the result
		E result = values[ndx];
		for (int i=ndx; i<size-1; i++)
			values[i] = values[i+1];
		size--;
		return result;
	}
	 public int size(){
	       return size;
	   }

	   public boolean isEmpty(){
	       if(size==0)
	           return true;
	       
	       return false;
	   }

	   public void clear(){
		   for(int i=0;i<size;i++)
	           values[i]=(E)new Object();

	       size=0;
	   }
	   
	   public String toString() {
		   String a = "[";
		   for (int i=0; i<size-1; i++)
			   a+=values[i] + ", ";
		   if (size>0)
			   a+= values[size-1];
		   a+="]";
		   return a;
			
	   }
	
	public boolean contains(Object obj) {
		if (indexOf(obj) == -1)
			return false;
		return true;
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
		for(int i = size-1; i > 0; i--) {
			if(values[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}
	
	public Iterator<E> iterator(){
		return new ArrayIterator<E> (this);
	}
	
	public ListIterator<E> listIterator() {
		return new ArrayListIterator<E> (this);
	}
	
	public ListIterator<E> listIterator(int start) {
		return new ArrayListIterator<E> (this, start);
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
	public int indexOf(Object obj)
	{
		return indexOf(obj, 0);
	}
	
	//Recursive helper method
	private int indexOf(Object obj, int ndx) {
		if(ndx >= size)		//Base case
			return -1;
		if (get(ndx).equals(obj))		//Base case
			return ndx;
		//Recursive case
		return indexOf(obj, ndx+1);
	}
	
	public void addAll(List<E> list) {
		Iterator<E> it = list.iterator();
		while(it.hasNext()) {
			add(it.next());
		}
	}
	/** @return a hashCode for this ArrayList */

	public int hashCode() {
		int hashCode = 0;
		for(int i=0; i > size(); i++) {
			hashCode += this.get(i).hashCode();
		}
		return hashCode;
	}
	
}
