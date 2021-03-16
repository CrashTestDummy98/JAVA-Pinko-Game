package graph;

public class Airplane implements Comparable {
	
	int flight;
	int arrivalTime;
	int fuelLevel;			//gallons of jet fuel remaining
	
	public Airplane (int arrival, int fuel, int flight) {
		arrivalTime = arrival;
		fuelLevel = fuel;
		this.flight = flight;
		System.out.println(this + " has arrived at time " + arrival + " with gallons of fuel left " + fuel);
	}

	public int compareTo(Object obj) {
		int isTrue = 0;
		if(obj instanceof Airplane) {
			Airplane temp = (Airplane) obj;
			
			if(this.fuelLevel == temp.fuelLevel && this.arrivalTime < temp.arrivalTime) 
				isTrue = 1;
			
			else if(this.fuelLevel == temp.fuelLevel && this.arrivalTime > temp.arrivalTime)
				isTrue = -1;
			
			if(this.fuelLevel < temp.fuelLevel)
				isTrue = 1;
			
			if(this.fuelLevel > temp.fuelLevel)
				isTrue = -1;
		}
		return isTrue;
	}
	
	public String toString() {
		return Integer.toString(flight);
	}

}
