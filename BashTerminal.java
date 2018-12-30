import java.util.Scanner;

/* Vivian Lam
 * ID: 111549991
 * vivian.lam@stonybrook.edu
 * Homework 5
 * CSE214, R11 (Reed Gantz)
 */ 

public class BashTerminal {

	public static void main(String[] args) {
		
		DirectoryTree tree = new DirectoryTree();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Starting bash terminal.");
		String command = "";
		
		do {
			System.out.print("[vivlam@host]: $ ");
			command = input.nextLine();
			
			if (command.equals("pwd")) {
				tree.presentWorkingDirectory();
			}
			
			else if (command.equals("ls")) {
				tree.listDirectory();
			}
			
			else if (command.equals("ls -R")) {
				tree.printDirectoryTree();
			}
			
			else if (command.equals("cd /")) {
				tree.resetCuror();
			}
			
			else if (command.equals("cd ..")) {
				tree.changeToParent();
			}		
			
			else if (command.contains("cd")) {
				String str = "";
				int index = command.indexOf(" ");
				str = command.substring(index + 1);
				
				try {
					tree.changeDirectory(str);
				} catch (NotADirectoryException ex) {
					System.out.println("ERROR: Cannot change directory into a file.");
				}
			}
			
			else if (command.contains("mkdir")) {
				String str = "";
				int index = command.indexOf(" ");
				str = command.substring(index + 1);
				
				try {
					tree.makeDirectory(str);
				} catch (FullDirectoryException ex) {
					System.out.println("No room for a new node");
				}
			}
			
			else if (command.contains("touch")) {
				String str = "";
				int index = command.indexOf(" ");
				str = command.substring(index + 1);
				
				try {
					tree.makeFile(str);
				} catch (FullDirectoryException ex) {
					System.out.println("Error: Present directory is full.");
				}
			}
			
			else if (command.equals("exit")) {
				System.out.println("System terminating gracefully.");
				System.exit(0);
			}
			
			else 
				System.out.println("Invalid command. Try again.");
		} while (command != "exit");

	}

}
