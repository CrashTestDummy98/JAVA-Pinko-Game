package recursion.fileSystem;

import list.List;

/**
 * 
 * @author Shane Tomasello
 * @version 9/29/20
 */
public abstract class Item {
	String name;
	
	/**
	 * Creates a name of an Item
	 * @param name
	 */
	public Item(String name) {
		this.name = name;
	}
	
	/**
	 * @return name of the Item
	 */
	public String getName() {
		return name;
	}
	
	 /** 
	  * @return A list of all the documents making up this Item 
	  *(and all contained folders)  in any order 
	  */
	public abstract List<Document>  getAllDocs() ;
	
	/** 
	 * Display the name of this Item; also display all the
	 * items which it contains, on separate lines.  
	 */
	public abstract void show();

}
