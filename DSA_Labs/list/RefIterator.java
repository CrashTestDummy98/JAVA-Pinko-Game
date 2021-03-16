package list;

class RefIterator<E> implements Iterator<E> {
	LinkedList<E> list;
	Node<E> cursor;  //Reference to the last node obtained by next

	
	RefIterator(LinkedList<E> list) {
		this.list = list;
		cursor =list.head;
	}
	
	public boolean hasNext() {
		return cursor.next != list.tail;
	}
	
	public E next()
	{
		cursor = cursor.next;
		return cursor.value;
	}
	
	public void remove() {
		cursor.prev.next = cursor.next;
		cursor.next.prev = cursor.prev;
		list.size--;
	}
	
	public boolean has2More() {
		boolean isTrue = false;
		if(hasNext()) {
			cursor = cursor.next;
			if(hasNext()) {
				cursor = cursor.prev;
				isTrue = true;
			}
		}
		return isTrue;
	}
	
	public void remove2() {
		remove();
		next();
		remove();
	}
}
