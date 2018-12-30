/**
 * @author vivi3
 * Thrown if all child references of this directory are occupied.
 */
public class FullDirectoryException extends Exception {
	
	public FullDirectoryException() {
		super("Directory is full.");
	}
	
	/**
	 * @param message to be printed
	 */
	public FullDirectoryException(String message) {
		super(message);
	}
}
