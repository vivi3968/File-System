/**
 * @author vivi3
 * Thrown if the current node is a file, as files cannot contain DirectoryNode references
 */
public class NotADirectoryException extends Exception {
	
	/**
	 * Empty constructor
	 */
	public NotADirectoryException() {
		super("Not a directory.");
	}
	
	/**
	 * Constructor with parameters
	 * @param message to be printed
	 */
	public NotADirectoryException(String message) {
		super(message);
	}

}
