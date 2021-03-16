package queueDriver;

import queue.*;

/**
 * A Printer has a speed, in blocks of printing per step, and a queue of Docs to be printed
 * 
 * @author (sdb)
 * @version (2020)
 */
public class Printer
{
    private int speed;      // speed of this printer, blocks per step
    private QueueADT <Doc> docs;    // Queue of documents waiting to be printed
    private String id;      // name of this Printer
    private int size = 0;


    /**
     * Constructor for objects of class Printer
     */
    public Printer(int speed, String id)
    {
      this.speed = speed;
      this.id =id;
      docs = new Queue();
    }

    /** Add a document to this printer's queue 
       Display the document and printer on stdout.
       */
    public void add (Doc doc)
    {    
       docs.add(doc);
        
        //////////// Do not change this println statement ///////////////
        System.out.println(doc + " added to " + this);
    }

    /** Print several blocks, if necessary, determined by this printer's speed.
     * Display a completion message, if necessary.
     *  
     */
    public void print()
    {  
    	if(size == 0 && !(docs.isEmpty())) {
    		size = docs.peek().size();
    	}
    	
    	if(!(docs.isEmpty())) {
    		if(size>0) {
    			size-= speed;
    			if(size<=0) {
    				System.out.println("\tPrint task completed on "+ id + "for: Doc size " + docs.peek().size());
    				size= 0;
    				docs.remove();
    			}
    		}
    	}
    }

    /** @return the number of documents in this Printer's queue */
    public int size()
    {   return docs.size();  }

    public String toString()
    {   return id + ", speed: " + speed + ", docs in queue: " + size();  }
}
