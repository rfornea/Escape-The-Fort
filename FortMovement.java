import java.util.Scanner;

public class FortMovement {	
	
	private static int currentRow; 							//what row we are currently in
	private static int currentColumn; 						//what column we are currently in
	
	static Scanner inputGetter = new Scanner(System.in);    //need this for input
	
	//returns current row
	public static int getCurrentRow() {
		return currentRow;		
	}	
	
	//sets current row, at the very start of the game
	public static void setCurrentRow() {
		currentRow = 0;	
	}	
	
	//modifies current row after user makes a move
	public static void setCurrentRow(int rowChange) {
		currentRow = currentRow + rowChange;	
	}	
	
	//returns current column
	public static int getCurrentColumn() {
		return currentColumn;		
	}
	
	//sets current column at start of game
	public static void setCurrentColumn() {
		currentColumn = 0;
	}
	
	//changes current column based on user's moves
	public static void setCurrentColumn(int columnChange) {
		currentColumn = currentColumn + columnChange;	
	}
	
	//goes down, moves current row down by 1
	public static void goDown() {
		setCurrentRow(1);	
	}
	
	//goes up, moves current row up by 1
	public static void goUp() {
		setCurrentRow(-1);
	}
	
	//goes right, moves current column right by 1
	public static void goRight() {
		setCurrentColumn(1);
	}
	
	//goes left, moves current column left by 1
	public static void goLeft() {
		setCurrentColumn(-1);
	}
	
	//doesn't go anywhere...deducts 0 from row and 0 from column 
	public static void goNowhere() {
		setCurrentColumn(0);
		setCurrentRow(0);	
	}

	/* calls another movement method based on user input then edits and prints the fort
	 * alternatively calls a quit method if the user wanted to quit */
	public static void makeMovement(char directionChar) {
		if (directionChar == 'Q') {
			ConsoleMessages.earlyExitMessage();
		}
		else if (directionChar == 'D') {
			goDown();
			Fort.editFort();			
			Fort.printFort();
		}
		else if (directionChar == 'U') {
			goUp();
			Fort.editFort();			
			Fort.printFort();
		}
		else if (directionChar == 'L') {
			goLeft();
			Fort.editFort();			
			Fort.printFort();
		}
		else if (directionChar == 'R') {
			goRight();
			Fort.editFort();			
			Fort.printFort();
		}
		else if (directionChar == 'N'){
			goNowhere();
			Fort.editFort();			
			Fort.printFort();
		}
		else {
			goNowhere();
			Fort.editFort();			
			Fort.printFort();
		}
		
	}
	
	//if the user made a choice they weren't supposed to make  
	public static void directionSelectionError() {
		System.out.println("Something went wrong with your choice, let's try again.");
		whichWayToGo(); 
	}

