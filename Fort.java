
public class Fort {
	
	//an array of stringbuilders that make up the fort that we print to the console
	private static StringBuilder[] fortLines = new StringBuilder[21];	
	
	//creates the fort at begnning of game
	public static void createFort() {
		fortLines[0] = new StringBuilder("______*****_____________________________________________________");
		fortLines[1] = new StringBuilder("|               |               |               |               |");
		fortLines[2] = new StringBuilder("|     Foyer     |   Mess Hall   |    Kitchen    |    Pantry     |");
		fortLines[3] = new StringBuilder("|       x       |               |               |               |");
		fortLines[4] = new StringBuilder("|     (You)     |               |               |               |");
		fortLines[5] = new StringBuilder("|_______________|_______________|_______________|_______________|");
		fortLines[6] = new StringBuilder("|               |               |               |               |");
		fortLines[7] = new StringBuilder("|    Lounge     | Training Hall |    Armory     |Uniform Storage|");
		fortLines[8] = new StringBuilder("|               |               |               |               |");
		fortLines[9] = new StringBuilder("|               |               |               |               |");
		fortLines[10] = new StringBuilder("|_______________|_______________|_______________|_______________|");
		fortLines[11] = new StringBuilder("|               |               |               |               |");
		fortLines[12] = new StringBuilder("| Memorial Hall |    Library    |   War Room    |   Infirmary   |");
		fortLines[13] = new StringBuilder("|               |               |               |               |");
		fortLines[14] = new StringBuilder("|               |               |               |               |");
		fortLines[15] = new StringBuilder("|_______________|_______________|_______________|_______________|");
		fortLines[16] = new StringBuilder("|               |               |               |               |");
		fortLines[17] = new StringBuilder("|   Barracks    |   Bathroom    |  Throne Room  |Master Bedroom |");
		fortLines[18] = new StringBuilder("|               |               |               |               |");
		fortLines[19] = new StringBuilder("|               |               |               |               |");
		fortLines[20] = new StringBuilder("|_______________|_______________|_______________|_______________|");
	}
	
	//print out the fort for each turn
	public static void printFort() {
		for (int i = 0; i < fortLines.length; i++) {
			System.out.println(fortLines[i]);			
		}
	}
	
