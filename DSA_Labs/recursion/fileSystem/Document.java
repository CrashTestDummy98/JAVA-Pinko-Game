package recursion.fileSystem;

import list.ArrayList;
import list.List;

/**
 * 
 * @author Shane Tomasello
 * @version 9/29/20
 */

public class Document extends Item{
	
	DocType type;
	
	public Document(String name, DocType type) {
		super(name);
		this.type = type;
	}
	
	public List<Document> getAllDocs() {
		List<Document> docList = new ArrayList<Document>();
		docList.add(this);
		return docList;
	}
	
	public void show() {
		System.out.println(name + "\n");
	}
	
	public String toString() {
		return getAllDocs().get(0).name;
	}
}
