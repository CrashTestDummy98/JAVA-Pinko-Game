package list;
/**
 * @author Shane Tomasello
 * @version (9/3/20)
 *
 */
public class Node <E>{
	E value;
	Node <E> next;
	Node <E> prev;
	
	//Constructor
	Node (E value, Node<E> next, Node<E> prev){
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
}
