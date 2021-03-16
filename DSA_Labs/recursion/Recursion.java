package recursion;
/**
 * 
 * @author Shane Tomasello
 * @version 9/29/20
 */

public class Recursion {
	/**
	 * @return the quotient when x is divided by y.
	 * Pre: x >= 0, y>0
	 */
	public int div(int x,int y) {
		if(x-y<0|| y<=0 || x <= 0)
			return 0;
		return 1+div(x-y,y);
	}
	
	/**
	 * @return n!
	 * @param n is not negative
	 */
	public int fact (int n) {
		if(n == 0)				//Base case
			return 1;
		return n * fact(n-1);	//Recursive case
	}
	
	/**
	 * @return the nth value in the Fibonacci sequence
	 */
	public int fib(int n) {
		if(n<2) 
			return 1;
		return fib(n-1) + fib(n-2);
	}
	
	/**
	 * @return the product when x is multplied by y, without using the * or / operators.
	 * @param x is not negative.
	 */
	public int mult (int x, int y) {
		if(x<1)
			return 0;
		return y + mult (x-1, y);
	}
	
	/**
	 * @return true iff s is a palindrome.
	 */
	public boolean pal(String s) {
		if(s.length() < 2)		//Base
			return true;
		if(s.charAt(0) != s.charAt(s.length()-1))		//Base case
			return false;
		//Recursive case
		return pal (s.substring(1, s.length()-1));
	}
	
}
