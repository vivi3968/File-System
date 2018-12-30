/* Vivian Lam
 * ID: 111549991
 * vivian.lam@stonybrook.edu
 * Homework 5
 * CSE214, R11 (Reed Gantz)
 */ 

/**
 * @author vivi3
 * Thrown if all child references of this directory are occupied.
 */
public class FullDirectoryException extends Exception {
	
	/**
	 * Empty constructor 
	 */
	public FullDirectoryException() {
		super("Directory is full.");
	}
	
	/**
	 * Constructor with parameters
	 * @param message to be printed
	 */
	public FullDirectoryException(String message) {
		super(message);
	}
}
