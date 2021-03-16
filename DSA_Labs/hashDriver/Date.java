package hashDriver;

import tree.Assignment;

public class Date {
	int day;
	int month;
	int year;
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
	
	public int hashCode() {
		return day + month + year;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Date))
			return false;
		Date date = (Date) obj;
		if(date.day == this.day && date.month == this.month && date.year == this.year) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return  Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
	}
}
