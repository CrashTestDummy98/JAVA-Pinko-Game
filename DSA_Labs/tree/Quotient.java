package tree;

/**
 * Finds the Quotient of two numbers
 * 
 * @author Shane Tomasello
 * @version Oct 29, 2020
 */
public class Quotient extends Expr {
	
	public Quotient (Expr left, Expr right) {
		super();
		super.left =left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() / right.eval();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Quotient))
			return false;
		Quotient other = (Quotient) obj;
		return left.equals(other.left) && 
				right.equals(other.right);  	//a/b = a/b
												//a/b != b/a not comunitive
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(left instanceof Constant && left.eval() == 0)				//0/x = error
			return right;
		if(right instanceof Constant && right.eval() == 0)				//x/0 = error
			return left; 
		if(right instanceof Constant && right.eval() == 1)				//x/1 = x
			return right;
		if(right.equals(left))											//x/y=1
			return new Constant(1);
		return this;											//cannot simplify
	}
	
	//Use parentheses even if not needed
	public String toString() {
		return "(" + left + "/" + right + ")";
	}

}
