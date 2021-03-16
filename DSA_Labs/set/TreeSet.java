package set;

import list.Iterator;
import tree.BinarySearchTree;
import tree.BinaryTree;
import tree.EmptyBinarySearchTree;

/**
 * An implementation of Set, using a BinaryTree
 * 
 * @author Shane Tomasello
 * @version Nov 10, 2020
 * @param <E>
 */
public class TreeSet<E extends Comparable> implements Set<E> {
	
	BinaryTree<E> tree = new EmptyBinarySearchTree<E>();
	int size = 0;
	
	public boolean add(E value) {
		if(tree.containsKey(value))
			return false;				//no duplicates
		tree = tree.add(value);
		size++;
		return true;
	}
	
	public boolean contains(Object obj) {
		return tree.containsKey(obj);
	}
	
	public boolean remove(Object obj) {
		if(! contains(obj))
			return false;
		tree = tree.remove(obj);
		size--;
		return true;
	}

	public Iterator<E> iterator() {
		return tree.iterator();
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof Set)) {
			return false;
		}
			HashSet<E> set = (HashSet<E>) obj;
			if(set.table.size() == this.size) {
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
		Iterator<E> temp = this.iterator();
		String set = "";
		for(int i=0; i<tree.size(); i++) {
			set+= tree.get(temp.next());
			if(temp.hasNext()) {
				set += ", ";
			}
			
		}
		return set;
	}


	public void clear() {
		tree = new EmptyBinarySearchTree<E> ();
		
	}

	public boolean isEmpty() {
		return tree.isEmpty();
	}

	public int size() {
		return size;
	}

}
