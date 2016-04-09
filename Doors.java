
public class Doors {
	
	
	/*all of these ints are initially set to 1, except doorDaysFoyer, 
	 * because that is how many days 	 * it will take the user to 
	 * break through the door for these rooms. When decrementing the 
	 * canteen we will deduct the value of these variables from 
	 * the value of canteen.  After each room is initially entered the value of
	 * any one of these ints will be set to 0, so that when canteen tries to 
	 * decrement upon the user re-entering the room, the value of canteen
	 * will not change.   
	 */
	/* doorDaysFoyer is set to 0 because we are already in the foyer at 
	 * the start of the game, and the main door is handled by a different
	 * variable in the BreakDownTheMainDoor class.
	 */
	public static int doorDaysFoyer = 0;
	public static int doorDaysMessHall = 1;
	public static int doorDaysKitchen = 1;
	public static int doorDaysPantry = 1;
	public static int doorDaysLounge = 1;
	public static int doorDaysTrainingHall = 1;
	public static int doorDaysArmory = 1;
	public static int doorDaysUniformStorage = 1;
	public static int doorDaysMemorialHall = 1;
	public static int doorDaysLibrary = 1;
	public static int doorDaysWarRoom = 1;
	public static int doorDaysInfirmary = 1;
	public static int doorDaysBarracks= 1;
	public static int doorDaysBathroom = 1;
	public static int doorDaysThroneRoom = 1;
	public static int doorDaysMasterBedroom = 1;

	/* when we enter a room set DoorDays to zero for that room so we
     * don't decrement canteen the next time we are in that room */	
	public static void setDoorDaysToZero() {
		if (FortMovement.getCurrentRow() == 0) {
			if (FortMovement.getCurrentColumn() == 0) {
				doorDaysFoyer = 0;
			}
			else if (FortMovement.getCurrentColumn() == 1) {
				doorDaysMessHall = 0;
			}
			else if (FortMovement.getCurrentColumn() == 2) {
				doorDaysKitchen = 0;
			}
			else if (FortMovement.getCurrentColumn() == 3) {
				doorDaysPantry = 0;
			}
		}
		else if (FortMovement.getCurrentRow() == 1) {
			if (FortMovement.getCurrentColumn() == 0) {
				doorDaysLounge = 0;
			}
			else if (FortMovement.getCurrentColumn() == 1) {
				doorDaysTrainingHall = 0;
			}
			else if (FortMovement.getCurrentColumn() == 2) {
				doorDaysArmory = 0;
			}
			else if (FortMovement.getCurrentColumn() == 3) {
				doorDaysUniformStorage = 0;
			}
		}
		else if (FortMovement.getCurrentRow() == 2) {
			if (FortMovement.getCurrentColumn() == 0) {
				doorDaysMemorialHall = 0;
			}
			else if (FortMovement.getCurrentColumn() == 1) {
				doorDaysLibrary = 0;
			}
			else if (FortMovement.getCurrentColumn() == 2) {
				doorDaysWarRoom = 0;
			}
			else if (FortMovement.getCurrentColumn() == 3) {
				doorDaysInfirmary = 0;
			}
		}
		else if (FortMovement.getCurrentRow() == 3) {
			if (FortMovement.getCurrentColumn() == 0) {
				doorDaysBarracks = 0;
			}
			else if (FortMovement.getCurrentColumn() == 1) {
				doorDaysBathroom = 0;
			}
			else if (FortMovement.getCurrentColumn() == 2) {
				doorDaysThroneRoom = 0;
			}
			else if (FortMovement.getCurrentColumn() == 3) {
				doorDaysMasterBedroom = 0;
			}
		}
	}
	
	
	/* this method returns the value of doorDays for a particular room.
	 * The value of 0 or 1 will tell the caller (returnRoomEntered) if 
	 * we've already been there or not. */
	public static int getDoorDays() {
		
		int doorDays = 2;
		//initialize to 2 because that isn't one of values we will need
		
		if (FortMovement.getCurrentRow() == 0) {
			if (FortMovement.getCurrentColumn() == 0) {
				doorDays = doorDaysFoyer;
			}
			else if (FortMovement.getCurrentColumn() == 1) {
				doorDays = doorDaysMessHall;
			}
			else if (FortMovement.getCurrentColumn() == 2) {
				doorDays = doorDaysKitchen;
			}
			else if (FortMovement.getCurrentColumn() == 3) {
				doorDays = doorDaysPantry;
			}
		}
		else if (FortMovement.getCurrentRow() == 1) {
			if (FortMovement.getCurrentColumn() == 0) {
				doorDays = doorDaysLounge;
			}
			else if (FortMovement.getCurrentColumn() == 1) {
				doorDays = doorDaysTrainingHall;
			}
			else if (FortMovement.getCurrentColumn() == 2) {
				doorDays = doorDaysArmory;
			}
			else if (FortMovement.getCurrentColumn() == 3) {
				doorDays = doorDaysUniformStorage;
			}
		}
		else if (FortMovement.getCurrentRow() == 2) {
			if (FortMovement.getCurrentColumn() == 0) { 
				doorDays = doorDaysMemorialHall;
			}
			else if (FortMovement.getCurrentColumn() == 1) {
				doorDays = doorDaysLibrary;
			}
			else if (FortMovement.getCurrentColumn() == 2) {
				doorDays = doorDaysWarRoom;
			}
			else if (FortMovement.getCurrentColumn() == 3) {
				doorDays = doorDaysInfirmary;
			}
		}
		else if (FortMovement.getCurrentRow() == 3) {
			if (FortMovement.getCurrentColumn() == 0) {
				doorDays = doorDaysBarracks;
			}
			else if (FortMovement.getCurrentColumn() == 1) {
				doorDays = doorDaysBathroom;
			}
			else if (FortMovement.getCurrentColumn() == 2) {
				doorDays = doorDaysThroneRoom;
			}
			else if (FortMovement.getCurrentColumn() == 3) {
				doorDays = doorDaysMasterBedroom;
			}
		}
		return doorDays;	
	}
	
	/* uses value of doorDays to return true if we've been in that room 
	 * or false if we haven't */
	public static boolean returnRoomEntered() {
		
		boolean roomEntered = false;	
		int doorDays = getDoorDays();
		
		if (doorDays == 1) {
			roomEntered = false;
		}
		if (doorDays == 0) {
			roomEntered = true;
		}
		return roomEntered;
	}	
}