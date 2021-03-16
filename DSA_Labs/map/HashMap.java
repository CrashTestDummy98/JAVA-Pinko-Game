package map;

import hash.HashTable;
import list.Iterator;
import set.HashSet;
import set.Set;
import set.TreeSet;

/**
 * An implementation of the Map interface using a HashTable
 * of entries.
 * 
 * @author Shane Tomasello
 * @version Nov 17, 2020
 */

public class HashMap <K,V> implements Map <K,V> {
	//Inner class to define an Entry
	class Entry <K,V> {
		K key;
		V value;
		
		Entry (K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		/**
		 * @return true iff the given object is an Entry, and its
		 * key is equal to the key of this Entry.
		 */
		public boolean equals (Object obj) {
			if(!(obj instanceof Entry ))
				return false;
			Entry <K,V> entry = (Entry <K,V>) obj;
			return this.key.equals (entry.key);
		}
		
		public int hashCode() {
			return  key.hashCode();
		}
		
		public String toString() {
			return key + "=" + value;
		}
		
		// End of inner class Entry
	}
	
	HashTable <Entry <K,V>> table;
	
	public HashMap() {
		table = new HashTable <Entry<K,V>> ();
	}
	
	public HashMap(int size) {
		table = new HashTable <Entry <K,V>> (size);
	}
	
	public boolean containsKey(K key) {
		Entry <K,V> entry = new Entry<K,V> (key,null);
		return table.containsKey(entry);
	}

	public V get(K key) {
		Entry <K,V> entry = new Entry<K,V> (key,null);
		entry = table.get(entry);
		if (entry == null)				//Not found in the table?
			return null;
		return entry.value;				//Yes, return the value
	}

	public V put(K key, V value) {
		Entry<K,V> newEntry = new Entry<K,V> (key, value),
				oldEntry = table.get(newEntry);
		if (oldEntry == null) {
			table.put((newEntry));			//Key not found
			return null;
		}
		V oldValue = oldEntry.value;
		oldEntry.value = value;				//Change the value
		return oldValue;
	}

	public V remove(K key) {
		Entry<K,V> entry = new Entry<K,V> (key,null),
				result = table.get(entry);
		if (table.remove(entry)) {
			return result.value;
		}
		return null;
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
	
	public String toString() {
		String s = "[";
		Iterator<HashMap<K, V>.Entry<K, V>> temp = table.iterator();
		for(int i=0; i<table.size(); i++) {
			s += table.get(temp.next()).toString();
			if(temp.hasNext()) {
				s+= ",";
			}
		}
		return s + "]";
	}

	public Set<K> keySet() {
		Set<K> keySet = new HashSet<K>();
		Iterator<HashMap<K, V>.Entry<K, V>> temp = table.iterator();
		while(temp.hasNext()) {
			keySet.add(temp.next().key);
		}
		return keySet;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Map)) {
			return false;
		}
		//TreeMap map = (TreeMap) obj;
		HashMap<K,V> map = (HashMap<K,V>) obj;
		if(map.table.size() == this.table.size()) {
			Iterator<HashMap<K, V>.Entry<K, V>> temp = table.iterator();
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
