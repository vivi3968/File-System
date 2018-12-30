/**
 * @author vivi3
 * Implements a ternary (3-child) tree of DirectoryNodes
 */
public class DirectoryTree {
	
	private DirectoryNode root = new DirectoryNode();
	private DirectoryNode cursor;
	
	/**
	 * Initializes a DirectoryTree object with a single DirectoryNode named "root".
	 */
	public DirectoryTree() {
		root.setName("root");
		root.setFile(false);
		cursor = root;
		root.setParent(null);
	}

	/**
	 * Moves the cursor to the root node of the tree.
	 */
	public void resetCuror() {
		cursor = root;
		root.setParent(null);
	}
	
	/**
	 * Moves the cursor to the directory with the name indicated by name.
	 * @param name of directory
	 * @throws NotADirectoryException if the node with the indicated name is a file,
	 *  as files cannot be selected by the cursor, or cannot be found.
	 */
	public void changeDirectory(String name) throws NotADirectoryException {
		boolean found = false;
		
		if (cursor.getLeft() != null && cursor.getLeft().getName().equals(name) && found == false) {
			if (cursor.getLeft().getIsFile() == true) 
				throw new NotADirectoryException("not directory");
			cursor = cursor.getLeft();
			found = true;
		}
		
		else if (cursor.getMiddle() != null && cursor.getMiddle().getName().equals(name) && found == false) {
			if (cursor.getMiddle().getIsFile() == true) 
				throw new NotADirectoryException("not directory");
			cursor = cursor.getMiddle();
			found = true;
		}
		
		else if (cursor.getRight() != null && cursor.getRight().getName().equals(name) && found == false) {
			if (cursor.getRight().getIsFile() == true) 
				throw new NotADirectoryException("not directory");
			cursor = cursor.getRight();
			found = true;
		}
		
		if (found == false) 
			System.out.println("ERROR: No such directory named '" + name + "'");
	}
	
	/**
	 * Moves the cursor up to its parent directory (does nothing at root).
	 */
	public void changeToParent() {
		if (cursor == root)
			System.out.println("Error: Already at root directory.");
		else
			cursor = cursor.getParent();
	}
	
	/**
	 * @return Returns a String containing the path of directory names from the root 
	 * node of the tree to the cursor, with each name separated by a forward slash "/"
	 */
	public String presentWorkingDirectory() {
		String str = "";
		String fin = "";
		String[] arr;
		DirectoryNode temp = cursor;
		
		while (cursor != null) {
			str += cursor.getName() + " ";		
			cursor = cursor.getParent();
		}
		
		arr = str.split(" ");

		for (int i = arr.length-1; i >= 0; i--) {
			fin += arr[i] + " ";
		}
		
		cursor = temp;
		
		fin = fin.replace(" ", "/");
		fin = fin.substring(0, fin.length() - 1);
		System.out.println(fin);
		return fin;
	}
	
	/**
	 * @return Returns a String containing a space-separated
	 *  list of names of all the child directories or files of the cursor.
	 */
	public String listDirectory() {
		String str = "";
		
		if (cursor.getLeft() != null) {
			str += cursor.getLeft().getName() + " ";
		}
		if (cursor.getMiddle() != null) {
			str += cursor.getMiddle().getName() + " ";
		}
		if (cursor.getRight() != null) {
			str += cursor.getRight().getName() + " ";
		}
		
		System.out.println(str);
		return str;
	}
	
	/**
	 * Prints a formatted nested list of names of all the nodes in the directory tree, 
	 * starting from the cursor.
	 */
	public void printDirectoryTree() {
		String str = "    ";
		cursor.preorder(cursor, str);
	}

	/**
	 * Creates a directory with the indicated name and adds it to the children of the cursor node
	 * @param name of the directory to add.
	 * @throws FullDirectoryException thrown if all child references of this directory are occupied.
	 * @throws IllegalArgumentException thrown if the 'name' argument is invalid.
	 */
	public void makeDirectory(String name) throws FullDirectoryException, IllegalArgumentException {
				
		if (name.contains(" ") || name.contains("/")) 
			throw new IllegalArgumentException("invalid name");
		
		DirectoryNode newNode = new DirectoryNode();
		newNode.setName(name);

		try {
			
			if (cursor.getLeft() == null || cursor.getMiddle() == null || cursor.getRight() == null) 
				cursor.addChild(newNode);			
			
			else
				throw new FullDirectoryException("Error: Present directory is full.");
			
		} catch (NotADirectoryException ex) {
			System.out.println("Error.");
		}
	}
	
	
	/**
	 * Creates a file with the indicated name and adds it to the children of the cursor node
	 * @param name of the file to add.
	 * @throws FullDirectoryException Thrown if all child references of this directory are occupied.
	 * @throws IllegalArgumentException Thrown if the 'name' argument is invalid.
	 */
	public void makeFile(String name) throws FullDirectoryException, IllegalArgumentException {
		if (name.contains(" ") || name.contains("/")) {
			throw new IllegalArgumentException("invalid name");
		}
		
		DirectoryNode file = new DirectoryNode();
		file.setFile(true);
		file.setName(name);
		
		try {
			if (cursor.getLeft() == null) {
				cursor.addFile(file);
			}
			
			else if (cursor.getMiddle() == null) {
				cursor.addFile(file);
			}
			
			else if (cursor.getRight() == null) {
				cursor.addFile(file);
			}
			
			else if (cursor.getLeft() != null && cursor.getMiddle() != null && cursor.getRight() != null) {
				throw new FullDirectoryException("Error: Present directory is full.");
			}	
		} catch (FullDirectoryException ex) {
			System.out.println("Error: Present directory is full.");
		}
	}
}
