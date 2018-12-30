/* Vivian Lam
 * ID: 111549991
 * vivian.lam@stonybrook.edu
 * Homework 5
 * CSE214, R11 (Reed Gantz)
 */ 

/**
 * @author vivi3
 * Represents a node in the file tre
 */
public class DirectoryNode {
	
	private String name;
	private DirectoryNode left;
	private DirectoryNode middle;
	private DirectoryNode right;
	private DirectoryNode parent;
	private boolean isFile;

	
	/**
	 * Empty constructor for nod
	 */
	public DirectoryNode() {	
	}
	
	/**
	 * Constructor with parameters for node
	 * @param name of node in the tree
	 * @param isFile differentiates between file and folder
	 */
	public DirectoryNode(String name, boolean isFile) {
		this.name = name;
		left = null;
		middle = null;
		right = null;
		parent = null;
		this.isFile = isFile;
	}
	
	/**
	 * Accessor method for parent
	 * @return parent of node
	 */
	public DirectoryNode getParent() {
		return parent;
	}

	/**
	 * Mutator method for parent
	 * @param parent of node
	 */
	public void setParent(DirectoryNode parent) {
		this.parent = parent;
	}

	/**
	 * Accessor method for name 
	 * @return name of string
	 */
	public String getName() {
		return name;
	}

	/**
	 * Mutator method for name
	 * @param name of string
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Accessor method for left child
	 * @return node of left child
	 */
	public DirectoryNode getLeft() {
		return left;
	}

	/**
	 * Mutator method for left child
	 * @param left child
	 */
	public void setLeft(DirectoryNode left) {
		this.left = left;
	}

	/**
	 * Accessor method for middle child
	 * @return middle child
	 */
	public DirectoryNode getMiddle() {
		return middle;
	}

	/**
	 * Mutator method node for middle child
	 * @param middle child
	 */
	public void setMiddle(DirectoryNode middle) {
		this.middle = middle;
	}

	/**
	 * Accessor method for right child
	 * @return right child
	 */
	public DirectoryNode getRight() {
		return right;
	}

	/**
	 * Mutator method for right child
	 * @param right child
	 */
	public void setRight(DirectoryNode right) {
		this.right = right;
	}
	
	/**
	 * Accessor method for determining whether a node is a file or folder
	 * @return true if the node is not a directory (folder)
	 */
	public boolean getIsFile() {
		return isFile;
	}

	/**
	 * Mutator method for determining whether a node is a file or folder
	 * @param isFile
	 */
	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}
	
	/**
	 * Adds newChild to any of the open child positions of this node 
	 * @param newChild to be added
	 * @throws FullDirectoryException if there is no room for newChild
	 * @throws NotADirectoryException if newChild is a file
	 */
	public void addChild(DirectoryNode newChild) throws FullDirectoryException, NotADirectoryException {
		if (!newChild.getIsFile() && ((this.getLeft() == null) || this.getMiddle() == null || 
				(this.getRight() == null))) {
			
			newChild.setParent(this);

			if (this.getLeft() == null) 
				this.setLeft(newChild);
			
			else if (this.getMiddle() == null) 
				this.setMiddle(newChild);
			
			else if (this.getRight() == null)
				this.setRight(newChild);
		}
		
		else if (newChild.getIsFile())
			throw new NotADirectoryException("Not a directory.");
		else 
			throw new FullDirectoryException("Directory is full.");

	}
	
	/**
	 * Preorder traversal of directory tree
	 * @param node 
	 * @param s
	 */
	public void preorder(DirectoryNode node, String s) {
		
		if (node.getIsFile() == false)
			System.out.println("|- " + node.getName());
		else
			System.out.println("- " + node.getName());
		
		if (node.getLeft() != null) {
			System.out.print(s);
			node.getLeft().preorder(node.getLeft(), s + "    ");
		}
		
		if (node.getMiddle() != null) {
			System.out.print(s);
			node.getMiddle().preorder(node.getMiddle(), s + "    ");
		}
		
		if (node.getRight() != null) {
			System.out.print(s);
			node.getRight().preorder(node.getRight(), s + "    ");
		}
		
	}
	
	/** 
	 * Adds newChild to any of the open child positions of this node 
	 * @param newChild to be added
	 * @throws FullDirectoryException if directory is full
	 */
	public void addFile(DirectoryNode newChild) throws FullDirectoryException {
		if (newChild.getIsFile() && ((this.getLeft() == null) || this.getMiddle() == null || 
				(this.getRight() == null))) {
			
			newChild.setParent(this);

			if (this.getLeft() == null) 
				this.setLeft(newChild);
			
			else if (this.getMiddle() == null) 
				this.setMiddle(newChild);
			
			else if (this.getRight() == null)
				this.setRight(newChild);
		}
		
		else if ((this.getLeft() != null) || this.getMiddle() != null || 
				(this.getRight() != null)) {
			throw new FullDirectoryException("Directory is full.");
		}
		

	}
	
}
