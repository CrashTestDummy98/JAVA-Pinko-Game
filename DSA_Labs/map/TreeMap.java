package map;

import list.Iterator;
import set.HashSet;
import set.Set;
import set.TreeSet;
import tree.BinaryTree;
import tree.EmptyBinarySearchTree;

/**
 * An implementation of the Map interface using a Binary
 * Tree of entries.
 * 
 * @author Shane Tomasello
 * @version Nov 17, 2020
 */

public class TreeMap <K extends Comparable, V> implements Map <K,V> {
	
	//Inner class to define an Entry
	class Entry <K extends Comparable,V> implements Comparable <Entry<K,V>> {
		K key;
		V value;
		
		Entry (K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		/**
		 * @return a positive int if this Entry is greater than other, 
		 * return 0 if this Entry equals other,
		 * return a negative int if this Entry is less than other.
		 */
		public int compareTo (Entry<K,V> other) {
			return key.compareTo(other.key);
		}
		
		public String toString() {
			return key + "=" + value;
		}
		//End of inner class Entry
	}
	
	BinaryTree <Entry<K,V>> tree = new EmptyBinarySearchTree ();
	int size = 0;

	public boolean containsKey(K key) {
		Entry<K,V> entry = new Entry<K,V> (key,null);
		return tree.containsKey(entry);
	}

	public V get(K key) {
		Entry<K,V> entry = new Entry<K,V> (key,null);
		entry = tree.get(entry);
		if(entry == null)				//Not found in the tree;
			return null;
		return entry.value;				//Yes, return the value;
	}

	public V put(K key, V value) {
		Entry<K,V> newEntry = new Entry<K,V> (key, value),
				oldEntry = tree.get(newEntry);
		if (oldEntry == null) {				//Key not found in the tree?
			tree = tree.add(newEntry);
			size++;
			return null;
		}
		V oldValue = oldEntry.value;
		oldEntry.value = value;				//Change the entry's value
		return oldValue;
	}

	public V remove(K key) {
		Entry<K,V> entry = new Entry<K,V> (key, null);
		entry = tree.get(entry);
		if (entry == null) 
			return null;
		size--;
		tree = tree.remove(entry);
		return entry.value;
	}

	public void clear() {
		tree = new EmptyBinarySearchTree ();
	}

	public boolean isEmpty() {
		return tree.isEmpty();
	}

	public int size() {
		return size;
	}
	
	public String toString() {
		String s = "[";
		Iterator<TreeMap<K, V>.Entry<K, V>> temp = tree.iterator();
		for(int i=0; i<tree.size(); i++) {
			s+= tree.get(temp.next()).toString();
			if(temp.hasNext()) {
				s += ",";
			}
		}
		return s + "]";
	}

	public Set<K> keySet() {
		Set<K> keySet = new TreeSet<K>();
		Iterator<TreeMap<K, V>.Entry<K, V>> temp = tree.iterator();
		while(temp.hasNext()) {
			keySet.add(temp.next().key);
		}
		return keySet;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Map)) {
			return false;
		}
		TreeMap map = (TreeMap) obj;
		//HashMap<K,V> map = (HashMap<K,V>) obj;
		if(map.size == this.size) {
			Iterator<TreeMap<K, V>.Entry<K, V>> temp = tree.iterator();
			while(temp.hasNext()) {
				Entry<K,V> entry = temp.next();
				if(!(map.containsKey(entry.key)))
					return false;	
				else if(!(map.get(entry.key) == entry.value))
					return false;
			}	
			return true;
		}
		
	return false;
	}

}