	/* based on the user's current location, asks them which way they want to go
	 * sends them to directionSelectionError if they made a choice they can't make, 
	 * for example going left while at the leftmost column */
	public static void whichWayToGo() {
		
		//the initial values of these variables aren't important
		String direction = "x";
		char directionChar; 
		String tryDoor = "x";
		char tryDoorChar;
		
		if (getCurrentRow() == 0 && getCurrentColumn() == 0 && Goodies.getHaveAxe() == true) {
			System.out.print("Type 'D' or 'R' for down or right, 'Q' to quit...\n"
							 + "...or 'U' if you're ready to try breaking down the main door: ");
			direction = inputGetter.next().toUpperCase();
			directionChar = direction.charAt(0);
			if (directionChar == 'U') {			
				if (Goodies.getCanteen() < BreakDownMainDoor.getDaysLeftOnMainDoor()) {
					System.out.println("\nYou will run out of water before you can break though this door!");
					System.out.print("Are you sure you want to proceed? Type 'Y' for yes or 'N' for no:  ");			
					tryDoor = inputGetter.next().toUpperCase();
					tryDoorChar = tryDoor.charAt(0);
					while (tryDoorChar != 'Y' && tryDoorChar != 'N') {
						System.out.println("\nInvalid input!  ");
						System.out.print("Are you sure you want to proceed? Type 'Y' for yes or 'N' for no:  ");	
						tryDoor = inputGetter.next().toUpperCase();
						tryDoorChar = tryDoor.charAt(0);
					}
					if (tryDoorChar == 'Y') {
						ConsoleMessages.mainDoorFailureMessage();
					}			
					else if (tryDoorChar == 'N') {
						FortMovement.makeMovement(tryDoorChar);
					}
					else {
						directionSelectionError();
					}
				}
				else {
			    BreakDownMainDoor.breakDownTheDoor();
				}
			}
			else if (directionChar == 'D' || directionChar == 'R' || directionChar == 'Q') {
				FortMovement.makeMovement(directionChar);
			}		
			else {
				directionSelectionError();
			}
		}
		else if (getCurrentRow() == 0 && getCurrentColumn() == 0 && Goodies.getHaveAxe() == false) {
			System.out.print("You can go down or right, or quit the game.  Type 'D', 'R', or 'Q':  ");
			direction = inputGetter.next().toUpperCase();
			directionChar = direction.charAt(0);
			if (directionChar == 'U') {
				System.out.println("\nYou can't break through that door yet.  You don't have the axe!");
				ConsoleMessages.enterToContinue();
				FortMovement.makeMovement('N');
			}
			else if (directionChar == 'D' || directionChar == 'R' || directionChar == 'Q') {
				FortMovement.makeMovement(directionChar);				
			}		
			else {
				directionSelectionError();
			}
		}
		else if (getCurrentRow() == 0 && ((getCurrentColumn() == 1) || (getCurrentColumn() == 2))) {
			System.out.print("You can go down, right, left, or quit the game.  Type 'D', 'R', 'L', or 'Q':  ");
			direction = inputGetter.next().toUpperCase();
			directionChar = direction.charAt(0);
			if (directionChar == 'D' || directionChar == 'R' || directionChar == 'L' ||directionChar == 'Q') {
				FortMovement.makeMovement(directionChar);
			}		
			else {
				directionSelectionError();
			}
		}
		else if (getCurrentRow() == 0 && getCurrentColumn() == 3) {
			System.out.print("You can go down or left, or quit the game.  Type 'D', 'L', or 'Q':  ");
			direction = inputGetter.next().toUpperCase();
			directionChar = direction.charAt(0);
			if (directionChar == 'D' || directionChar == 'L' ||directionChar == 'Q') {
				FortMovement.makeMovement(directionChar);
			}		
			else {
				directionSelectionError();
			}
		}
		else if ((getCurrentRow() == 1 || getCurrentRow() == 2) && getCurrentColumn() == 0) {
			System.out.print("You can go up, down, right, or quit the game.  Type 'U', 'D', 'R', or 'Q':  "); 
			direction = inputGetter.next().toUpperCase();
			directionChar = direction.charAt(0);
			if (directionChar == 'D' || directionChar == 'R' || directionChar == 'U' ||directionChar == 'Q') {
				FortMovement.makeMovement(directionChar);
			}		
			else {
				directionSelectionError();
			}
		}
		else if ((getCurrentRow() == 1 || getCurrentRow() == 2) && ((getCurrentColumn() == 1) || (getCurrentColumn() == 2))) {
			System.out.print("You can go up, down, right, left, or quit the game.  Type 'U', 'D', 'R', 'L' or 'Q':  ");
			direction = inputGetter.next().toUpperCase();
			directionChar = direction.charAt(0);
			if (directionChar == 'U' || directionChar == 'D' || directionChar == 'R' || directionChar == 'L' ||directionChar == 'Q') {
				FortMovement.makeMovement(directionChar);
			}		
			else {
				directionSelectionError();
			}
		}
		else if ((getCurrentRow() == 1 || getCurrentRow() == 2) && getCurrentColumn() == 3) {
			System.out.print("You can go up, down, left, or quit the game.  Type 'U', 'D', 'L', or 'Q':  "); 
			direction = inputGetter.next().toUpperCase();
			directionChar = direction.charAt(0);
			if (directionChar == 'U' || directionChar == 'D' || directionChar == 'L' ||directionChar == 'Q') {
				FortMovement.makeMovement(directionChar);
			}		
			else {
				directionSelectionError();
			}
		}
		else if (getCurrentRow() == 3 && getCurrentColumn() == 0) {
			System.out.print("You can go up, right, or quit the game.  Type 'U', 'R', or 'Q':  "); 
			direction = inputGetter.next().toUpperCase();
			directionChar = direction.charAt(0);
			if (directionChar == 'U' || directionChar == 'R' || directionChar == 'Q') {
				FortMovement.makeMovement(directionChar);
			}		
			else {
				directionSelectionError();
			}
		}
		else if (getCurrentRow() == 3 && ((getCurrentColumn() == 1) || (getCurrentColumn() == 2))) {
			System.out.print("You can go up, right, left, or quit the game.  Type 'U', 'R', 'L', or 'Q':  "); 
			direction = inputGetter.next().toUpperCase();
			directionChar = direction.charAt(0);
			if (directionChar == 'U' || directionChar == 'R' || directionChar == 'L' ||directionChar == 'Q') {
				FortMovement.makeMovement(directionChar);
			}		
			else {
				directionSelectionError();
			}
		}
		else if (getCurrentRow() == 3 && getCurrentColumn() == 3) {
			System.out.print("You can go up, left, or quit the game.  Type 'U', 'L', or 'Q':  "); 
			direction = inputGetter.next().toUpperCase();
			directionChar = direction.charAt(0);
			if ( directionChar == 'U' || directionChar == 'L' || directionChar == 'Q' ) {
				FortMovement.makeMovement(directionChar);
			}		
			else if ( directionChar != 'U' && directionChar != 'L' && directionChar != 'Q' ){
				directionSelectionError();
			}
		}
	}
}
