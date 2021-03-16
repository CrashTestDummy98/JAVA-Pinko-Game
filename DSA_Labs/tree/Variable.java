package tree;

public class Variable extends Expr {
	
	char name;
	Integer value;
	
	public Variable (char name) {
		super();
		this.name = name;
	}
	
	public int eval() {
		if(value == null)
			throw new IllegalArgumentException("Variables do not have values");
		return value;
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof Variable))
			return false;
		Variable temp = (Variable) obj;
		if(temp.name == this.name)
			return true;
		return false;
	}

	public Expr simplify() {
		return this;
	}
	
	public String toString() {
		return String.valueOf(this.name);
	}
}
