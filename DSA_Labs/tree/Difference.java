package tree;
/**
 * Finds the Difference between two numbers
 * 
 * @author Shane Tomasello
 * @version Oct 29, 2020
 */

public class Difference extends Expr {
	
	public Difference (Expr left, Expr right) {
		super();
		super.left =left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() - right.eval();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Difference))
			return false;
		Difference other = (Difference) obj;
		return left.equals(other.left) && 
				right.equals(other.right);  		//a-b = a-b
												//a-b != b-a
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(left instanceof Constant && left.eval() == 0)		//0-x = x
			return right;
		if(right instanceof Constant && right.eval() == 0)		//x-0 = x
			return left; 
		if(right.equals(left))									// x-y = 0
			return new Constant(0);
		return this;											//cannot simplify
	}
	
	//Use parentheses even if not needed
		public String toString() {
			return "(" + left + "-" + right + ")";
		}
}
