package graph;

/**
 * A Direct Flight has an origin airport and a
 * destination Airport.
 * @author Shane Tomasello
 * @version Nov 25, 2020
 */
public class Flight {
	Airport origin, destination;
	
	public Flight (Airport o, Airport d) {
		origin = o;
		destination = d;
	}
	
	public String toString() {
		return "(" + origin + "->" + destination + ")";
	}

}
