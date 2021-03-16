package tree;

public class Assignment extends Expr{
	
	
	public Assignment(Expr left, Expr right) {
		super.left =left;		//Variable
		super.right = right;	//Assigned to variable
	}
	public int eval() {
		((Variable) left).value = right.eval();
		return right.eval();
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof Assignment))
			return false;
		Assignment temp = (Assignment) obj;
		if(this.left == temp.left && this.right.equals(temp.right))
				return true;
		return false;
	}

	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		return this;
	}
	
	public String toString() {
		return "("+ left + "=" + right + ")";
	}

}
