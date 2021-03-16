package tree;

/**
 * Finds the Product of two numbers
 * 
 * @author Shane Tomasello
 * @version Oct 29, 2020
 */
public class Product extends Expr {
	
	public Product (Expr left, Expr right) {
		super();
		super.left =left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() * right.eval();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		
		return left.equals(other.left) && 
				right.equals(other.right) || 		//a*b = a*b
				left.equals(other.right) &&			//a*b = b*a
				right.equals(other.left);
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(left instanceof Constant && left.eval() == 0)   		//0*x = 0
			return left;
		if(right instanceof Constant && right.eval() == 0)		//x*0 = 0
			return right; 
		if(right instanceof Constant && right.eval() == 1)			//x*1 = x
			return left;
		if(left instanceof Constant && left.eval() == 1)			//x*1 =x
			return right;
		if(left instanceof Quotient && right instanceof Quotient) {
			if(left.left.equals(right.right))
				return new Quotient(right.left, left.right);		// b/a == c/b = c/a
		
			else if (left.right.equals(right.left))
				return new Quotient(left.left, right.right);		//a/b == b/c = a/c
		}
		
		return this;											//cannot simplify
	}
	
	//Use parentheses even if not needed
	public String toString() {
		return "(" + left + "*" + right + ")";
	}

}
