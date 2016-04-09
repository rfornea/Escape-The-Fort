import java.util.Scanner;

		/* This class is used for printing out the longer messages that get to the console, and 
		 * is also used for the "enterToContinue" method.
		 */

public class ConsoleMessages {

	//print out the game intro
	public static void intro() {
		
		System.out.print("\n...You awaken in an unfamiliar room with stone floors and a high ceiling. \n"
	                        + "'Where am I?', you wonder, looking around. The room likes like something out \n"
	                        + "of a fortress. The main doorway leading outside is bricked over, preventing exit. \n"
	                        + "The other doors are boarded up with wood and nails and should be easier to break \n"
	                        + "through. You stand up to assess the situation and notice a canteen and a scroll in \n"
	                        + "the corner. You pick up the scroll to read it. \n\n");
	}
	
	//print out scroll with rules
	public static void printScroll() {
			System.out.print("Dear puny human,\n\n"
							+ "      Contratulations! We, the trolls, have selected you to help us figure out what puny \n"
							+ "humans are able to withstand.  Here is what you need to know to stand any chance of surviving: \n\n");
			System.out.print("      Rules for Escaping the Fortress\n\n");
			System.out.print( "1.  Avoid the dangerous monster lurking in one random room of the fortress. \n"
							+ "    It will kill you.\n"
							+ "2.  You must break through the main bricked-up door in the foyer to escape the  \n"
							+ "    fortrees. It will take 16 days to break through this door. \n"
							+ "3.  You only have a 15 day supply of water in your canteen. Hah! This means you \n"
							+ "    MUST find more water in the fortress to win the game. There is a fresh supply \n"
							+ "    of water in a random room. \n"
							+ "4.  You will also need to find the pickaxe to chip away at the main door, since you \n"
							+ "    can't tear down those bricks with your hands. This will be in another random room. \n"
							+ "5.  It will take you 1 full day to break through the boarded up doors to get to a new \n"
							+ "    room, so entering every new room for the first time will cost 1 day of water. \n"
							+ "7.  The monster, the extra water supply, and the pickaxe are all in different rooms, and \n"
							+ "    each time you play the game they will be in different rooms. \n\n");
			System.out.print("The short version: find the axe, find the water supply, avoid the monster, \n"
							+ "then break down the main door.\n\n");
			System.out.print("                              Sincerely, \n\n"
						   + "                          Agnar the Troll King\n\n");
			System.out.print("P.S.  Everyone else who tried this is dead. Have fun!\n\n");
	}
	
	//use for pauses at beginning of game
	public static void enterToContinue() {
		System.out.println("Press enter to continue...");
		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();
		//keyboard.close()
		//program has errors when keyboard.close() is working, 
		//commenting it out for now
	}
		
