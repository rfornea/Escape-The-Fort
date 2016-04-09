
public class EscapeMain {
	
	/* This is the main class of the program.  We start the program off and then call a loop
	 * that loops the game until the player wins, loses, or quits. */	
	
	
	private static boolean roomCheck = false;  /* We have to check whether a room has been entered 
												* or not in order to decide whether to decrement 
												* the water in the canteen. */
	

	public static void main(String[] args) {		
		
		ConsoleMessages.intro();                  //intro message
		ConsoleMessages.enterToContinue();		  //pause
		ConsoleMessages.printScroll();			  //prints the scroll and the rules
		ConsoleMessages.enterToContinue();        //pause 
		
		Fort.createFort();						  //creates the fort

		Goodies.setGoodies();				      //puts monster, water supply, and axe in random locations
		Goodies.setCanteen();					  //puts 15 days of water in canteen
		
		Fort.printFort();						  //prints fort on first turn
		ConsoleMessages.roomDescription();		  //describes the room on first turn
		Goodies.canteenAxeMainDoorPrintout();     //status info
		mainLoop();								  //starts the mainloop where the rest of the program takes place
	}
	
	public static void mainLoop() {
		
		/*  as long as there is water in the canteen AND days left to break down the main door,
		 * we keep playing, unless the user quits or finds the monster. */
		while ( Goodies.getCanteen() >= 1 && BreakDownMainDoor.getDaysLeftOnMainDoor() >= 1 ){ 			
			FortMovement.whichWayToGo();		   		//prompt for direction--then calls method to edit & print the fort
			Goodies.checkForGoodies();			   		//check whether any goodies are in new room
			ConsoleMessages.roomDescription();	   		//describes the room
			Goodies.goodiePrints();
			roomCheck = Doors.returnRoomEntered(); 
			if ( !roomCheck ) { 				   		//if we haven't been in this room yet, decrement canteen by
				Goodies.decrementCanteen();        		// 1, then flag that we have been in that room so we  
				Doors.setDoorDaysToZero();          	// don't decrement again when we go back to that room */
			}
			Goodies.canteenAxeMainDoorPrintout();       //prints whether we found axe or water, or if the monster is near
			if (Goodies.getCanteen() == 0 && BreakDownMainDoor.getDaysLeftOnMainDoor() > 0) {
				ConsoleMessages.failureMessage();       //this if statement is unreachable; technically  				
			}										    //we will only ever die of thirst if we try breaking
		}											    //through the main door without finding the water supply
	}												    //first, and that is checked in a different method in the 
}													    //BreakDownTheMainDoor class. I left this here 
													    //because I will need it if I reduce the starting amount	
													    //in the canteen 
