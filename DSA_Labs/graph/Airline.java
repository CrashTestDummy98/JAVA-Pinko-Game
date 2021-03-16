package graph;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import list.ArrayList;
import list.Iterator;
import list.LinkedList;
import list.List;
import map.HashMap;
import map.Map;
import queue.PriorityQueue;
import queue.QueueADT;

/**
 * An Airline has a collection of direct Flights.
 * The Airline is a capable of finding a path from an 
 * origin Airport to a destination Airport.
 * @author Shane Tomasello
 * @version Nov 25, 2020
 */
public class Airline {
	List<Flight> flights;			//Direct Flights
	//Key are Airport names, values are Airports
	Map <String, Airport> map;
 
	public static void main(String[] args) {
		Airline airline = new Airline();
		
		//Read the direct flights from a text file
		airline.getFlights();
		
		System.out.println("Flights: " + airline.flights);
		System.out.println("Map: " + airline.map);
		System.out.println("Path from PHL to SFO");
		// Find a path:
		System.out.println(airline.path("PHL", "SFO"));
		
		//Try finding other paths....
		
		System.out.println(airline.path("CVG", "Paris"));
	}
	
	/**
	 * Read the diret flights from text file.
	 * Build the List of Flights, and a Map from
	 * Airport names to Airports.
	 */
	private void getFlights() {
		File inFile = new File("flightsORL1.txt");
		map = new HashMap<String,Airport>();
		flights = new ArrayList<Flight>();
		try {
			Scanner scanner = new Scanner (inFile);
			String flight, origin, dest;
			Airport o,d;
			while(scanner.hasNextLine()) {
				flight = scanner.nextLine(); //has both o and d
				origin = flight.split(" ")[0];
				dest =flight.split(" ")[1];
				if (map.containsKey(origin)) 
					o = map.get(origin); 	//Get the origin Airport
				else {	//Create entry in the map
					o = new Airport (origin);
					map.put(origin, o);
				}
				if (map.containsKey(dest))
					d = map.get(dest);
				else {
					d = new Airport (dest);
					map.put(dest, d);
				}
				flights.add(new Flight(o,d));
			}
			//end of try block
		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
		//end of getFlights method
	}
	
	/**
	 * Find a path from the Airport with the name origin, to
	 * the Airport with the name dest, if possible.
	 * It need not be an optimal path.
	 * @return the path as a List of Airport, empty if
	 * no path is found.
	 */
	private List<Airport> path (String origin, String dest) {
		Airport o = map.get(origin);
		Airport d = map.get(dest);
		
		List<Airport> result = path(o,d);
		clearAirports();		//Clear visited flags
		return result;
	}
	
	/**
	 * @return the path from origin to dest
	 */
	private List<Airport> path(Airport origin, Airport destination) {
		List<Airport> result = new LinkedList<Airport>();
		origin.visited = true;
		if(origin.equals(destination)) {		//base case
			result.add(origin); 
			return result;
		}
		// Recursive case
		Airport port;
		 QueueADT<Airport> queue = getDirect(origin);
		while (! queue.isEmpty()) {
			port = queue.remove();
			port.visited = true;
			result = path(port, destination);
			port.visited = true;
			if (result.size() > 0) {
				result.add(0, origin);
				return result;
			}
		}
		return result;			//No path found
	}
	
	/**
	 * @return a Queue of Airport which can be reached
	 * directly from the given Airport, and which have not
	 * already been visited
	 */
	private QueueADT<Airport> getDirect (Airport from) {
		QueueADT<Airport> hubs = new PriorityQueue<Airport> ();
		Iterator<Flight> it = flights.iterator();
		Flight flight;
		while (it.hasNext()) {
			flight = it.next();
			if(flight.origin.equals(from) && !flight.destination.visited)
				hubs.add(flight.destination);
		}
		return hubs;
	}
	
	/**
	 * Reset visited flag of every Airport
	 */
	private void clearAirports() {
		Flight flight;
		Airport port;
		Iterator<Flight> it = flights.iterator();
		while(it.hasNext()) {
			flight = it.next();
			flight.origin.visited = false;
			flight.destination.visited = false;
		}
	}
}
