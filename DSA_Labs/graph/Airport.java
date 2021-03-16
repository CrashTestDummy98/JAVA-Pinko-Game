package graph;

/**
 * An Airport has a name
 * @author Shane Tomasello
 * @version Nov 25, 2020
 */

public class Airport implements Comparable {
	String name;
	boolean visited = false;
	boolean hub = false;
	
	public Airport (String name) {
		this.name = name;
	}
	
	public Airport() {
		name = "HUB";
	}
	
	public boolean equals(Object obj) {
		if(! (obj instanceof Object))
			return false;
		Airport other = (Airport) obj;
		return name.equals(other.name);
	}
	
	public String toString() {
		if(hub) {
			return "Hub: " + name;
		}
		return name;
	}
	
	public void hub(boolean isHub) {
		hub = isHub;
	}
	
	public int compareTo(Object other) throws IllegalArgumentException {
		if(other instanceof Airport) {
			Airport airport = (Airport)other; 
			if(this.hub && !airport.hub) {
				return 1;  
			}else if(this.hub && airport.hub) {
				return 0;
			}
			return -1; 
		} 
		throw new IllegalArgumentException();
	}

}
