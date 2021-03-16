package queueDriver;

/**
 * A Doc has a size, in blocks, to be printed.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class Doc
{
    private int size;      // size of this Doc, in blocks

    /**
     * Constructor for objects of class Printer
     */
    public Doc(int size)
    {
        this.size = size;
        toString();
    }
    
    public int size()
    {   return size;  }
   
   public String toString() {
	   return "\tDoc of size " + size;
   }
    
}
