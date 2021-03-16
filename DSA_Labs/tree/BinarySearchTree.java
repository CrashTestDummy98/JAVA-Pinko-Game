
package tree;

import list.ArrayList;
import list.Iterator;
import list.List;

/**
 * A BinaryTree whose left child's value is smaller, and 
 * whose right child's value is greater than
 * the value of this BinarySearchTree.
 * All non-empty children are also BinarySearchTrees.
 * 
 * @author Shane Tomasello
 * @version 10/20/20
 */
public class BinarySearchTree<E extends Comparable> implements BinaryTree<E> {
	
	BinaryTree<E> left = new EmptyBinarySearchTree<E>(), 
			right = new EmptyBinarySearchTree<E>();
	
	E value;
	int size = 1; 		//size of the family
	
	//static fields needed for add and remove
	static boolean removed = false;
	static boolean added = false;
	
	public BinarySearchTree (E value) {
		this.value = value;
	}
	
	//Mutator methods
	/**
	 * Set the left child of this Binary Tree to the
	 * given Binary Tree
	 */
	public void setLeft(BinaryTree<E> left) {
		this.left = left;
		size = left.size() + right.size() + 1;
	}
	
	/**
	 * Set the right child of this Binary Tree to the
	 * given Binary Tree.
	 */
	public void setRight(BinaryTree<E> right) {
		this.right = right;
		size = left.size() + right.size() + 1;
	}
	
	//Fill in accessor and other mutator methods
	public E getValue() {
		return value;
	}

	public BinaryTree<E> getLeft() {
		return left;
	}

	
	public BinaryTree<E> getRight() {
		return right;
	}


	public void setValue(E value) {
		this.value = value;
	}

	public boolean isEmpty() {
		return false;
	}

	public int size() {
		return size;
	}

	public E get(E value) {
		int cmp = this.value.compareTo(value);
		if(cmp == 0)
			return this.value;				//found it
		if(cmp<0)
			return right.get(value);		//search right child
		return left.get(value);				//search left child
	}


	/**
	 * Search the family in this tree for a given object
	 * @return true iff object is found.
	 */
	public boolean containsKey(Object obj) {
		int cmp = value.compareTo(obj);
		if(cmp == 0)
			return true;					//found it
		if(cmp < 0)
			return right.containsKey(obj);	//search right child
		return left.containsKey(obj);		//search left child
	}
	
	public BinaryTree<E> add(E value) {
		added = false;		//static field
		return addHelper(value);
	}
	
	public BinaryTree<E> addHelper(E value){
		int cmp = this.value.compareTo(value);
		if(cmp<0)				//Add to family of right child
			right = right.add(value);
		if(cmp>0)				//Add to family of left child
			left = left.add(value);
		if(added)
			size++;
		return this;
	}
	
	public BinaryTree<E> remove(Object obj) {
		removed = false;
		return removeHelper(obj);
	}
	
	private BinaryTree<E> removeHelper(Object obj) {
		int cmp = this.value.compareTo(obj);
		if(cmp == 0) {				//found it
			removed = true;
			List<BinaryTree<E>> kids = children();
			if(kids.size() == 0) 	//no children
				return new EmptyBinarySearchTree<E>();
			if(kids.size() == 1)	//one child
				return kids.get(0);
			//Two children
			BinaryTree<E> successor = getSuccessor();
			removeHelper(successor.getValue());
			setValue (successor.getValue());
			return this;
		}
		if(cmp>0) 						//Remove from family of
			left = left.remove(obj);	//Left child
		if(cmp<0)						//Remove from family of
			right = right.remove(obj);	//Right child
		if(removed)
			size--;
		return this;
			
	}
	
	/**
	 * @return a list of this BinarySearchTree's children
	 */
	private List<BinaryTree<E>> children(){
		List<BinaryTree<E>> children = new ArrayList<BinaryTree<E>>();
		if(!left.isEmpty())
			children.add(getLeft());
		if(!right.isEmpty())
			children.add(getRight());
		return children;
	}
	
	/**
	 * @return the successor of this BinaryTree.
	 * successor is the smallest value in the family
	 * of the right child
	 */
	private BinaryTree<E> getSuccessor() {
		BinaryTree<E> temp = right;
		while (!temp.getLeft().isEmpty())
			temp = temp.getLeft();
		return temp;
	}
	
	public String toString() {
		Iterator<E> iterator = iterator();
		String p = "[ ";
		if(iterator.hasNext()) {
			for(int i=0; i<size; i++) {
				p += this.get(iterator.next());
				if(iterator.hasNext()) {
					p+= ", ";
				}
			}
			p+="]";
		}
		return p;
	}

	public Iterator<E> iterator() {
		return new TreeIterator<E>(this);
	}

	public int height() {
		Iterator<E> itty = this.iterator();
		int i = 0;
		while(itty.hasNext()) {
		     itty.next();
			i++;
		}
		
		return i++;
	}

	public boolean isBalanced() {
		Iterator<E> rightItty = right.iterator();
		Iterator<E> leftItty = left.iterator();
		int righttemp = 0;
		int lefttemp =0;
		 while(rightItty.hasNext()) {
			 righttemp++;
		 }
		 while(leftItty.hasNext()) {
			 lefttemp++;
		 }
		 if(lefttemp <= 5 && righttemp <= 5) {
			 if(lefttemp == righttemp) {
				 return true;
			 }
		 }
		 return false;
	}

}