	//describe each room we are in
	public static void roomDescription() {	
			if (FortMovement.getCurrentRow() == 0 && FortMovement.getCurrentColumn() == 0 ) {		
				//Foyer
				System.out.print("You're in the foyer of the fortress. The bricked up door still \n"
						+ "awaits, but at least there are other ways out of this room.\n\n");
			}	
			if (FortMovement.getCurrentRow() == 0 && FortMovement.getCurrentColumn() == 1) {	
				//Mess Hall
				System.out.print("This room appears to be a mess hall. There are dozens of \n"
						+ "worn wooden tables and you can smell a faint aroma of beer and sweat.\n\n");
			}
			if (FortMovement.getCurrentRow() == 0 && FortMovement.getCurrentColumn() == 2) {	
				//Kitchen
				System.out.print("These trolls certainly don't keep a tidy kitchen! There are \n"
						+ "dirty dishes piled up in the sink.\n\n");
			}
			if (FortMovement.getCurrentRow() == 0 && FortMovement.getCurrentColumn() == 3) {	
				//Pantry
				System.out.print("This looks like a pantry. There are barrels (probably full of \n"
						+ "beer), meat hanging to dry age, loaves of bread, and shelves full of spices, \n"
						+ "flour, sugar, salt, lard, and more. \n\n");
			}
			if (FortMovement.getCurrentRow() == 1 && FortMovement.getCurrentColumn() == 0) {	
				//Lounge
				System.out.print("You walk into a lounge. There are comfy-looking chairs and couches \n"
						+ "couches around the room, stuffed animal heads and tapestries on the wall, \n"
						+ "and a huge firplace that isn't currently burning. \n\n");
			}
			if (FortMovement.getCurrentRow() == 1 && FortMovement.getCurrentColumn() == 1) {	
				//Training Hall
				System.out.print("Cool, a training hall! There are dummies, punching bags, bull's eyes, \n"
						+ "and anything else a troll could possibly need to learn to kill. \n\n");
			}
			if (FortMovement.getCurrentRow() == 1 && FortMovement.getCurrentColumn() == 2) {	
				//Armory
				System.out.print("This must be an armory. All along the walls are swords, axes, maces \n"
						+ "bows and arrows, daggers, and some other weapons you don't recognize. \n\n");
			}
			if (FortMovement.getCurrentRow() == 1 && FortMovement.getCurrentColumn() == 3) {	
				//Uniform Storage
				System.out.print("The trolls obviously take great pride in their armor. Unlike many other rooms \n"
						+ "you've seen, the armor storage room is very tidy and every piece of armor looks carfully polished. \n\n");
			}
			if (FortMovement.getCurrentRow() == 2 && FortMovement.getCurrentColumn() == 0) {
				//Memorial Hall 
				System.out.print("...Interesting. The trolls have a room specifically dedicated to honor their \n"
						+ "fallen comrades. Portraits, along with retired pieces of armor, adorn the walls of the \n"
						+ "memorial hall. \n\n");
			}
			if (FortMovement.getCurrentRow() == 2 && FortMovement.getCurrentColumn() == 1) {
				//Library 
				System.out.print("It's a library, chock full of dusty books. The trolls must not read very much. \n\n");
			}
			if (FortMovement.getCurrentRow() == 2 && FortMovement.getCurrentColumn() == 2) {
				//War Room
				System.out.print("Huh. This room has one huge table with lots of chairs. There are maps all over \n"
						+ "the wall of the surrounding territories, as well as books on battle strategy. This must be \n"
						+ "where the trolls plan their attacks. \n\n");
			}
			if (FortMovement.getCurrentRow() == 2 && FortMovement.getCurrentColumn() == 3) {
				//Infirmary
				System.out.print("This room is full of cots, medical instruments, and opaque bottles of...some kind \n"
						+ "of medicine? Ew, there seems to be dried blood on the floorwhat. This must be an infirmary.  \n\n");
			}
			if (FortMovement.getCurrentRow() == 3 && FortMovement.getCurrentColumn() == 0) {
				//Barracks 1 
				System.out.print("This looks like a barracks. Most of the beds are unmade and you smell an odor of dirty feet. \n\n");  
			}
			if (FortMovement.getCurrentRow() == 3 && FortMovement.getCurrentColumn() == 1) {
				//Bathroom
				System.out.print("A smell hits your nose like a ton of bricks. You find yourself in a large bathroom full of \n"
						+ "chamber pots. Unsurprisingly, no bathtubs. \n\n");
			}
			if (FortMovement.getCurrentRow() == 3 && FortMovement.getCurrentColumn() == 2) {
				//Throne Room
				System.out.print("A huge throne sits on one wall of the room, and chandeliers hang from the ceiling. Lavish \n"
						+ "rugs decorate the floor, and the walls are filled with mounted heads of the trolls' dead enemies. This must \n"
						+ "be a throne room where Agnar the Troll King spends most of his time. \n\n");
			}
			if (FortMovement.getCurrentRow() == 3 && FortMovement.getCurrentColumn() == 3) {
				//Master Bedroom
				System.out.print("You're in a beautiful bedroom. The furnishings are fancier than anything you've seen \n"
						+ "in the fortress so far. This must be Agnar's bedroom. \n\n");
			}		
	}	
	
	//ends game if you find the monster
	public static void monsterMessage() {
		
		System.out.println("                   \\                   /");
		System.out.println("            ________))                ((__________");
		System.out.println("           /.-------./\\\\    \\    /    //\\.--------.\\");
		System.out.println("          /#######//##\\\\    ))  ((   //##\\##########\\");
		System.out.println("         /#######//###((   ((    ))  ))###\\##########\\");
		System.out.println("        ((#######((#####\\\\  \\\\  //  //#####))########))");
		System.out.println("         \\##' `###\\######\\\\  \\)(/  //######/####' `##/");
		System.out.println("          )'    ``#)'  `##\\`->oo<-'/##'  `(#''     `(");
		System.out.println("                  (     `` \\`.. '/''       )");
		System.out.println("                            \\   /");
		System.out.println("                             `- )");
		System.out.println("                             / /");
		System.out.println("                            ( /\\  ");
		System.out.println("                           /\\| \\");
		System.out.println("                          (  \\");
		System.out.println("                              )");
		System.out.println("                             /");
		System.out.println("                            ("); 
		System.out.println("BAD NEWS! You entered the room with the monster. \n"
				+ "Looks like the troll fortress is pretty deadly after all.\n\n");
		System.exit(0);
	}

	//ends game if you quit the game early 
	public static void earlyExitMessage() {
		System.out.println("####             ########        #######     ############  #########");                
		System.out.println("####           ############    ###########   ############  ###########");       
		System.out.println("####          #####    #####  ####     ####  ####          ####    ####");        
		System.out.println("####          ####      ####  ####           ####          ####     ###");               
		System.out.println("####          ####      ####   #########     ###########   ####    ####");  
		System.out.println("####          ####      ####    ##########   ###########   ###########");               
		System.out.println("####          ####      ####           ####  ####          ########");                
		System.out.println("####          #####    #####  ####     ####  ####          #### ####");              
		System.out.println("############   ############    ###########   ############  ####  ####");               	
		System.out.println("############     ########        #######     ############  ####   ####");
		System.out.print("\nQuiting early?  Bah!  See you next time!\n\n");	
		System.exit(0);
	}
	
