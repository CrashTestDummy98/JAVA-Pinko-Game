package set;

import hash.HashTable;
import list.Iterator;

/**
 * An implementation of Set, using a HashTable
 * 
 * @author Shane Tomasello
 * @version Nov 10, 2020
 * @param <E>
 */

public class HashSet<E> implements Set<E>{
	
	HashTable<E> table = new HashTable<E>();
	
	public boolean add(E value) {
		if (table.containsKey(value))
			return false;					//no duplicates
		table.put(value);
		return true;
	}
	
	public boolean contains(Object obj) {
		return table.containsKey(obj);
	}
	
	public boolean remove(Object obj) {
		return table.remove(obj);
	}
	
	public Iterator<E> iterator() {
		return table.iterator();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Set)) {
			return false;
		}
		TreeSet set = (TreeSet) obj;
		if(set.size == this.table.size()) {
			Iterator<E> temp = this.iterator();
			while(temp.hasNext()) {
				if(!(set.contains(temp.next())))
					return false;
			}
			return true;
		}
		
	 return false;
	}
	
	public String toString() {
		String set = "";
		Iterator<E> temp = this.iterator();
		for(int i=0; i<table.size(); i++) {
			set+= table.get(temp.next());
			if(temp.hasNext()) {
				set += ", ";
			}
		}
		return set;
	}

	public void clear() {
		table.clear();
		
	}

	public boolean isEmpty() {
		return table.isEmpty();
	}

	public int size() {
		return table.size();
	}
	
}
