package tree;

/**
 * An Expr is an arithmetic expression
 * 
 * @author Shane Tomasello
 * @version 10/27/20
 */
public abstract class Expr {

	Expr left, right;	//operands
	
	public Expr (Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}
	
	public Expr () {
		super();
	}
	
	/**
	 * @return the value of this Expr
	 */
	public abstract int eval();
	
	/**
	 * @return true off this Expr is the same as 
	 * the given obj
	 */
	public abstract boolean equals(Object obj);
	
	/**
	 * @return a simplified version of this Expr,
	 * if possible.
	 */
	public abstract Expr simplify();
}
