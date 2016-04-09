public class BreakDownMainDoor {
	
	
	private static int daysToBreakMainDoor = 16; 			/*the number of days left of working on the Main Door
	 														 *before we can break through it */
	
	//getter for the number days left before the main door is broken through
	public static int getDaysLeftOnMainDoor() {
		return daysToBreakMainDoor;
	}
	
	//decrement daysToBreakMainDoor after each day of trying to break through the main door
	public static void decrementDaysLeftOnMainDoor() {
		daysToBreakMainDoor--;
	}
	
	/* This method breaks through the main door, then calls a congratulations message.
	 *     Notes:    
	 *   		2.  The method whichWayToGo() in FortMovement checks if we have the axe or not.  If we don't, then
	 *   			breakDownTheDoor() does not get called.  
	 *   		3.  whichWayToGo() also checks if we have enough water or not. If we don't, it will ask us if
	 *   			we want to proceed. If we select "Y", we die of thirst. If we select "N" we can continue
	 *   			the game until we find the water.  breakDownTheDoor() is only called once we have everything
	 *   			we need to get through the main door.  
	 *   		4.  Once we get to this method there is no going back.  
	 */
	public static void breakDownTheDoor() {		
		while (daysToBreakMainDoor >= 1 && Goodies.getCanteen() >= 1) {	
			decrementDaysLeftOnMainDoor();
			Goodies.decrementCanteenatMainDoor();	
			System.out.println("You chop and chop and chop..." + daysToBreakMainDoor + " days left.");
			ConsoleMessages.enterToContinue();
			if (daysToBreakMainDoor <= 1 && Goodies.getCanteen() >= daysToBreakMainDoor) {
				ConsoleMessages.congratulationsMessage();
			}					
		}		
	}	
}
