package alloc;

import list.Iterator;
import list.LinkedList;
import list.List;

/**
 * Simulate the allocation and freeing of
 * memory.
 * @author Shane Tomasello
 * @version Dec 9, 2020
 */
public class Memory {
	//Blocks which are in use, not available
	List<Block> allocated = new LinkedList<Block>();
	
	//Available Blocks
	List<Block> free = new LinkedList<Block>();
	
	static final int MAX = 4096;		//size of memory
	
	public Memory() {
		free.add(new Block(0,MAX));	//all of memory
									//is free.
	}
	
	/**
	 * Allocate a block of the given size, if possible.
	 * @return its position in memory,
	 * or -1 if not possible.
	 * Algorithm: First-fit
	 */
	public int allocate(int size) {
		Block b, newBlock = null;
		Iterator<Block> freeItty = free.iterator();
		int smallest = smallest(size);
		while (freeItty.hasNext()) {
			b = freeItty.next();
			if(b.size >= size) {		//big enough?
				if(b.size == smallest) {
					newBlock = new Block (b.start,size);
					allocated.add(newBlock);
					b.start = b.start + size;
					b.size = b.size - size;
					if(b.size == 0) {
						freeItty.remove();
					}
					return newBlock.start;
					}
			}	
		}
		return -1;
	}
	
	/**
	 * @param size
	 * @return the smallest available Block that will be able to 
	 * fit the required size
	 */
	public int smallest(int size) {
		Iterator<Block> freeItty = free.iterator();
		Block a = null;
		int temp = 0;
		while (freeItty.hasNext()) {
			a = freeItty.next();
			if(temp == 0) {
				temp = a.size;
			}
			if(a.size < temp && a.size > size) {
				temp = a.size;
			}
		}
		return temp;
	}
	
	/**
	 * Make the block at the given start position
	 * available.
	 * @return true iff there is such a block.
	 */
	public boolean free (int start) {
		Block b;
		Iterator<Block> itty = allocated.iterator();
		while(itty.hasNext()) {
			b = itty.next();
			if (b.start == start) {
				itty.remove();
				free.add(0,b); 		// Add at beginning
				combin();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Combines memory blocks that are next to each other.
	 */
	public void combin() {
		Iterator<Block> itty = free.iterator();
		Block a,b;
	    int temp = 0;
		while(itty.hasNext()) {
			a = itty.next();
			Iterator<Block> ittyTwo = free.iterator();
			temp = a.start + a.size;
			while(ittyTwo.hasNext()) {
				b = ittyTwo.next();
				if(b.start == temp) {
					ittyTwo.remove();
					itty.remove();
					a.start = b.start - a.start;
					a.size = a.size + b.size;
					free.add(0,a);
				}
			}
		
		}
	}
	
	public String toString() {
		Iterator<Block> ittyFree = free.iterator();
		Iterator<Block> ittyAlloc = allocated.iterator();
		String temp = "Free memory: \n";
		while(ittyFree.hasNext()) {
			temp += ittyFree.next().toString();
		}
		if(!allocated.isEmpty()) {
			temp += "\nAllocated Memory: \n";
			while(ittyAlloc.hasNext()) {
				temp += ittyAlloc.next().toString();
				if(ittyAlloc.hasNext()) {
					temp +="\n";
				}
			}
		}
		return temp + "\n";
	}

}