	//ends game if you survive and successfully break down the door
	public static void congratulationsMessage() {
		System.out.println("###########  #########     #############  #############  ########          ########     #######   #######");
		System.out.println("###########  ###########   #############  #############  ###########     ############   ######## ########");
		System.out.println("###########  ####   #####  #############  #############  ############   #####    #####  #### ### ### ####");
		System.out.println("####         ####   #####  ####           ####           ####    #####  ####      ####  #### ####### ####");
		System.out.println("##########   ###########   ##########     ##########     ####     ####  ####      ####  ####  #####  ####");
		System.out.println("##########   ########      ##########     ##########     ####     ####  ####      ####  ####   ###   ####");
		System.out.println("####         #########     ####           ####           ####    #####  ####      ####  ####   ###   ####");
		System.out.println("####         #### #####    #############  #############  ############   #####    #####  ####   ###   ####");
		System.out.println("####         ####  #####   #############  #############  ###########     ############   ####   ###   ####");		
		System.out.println("####         ####   #####  #############  #############  ########          ########     ####   ###   ####");						
		System.out.println("\n\nFree at Last after 16 long days of hacking away at the main door of the troll fortress! \n"
				+ "You notice a note nailed to a tree outside the fortress. \n\n"
				+ "    \"Dear puny human, \n\n"
				+ "         If you're reading this, that means you survived our test.  \n"
				+ "   You're the first person to survive our fortress. I guess we'll \n"
				+ "   have to make it tougher the next time. \n\n"
				+ "                                     Sincerely, \n\n "
				+ "                                Agnar the Troll King\"\n\n");
		System.out.println("Conratulations and thanks for playing!");
		System.exit(0);
	}
	
	//ends game if you die of thirst 
	public static void failureMessage() {
		System.out.println("   ########         #####      ####        ####  ############");              
		System.out.println(" ############       #####      #####      #####  ############");             
		System.out.println("#####    #####     #######     #####      #####  ####        ");             
		System.out.println("####      ####     #######     ######    ######  ####        ");                
		System.out.println("####              #### ####    ######    ######  ########### ");                      
		System.out.println("####   #######    #### ####    #######  #######  ########### ");                   
		System.out.println("####   #######   ###########   ################  ####        ");            
		System.out.println("#####    #####   ###########   #### ###### ####  ####        ");          
		System.out.println(" ############   ####     ####  #### ###### ####  ############");         		
		System.out.println("   ########     ####     ####  ####  ####  ####  ############"); 
		System.out.println(""); 
		System.out.println("   ########     ####     ####  ############  #########");             
		System.out.println(" ############   ####     ####  ############  ###########");            
		System.out.println("#####    #####   ####   ####   ####          ####    ####");             
		System.out.println("####      ####   ####   ####   ####          ####     ###");            
		System.out.println("####      ####    #### ####    ###########   ####    ####");                      
		System.out.println("####      ####    #### ####    ###########   ##########");                   
		System.out.println("####      ####     #######     ####          ########");            
		System.out.println("#####    #####     #######     ####          #### ####");          
		System.out.println(" ############       #####      ############  ####  ####");         		
		System.out.println("   ########         #####      ############  ####   ####");     
		System.out.println("\n\nYou die of thirst before you can escape the troll fortress.");
		System.out.println("                  Thanks for playing!");
		System.exit(0);
	}

	public static void mainDoorFailureMessage() {
		System.out.println("   ########         #####      ####        ####  ############");              
		System.out.println(" ############       #####      #####      #####  ############");             
		System.out.println("#####    #####     #######     #####      #####  ####        ");             
		System.out.println("####      ####     #######     ######    ######  ####        ");                
		System.out.println("####              #### ####    ######    ######  ########### ");                      
		System.out.println("####   #######    #### ####    #######  #######  ########### ");                   
		System.out.println("####   #######   ###########   ################  ####        ");            
		System.out.println("#####    #####   ###########   #### ###### ####  ####        ");          
		System.out.println(" ############   ####     ####  #### ###### ####  ############");         		
		System.out.println("   ########     ####     ####  ####  ####  ####  ############"); 
		System.out.println(""); 
		System.out.println("   ########     ####     ####  ############  #########");             
		System.out.println(" ############   ####     ####  ############  ###########");            
		System.out.println("#####    #####   ####   ####   ####          ####    ####");             
		System.out.println("####      ####   ####   ####   ####          ####     ###");            
		System.out.println("####      ####    #### ####    ###########   ####    ####");                      
		System.out.println("####      ####    #### ####    ###########   ##########");                   
		System.out.println("####      ####     #######     ####          ########");            
		System.out.println("#####    #####     #######     ####          #### ####");          
		System.out.println(" ############       #####      ############  ####  ####");         		
		System.out.println("   ########         #####      ############  ####   ####");     
		System.out.println("\n\n  You keep on chopping for days and days and days....");
		System.out.println("...but your run out of water before the 16 days are over.");
		System.out.println("                  Thanks for playing!");
		System.exit(0);		
	}
}