	/* make edits to the stringbuilders of the fort to display the fort 
	 * with changes after each move the user makes 
	 *   "(You)" is for the user to see where they are.  
	 *   "x" is for the user to see where they've already been (and where they are). */
	public static void editFort() {
		//this erases and moves the '(You)' text
		if (FortMovement.getCurrentRow() == 0 ) {
			fortLines[9] = fortLines[9].replace(0, 65, "|               |               |               |               |");
			fortLines[14] = fortLines[14].replace(0, 65, "|               |               |               |               |");
			fortLines[19] = fortLines[19].replace(0, 65, "|               |               |               |               |");
			if (FortMovement.getCurrentColumn() == 0 ) {
				fortLines[4] = fortLines[4].replace(0, 65, "|     (You)     |               |               |               |");
			}
			else if (FortMovement.getCurrentColumn() == 1 ) {
				fortLines[4] = fortLines[4].replace(0, 65, "|               |     (You)     |               |               |");
			}
			else if (FortMovement.getCurrentColumn() == 2 ) {
				fortLines[4] = fortLines[4].replace(0, 65, "|               |               |     (You)     |               |");
			}
			else if (FortMovement.getCurrentColumn() == 3 ) {
				fortLines[4] = fortLines[4].replace(0, 65, "|               |               |               |     (You)     |");
			}
		}
		else if (FortMovement.getCurrentRow() == 1 ) {
			fortLines[4] = fortLines[4].replace(0, 65, "|               |               |               |               |");
			fortLines[14] = fortLines[14].replace(0, 65, "|               |               |               |               |");
			fortLines[19] = fortLines[19].replace(0, 65, "|               |               |               |               |");
			if (FortMovement.getCurrentColumn() == 0 ) {
				fortLines[9] = fortLines[9].replace(0, 65, "|     (You)     |               |               |               |");
			}
			else if (FortMovement.getCurrentColumn() == 1 ) {
				fortLines[9] = fortLines[9].replace(0, 65, "|               |     (You)     |               |               |");
			}
			else if (FortMovement.getCurrentColumn() == 2 ) {
				fortLines[9] = fortLines[9].replace(0, 65, "|               |               |     (You)     |               |");
			}
			else if (FortMovement.getCurrentColumn() == 3 ) {
				fortLines[9] = fortLines[9].replace(0, 65, "|               |               |               |     (You)     |");
			}
		}
		else if (FortMovement.getCurrentRow() == 2 ) {
			fortLines[9] = fortLines[9].replace(0, 65, "|               |               |               |               |");
			fortLines[4] = fortLines[4].replace(0, 65, "|               |               |               |               |");
			fortLines[19] = fortLines[19].replace(0, 65, "|               |               |               |               |");
			if (FortMovement.getCurrentColumn() == 0 ) {
				fortLines[14] = fortLines[14].replace(0, 65, "|     (You)     |               |               |               |");
			}
			else if (FortMovement.getCurrentColumn() == 1 ) {
				fortLines[14] = fortLines[14].replace(0, 65, "|               |     (You)     |               |               |");
			}
			else if (FortMovement.getCurrentColumn() == 2 ) {
				fortLines[14] = fortLines[14].replace(0, 65, "|               |               |     (You)     |               |");
			}
			else if (FortMovement.getCurrentColumn() == 3 ) {
				fortLines[14] = fortLines[14].replace(0, 65, "|               |               |               |     (You)     |");
			}
		}
		else if (FortMovement.getCurrentRow() == 3 ) {
			fortLines[9] = fortLines[9].replace(0, 65, "|               |               |               |               |");
			fortLines[14] = fortLines[14].replace(0, 65, "|               |               |               |               |");
			fortLines[4] = fortLines[4].replace(0, 65, "|               |               |               |               |");
			if (FortMovement.getCurrentColumn() == 0 ) {
				fortLines[19] = fortLines[19].replace(0, 65, "|     (You)     |               |               |               |");
			}
			else if (FortMovement.getCurrentColumn() == 1 ) {
				fortLines[19] = fortLines[19].replace(0, 65, "|               |     (You)     |               |               |");
			}
			else if (FortMovement.getCurrentColumn() == 2 ) {
				fortLines[19] = fortLines[19].replace(0, 65, "|               |               |     (You)     |               |");
			}
			else if (FortMovement.getCurrentColumn() == 3 ) {
				fortLines[19] = fortLines[19].replace(0, 65, "|               |               |               |     (You)     |");
			}
		}			
		
		//this adds an 'x' text for everywhere we've already been
		if (FortMovement.getCurrentRow() == 0 ) {
			if (FortMovement.getCurrentColumn() == 0 ) {
				fortLines[3] = fortLines[3].replace(8, 9, "x");
			}
			else if (FortMovement.getCurrentColumn() == 1 ) {
				fortLines[3] = fortLines[3].replace(24, 25, "x");
			}
			else if (FortMovement.getCurrentColumn() == 2 ) {
				fortLines[3] = fortLines[3].replace(40, 41, "x");
			}
			else if (FortMovement.getCurrentColumn() == 3 ) {
				fortLines[3] = fortLines[3].replace(56, 57, "x");
			}
		}
		else if (FortMovement.getCurrentRow() == 1 ) {
			if (FortMovement.getCurrentColumn() == 0 ) {
				fortLines[8] = fortLines[8].replace(8, 9, "x");
			}
			else if (FortMovement.getCurrentColumn() == 1 ) {
				fortLines[8] = fortLines[8].replace(24, 25, "x");
			}
			else if (FortMovement.getCurrentColumn() == 2 ) {
				fortLines[8] = fortLines[8].replace(40, 41, "x");
			}
			else if (FortMovement.getCurrentColumn() == 3 ) {
				fortLines[8] = fortLines[8].replace(56, 57, "x");
			}
		}
		else if (FortMovement.getCurrentRow() == 2 ) {
			if (FortMovement.getCurrentColumn() == 0 ) {
				fortLines[13] = fortLines[13].replace(8, 9, "x");
			}
			else if (FortMovement.getCurrentColumn() == 1 ) {
				fortLines[13] = fortLines[13].replace(24, 25, "x");
			}
			else if (FortMovement.getCurrentColumn() == 2 ) {
				fortLines[13] = fortLines[13].replace(40, 41, "x");
			}
			else if (FortMovement.getCurrentColumn() == 3 ) {
				fortLines[13] = fortLines[13].replace(56, 57, "x");
			}
		}
		else if (FortMovement.getCurrentRow() == 3 ) {
			if (FortMovement.getCurrentColumn() == 0 ) {
				fortLines[18] = fortLines[18].replace(8, 9, "x");
			}
			else if (FortMovement.getCurrentColumn() == 1 ) {
				fortLines[18] = fortLines[18].replace(24, 25, "x");
			}
			else if (FortMovement.getCurrentColumn() == 2 ) {
				fortLines[18] = fortLines[18].replace(40, 41, "x");
			}
			else if (FortMovement.getCurrentColumn() == 3 ) {
				fortLines[18] = fortLines[18].replace(56, 57, "x");
			}
		}		
	}
}
