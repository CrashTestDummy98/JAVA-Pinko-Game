package list;

class ArrayIterator<E> implements Iterator<E>{
	
	List<E> list;
	
	int ndx = -1;
	
	ArrayIterator(List<E> list){
		this.list = list;
	}
	
	public boolean hasNext() {
		return ndx < list.size()-1;
	}
	
	public E next() {
		ndx++;
		return list.get(ndx);
	}
	
	public void remove() {
		list.remove(ndx);
		ndx--;
	}
	 public boolean has2More() {
		 int i = ndx;
		 boolean isTrue = false;
		 if(hasNext()) {
			 next();
			 if(hasNext()) {
				 ndx = i;
				 isTrue = true;
			 }
		 }
		 return isTrue;
	 }
	 
	 public void remove2() {
		 int i = ndx;
		 if(hasNext()) {
			 ndx--;
			 next();
			 list.remove(ndx);
			 ndx--;
			 list.remove(i);
		 }
	 }

}
