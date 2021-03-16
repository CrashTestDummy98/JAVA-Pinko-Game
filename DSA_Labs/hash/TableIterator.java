package hash;

import list.Iterator;

/**
 * A TableIterator permits the client to
 * iterate thru a HashTable.
 * 
 * @author Shane Tomasello
 * @version Nov 10, 2020
 * 
 */

 class TableIterator<K> implements Iterator<K> {
	
	HashTable<K> table;
	int ndx=0;				//current ArrayList index
	Iterator<K> itty;		//For a LinkedList
	
	TableIterator(HashTable<K> table) {
		this.table = table;
		setItty(ndx);
	}
	
	/**
	 * Set the iterator to the LinkedList at the given
	 * ndx in the ArrayList.
	 */
	private void setItty(int ndx) {
		itty = table.lists.get(ndx).iterator();
	}
	
	/**
	 * @return the index of the next non-empty
	 * LinkedList, or -1 if none.
	 */
	private int nextList() {
		for (int i=ndx+1; i<table.lists.size(); i++) {
			if(!table.lists.get(i).isEmpty())
				return i;
		}
		return -1;
	}
	
	public boolean hasNext() {
		if(itty.hasNext())
			return true;
		return nextList() > 0;
	}
	
	public K next() {
		if(!itty.hasNext()) {
			ndx = nextList();
			setItty(ndx);			//next non-empty list
		}
		return itty.next();
	}
	
	public void remove() {
		itty.remove();
		table.size--;
	}

	public boolean has2More() {
		return false;
	}

}
