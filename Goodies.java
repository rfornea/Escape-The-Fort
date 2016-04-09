import java.util.Random;

public class Goodies {
	
	//Vars
	
	//ints
	private static int monsterRow;                    //row of the room where the monster is
	private static int monsterColumn;                 //column of the room where the monster is
	private static int waterSupplyRow;                //row of the room where the water supply is
	private static int waterSupplyColumn;             //column of the room where the water supply is
	private static int axeRow;                        //row of the room where the axe is
	private static int axeColumn;                     //column of the room where axe is
	private static int canteen;                       //how many days worth of water we have left
	
	//booleans
	private static boolean haveAxe = false;           //do we have the axe in storage, or not?
	private static boolean initialHaveAxe = false;    /* only needed for one method to print out a message when 
													   *  we first find the axe */
	private static boolean initialFoundWater = false; /* only needed for one method to print out a message when 
	                                                   *  we first find the water supply */
	
	//random number generator
	private static Random goodieLocation = new Random(); 	

		
	//Methods
	
	//sets column and row of the monster at the start of the game
	public static void setMonsterLocation() {
		monsterRow = goodieLocation.nextInt(4); 
		monsterColumn = goodieLocation.nextInt(4); 
		if ((monsterRow == 0 && monsterColumn == 0) || (monsterRow == 0 && monsterColumn == 1) ||
			(monsterRow == 1 && monsterColumn == 0)) {
				setMonsterLocation();
		}
	}
	
	//calls the methods to set the "Goodies" in random rooms of the fortress
	public static void setGoodies() {
		setMonsterLocation();
		setWaterLocation();
		setAxeLocation();		
	}
	
	//sets column and row of the water supply at the start of the game
	public static void setWaterLocation() {
		waterSupplyRow = goodieLocation.nextInt(4); 
		waterSupplyColumn = goodieLocation.nextInt(4); 
		if (((waterSupplyRow == monsterRow) && (waterSupplyColumn == monsterColumn)) || (waterSupplyRow == 0 && waterSupplyColumn == 0)) {
			setWaterLocation();
		}
	}
	
	//sets column and row for the axe at the start of the game
	public static void setAxeLocation() {
		axeRow = goodieLocation.nextInt(4); 
		axeColumn = goodieLocation.nextInt(4); 
		if (((axeRow == monsterRow) && (axeColumn == monsterColumn)) || ((axeRow == waterSupplyRow) && (axeColumn == waterSupplyColumn)) 
			|| (axeRow == 0 && axeColumn == 0)) {
				setAxeLocation();
		} 
	}
	
	//returns current row where monster is
	public static int getMonsterRow() {
		return monsterRow;		
	}
	
	//returns current column where monster is
	public static int getMonsterColumn() {
		return monsterColumn;		
	}
	
	//returns current row of the water supply
	public static int getWaterSupplyRow() {
		return waterSupplyRow;		
	}
	
	//returns current column of the water supply
	public static int getWaterSupplyColumn() {
		return waterSupplyColumn;		
	}
	
	//after water supply found, move it to unreachable location so we can't find it again
	public static void deleteWaterLocation() {
		waterSupplyRow = 10;
		waterSupplyColumn = 10;		
	}
	
	//return the row where the axe is
	public static int getAxeRow() {
		return axeRow;		
	}
	
	//return the column where the axe is
	public static int getAxeColumn() {
		return axeColumn;		
	}
	
	// after axe is found, set axe location to unreachable location so we don't find it again
	public static void deleteAxeLocation() {
		axeRow = 10;
		axeColumn = 10;		
	}

	// set value of variable canteen to 15 at start of game
	public static void setCanteen() {
		canteen = 15;				
	}
	
	//return current value of canteen
	public static int getCanteen() {
		return canteen;		
	}
	
	/*called when we find the water supply.  the bool initialFoundWater is needed only once,
	and is used to print out a message that the water has been found, and is then set back to 
	false */
	public static void replenishCanteen() {
		canteen = canteen + 17;				
		deleteWaterLocation();
		initialFoundWater = true;
	}

	/*decrements the canteen--will only decrement for rooms we haven't entered;
	amountToDecrement will be zero for rooms we've already been in */
	public static void decrementCanteen() {
		int amountToDecrement = Doors.getDoorDays();		
		canteen = canteen - amountToDecrement;
	}
	
	/*when we are at the main door we have to decrement canteen differently, because we
	 * will be spending more than one day breaking down that door. 	 */
	public static void decrementCanteenatMainDoor() {
		canteen--;
	}
	
	/* This just prints out a line with the amount in the canteen, whether we have the
	 * axe, and how many days are left on the main door.	 */
	public static void canteenAxeMainDoorPrintout() {
		System.out.print("Canteen: " + Goodies.getCanteen() + " days      ");		
		if (haveAxe == false) {
			System.out.print("Axe found: No ");
		}
		if (haveAxe == true) {
			System.out.print("Axe found: YES");
		}
		System.out.print("      Days to break main door: " + BreakDownMainDoor.getDaysLeftOnMainDoor() +"\n\n");
	}
	
	/*when we find the axe we set this to true.  initialHaveAxe is used only once for 
	* printing a message */
	public static void setHaveAxeToTrue() {
		haveAxe = true;		
		deleteAxeLocation();
		initialHaveAxe = true;
	}
	
	//returns whether we have the axe or not
	public static boolean getHaveAxe() {
		return haveAxe;	
	}

	/*after each movement we make in the fort, this method checks if there are any "Goodies" in that room,
	 * and then calls other methods based on its results...prints the monster message, or replenishes the canteen,
	 * or sets haveAxe to true....or does nothing if none of them are found	 */
	public static void checkForGoodies() {	
		if (FortMovement.getCurrentRow() == monsterRow && FortMovement.getCurrentColumn() == monsterColumn){
			ConsoleMessages.monsterMessage();
		}
		if (FortMovement.getCurrentRow() == waterSupplyRow && FortMovement.getCurrentColumn() == waterSupplyColumn){
			replenishCanteen();
		}			
		if (FortMovement.getCurrentRow() == axeRow && FortMovement.getCurrentColumn() == axeColumn){
			setHaveAxeToTrue();
		}					
	}
	
	/* prints a message if we find the axe or the water.  This is the method where initialHaveAxe and 
	 * initialFoundWater are used one time each, so this message doesn't get printed again. 
	 * Also if we are one room away from the monster, print the GRRRR warning so the user will 
	 * stay away.  */
	public static void goodiePrints() {
		if (initialHaveAxe == true) {
			System.out.println("GOOD NEWS! You found the axe! Now you can break down the main door!\n");
			initialHaveAxe = false;		
		}
		if (initialFoundWater == true) {
			System.out.println("GOOD NEWS! You found the water supply! Your canteen is replenished!\n");
			initialFoundWater = false;		
		}
		if (((FortMovement.getCurrentRow() == monsterRow) && (FortMovement.getCurrentColumn() == monsterColumn + 1 || FortMovement.getCurrentColumn() == monsterColumn - 1)) ||
				   ((FortMovement.getCurrentColumn() == monsterColumn) && (FortMovement.getCurrentRow() == monsterRow + 1 || FortMovement.getCurrentRow() == monsterRow - 1))) {
			System.out.println("GRRRRRRRRRRRRRRRRRRRR......You hear a growling sound. But you aren't sure which way it's coming from...\n");
		}
	}
}
