package list;
/**
 * 
 * @author Shane Tomasello
 *
 * @param <E>
 * 
 * A ListIterator specifically for LinkedLists
 */

	class RefListIterator<E> extends RefIterator<E> implements ListIterator<E> {
		
	/**
	 * cursor, in the superclass, is a reference 
	 * to the last value returned by a call to
	 * next() or previous().
	 */
		private boolean forward = true;
		//cursor refers to the last node obtained by a call to next or previous
	
		RefListIterator(LinkedList<E> list){
			super(list);
		}
	
		//@param start is starting position for iteration
		RefListIterator(LinkedList<E> list, int start){
			super(list);
			for (int i=0; i<start; i++) {
				cursor = cursor.next;
			}
		}
		
		public boolean hasNext() {
			if (list.isEmpty())
				return false;
			if (forward) 
				return cursor.next != list.tail;
			return true;
		}
		
		public E next() {
			
			if(forward) {
				cursor = cursor.next;
			}
			forward = true;
			return cursor.value;
			
		}
		
		public boolean hasPrevious() {
			if(!forward )
				return cursor.prev != list.head;
			return cursor != list.head;
		}
		
		public E previous() {
			if (!forward) 
				cursor = cursor.prev;
			forward = false;
			return cursor.value;
		}
		
		public void remove() {
			super.remove();
			if (forward) {
				cursor = cursor.prev;
			}
			else {
				cursor = cursor.next;
			}
		}
		
		/**
		 * Insert the given value just prior to the implicit cursor position. A subsequent 
		 * call to previous() should return the inserted value, and a subsequent call to next()
		 * should be unaffected.
		 */
		public void add(E value) {
			if(forward) {
				Node<E> temp = new Node<E>(value, cursor.next, cursor);
				cursor.next = temp;
				temp.next.prev = temp;
				cursor = cursor.next;
				
			}
			else { //going backwards
				Node<E> temp = new Node<E>(value, cursor, cursor.prev);
				temp.prev.next = temp;
				cursor.prev = temp;
			}
		list.size++;

		
		}
}
