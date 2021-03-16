package recursion.fileSystem;


import list.ArrayList;
import list.Iterator;
import list.List;

/**
 * 
 * @author Shane Tomasello
 * @version 9/29/20
 */
public class Folder extends Item {
	List<Item> itemList;
	int folder = 0;
	public Folder(String name) {
		super(name);
		itemList = new ArrayList<Item>();
	}
	
	/**
	 * Add the given Item to the Folder
	 * @param item
	 */
	public void addItem(Item item) {
		itemList.add(item);
	}
	/**
	 * Get all Documents with in the file at once and store them in
	 * an ArrayList.
	 * @return ArrayList of Documents
	 */
	public List<Document> getAllDocs() {
		List<Document> docs = new ArrayList<Document>();
		for(int i = 0; i<itemList.size(); i++) {
			docs.addAll(itemList.get(i).getAllDocs());
		}
		return docs;
	}
	
	public void show() {	
		
		for(int i = 0; i<itemList.size(); i++) {
			
			if(itemList.get(i) instanceof Folder) {
				System.out.println(itemList.get(i).getName());
				itemList.get(i).show();
			}
			else if (itemList.get(i) instanceof Document) {
				System.out.println(itemList.get(i).getName());
			}
		}
	}
}
