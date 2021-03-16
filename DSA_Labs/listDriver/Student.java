package listDriver;
/**
 * 
 * @author Shane Tomasello
 *
 */

public class Student {
	private String name;
	private int idNum;
	
	public Student(String name, int idNum){
		this.name = name;
		this.idNum =idNum;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return idNum;
	}
	
	public String toString() {
		return getName() + ", " + getID();
	}
	
	public boolean equals(Object obj) {
		Student stu;
		if(!(obj instanceof Student)) {
			return false;
		}
		else {
			stu = (Student)obj;
			if(getID() == stu.getID()) {
				return true;
			}
			else { 
				return false;
			}
		}
	}

}
