package tree;

import list.Iterator;
import queue.Queue;

/**
 * An Iterator for BinaryTree, using an InOrder
 * traversal.
 * @author Shane Tomasello
 * @version 10/21/20
 */
public class TreeIterator<E> implements Iterator<E> {
	Queue<E> queue = new Queue<E>();
	BinaryTree<E> tree;
	// Last value obtained by next()
	private E lastGotten;
	
	public TreeIterator(BinaryTree<E> tree) {
		this.tree = tree;
		buildQ (tree);
	}
	
	/**
	 * Build the queue of values using InOrder traversal
	 */
	private void buildQ(BinaryTree<E> tree) {
		if(tree.isEmpty())
			return;
		buildQ(tree.getLeft());
		queue.add(tree.getValue());
		buildQ(tree.getRight());
	}
	
	public boolean hasNext() {
		return !queue.isEmpty();
	}
	
	public E next() {
		lastGotten = queue.peek();
		return queue.remove();
	}
	
	public void remove() {
		//Has 2 children or not removing the root?
		if(!tree.getLeft().isEmpty() && !tree.getRight().isEmpty() || !tree.getValue().equals(lastGotten)) {
			tree = tree.remove(lastGotten);
			return;
		}
		E repl;				//Replacement Value
		if(tree.getLeft().isEmpty())
			repl  = getSuccessorValue();
		else
			repl = getPredecessorValue();
		tree.remove(repl);
		tree.setValue(repl);
	}
	
	/**
	 * @return successor of the BinarySearchTree.
	 * Smallest value in family of right child
	 */
	private E getSuccessorValue() {
		BinaryTree<E> result = tree.getRight();
		while(!result.getLeft().isEmpty())
			result = result.getLeft();
		return result.getValue();
	}
	
	/**
	 * @return predecessor of this BinarySearchTree.
	 * Largest value in family of child
	 */
	private E getPredecessorValue() {
		BinaryTree<E> result = tree.getLeft();
		while(!result.getRight().isEmpty())
			result = result.getRight();
		return result.getValue();
	}

	@Override
	public boolean has2More() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove2() {
		// TODO Auto-generated method stub
		
	}

}
