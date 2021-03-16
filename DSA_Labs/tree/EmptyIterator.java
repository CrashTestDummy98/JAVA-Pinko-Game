package tree;

import list.Iterator;

public class EmptyIterator<E> implements Iterator<E> {


	public boolean hasNext() {
		return false;
	}


	public E next() {
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean has2More() {
		// TODO Auto-generated method stub
		return false;
	}

}
