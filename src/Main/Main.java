/**
 * ParkingTracker
 * 
 * Description: The parking tracker application simulates a simple program which could be used to assign 
 *              and monitor the status of parking stalls within a parking lot. A user will create a lot with 
 *              desired number of stalls. From there, the user can add more stalls or remove existing stalls.
 *              beyond that, the user may also search for specific stalls and modify their status (A stall can 
 *              classified as in service or out of service, and as occupied or vacant).
 * 
 * @author: Archana Gumber & Jordan Thompson
 * @version: 4.0
 */

package Main;

import ParkingClasses.ParkingLot;
import ParkingClasses.ParkingStall;
import Interface.Interface;

public class Main {
    public static void main (String[] args) {
          //places most of the prompts within another class, simplifying the presentation of main
          Interface inter = new Interface();
         
          boolean done = false;     //determines if the user is done entering commands       
          char command;             //represents the commands a user can enter
          ParkingStall stall;       //holds the address for a single stall within the lot, which can be manipulated
          
          
          System.out.println("Welcome to the parking tracker application!\n");
          
          //initializes the ParkinGlot with a name and number of ParkingStalls
          ParkingLot Lot1 = inter.Initialize();
          
          //do-loop repeatedly requests and executes user commands, and continues until the user is done (enters 'q'/'Q')
          do {
          //shows the main list of available options to the user, and gets a command
          command = inter.ParkingLotInterface();
          
          //interprets the command, and executes the appropriate functions
          switch (command) {
              case 'A':
              case 'a': Lot1.AddStalls(inter.AddStallsInterface()); break;
              case 'D':
              case 'd': Lot1.DeleteParkingStall(inter.DeleteStallsInterface()); break;
              case 'S':
              case 's': stall = Lot1.FindParkingStall(inter.FindStallInterface()); //finds the requested stall
                        if (stall == null)
                            break; //will not continue if null is returned (ie the stall wasn't found) 
                       stall.printStall();   //prints the data within the stall
                       
                       //shows the list of available parking stall options to the user, and gets a command
                       command = inter.ParkingStallInterface();
                  
                       //interprets the command, and executes the appropriate functions
                       switch (command) {
                           case 'O':
                           case 'o': stall.toOccupied(); break;
                           case 'V':
                           case 'v': stall.toVacant(); break;
                           case 'S':
                           case 's': stall.toInService(); break;
                           case 'X':
                           case 'x': stall.toOutOfService(); break;
                           default: System.out.println("Invalid command"); break;
                       }
                       break;
              case 'L':
              case 'l': //shows the list of available listing options to the user, and gets a command
                        command = inter.ListInterface();
                       
                        //interprets the command, and executes the appropriate functions
                       switch (command) {
                           case 'O':
                           case 'o': Lot1.showOccupiedList(); break;
                           case 'V':
                           case 'v': Lot1.showVacantList(); break;
                           case 'S':
                           case 's': Lot1.showInServiceList(); break;
                           case 'X':
                           case 'x': Lot1.showOutOfServiceList(); break;
                           default: System.out.println("Invalid command"); break;
                       }
                       break;
              case 'Q':
              case 'q': done = true; break;
              default: System.out.println ("Invalid command");
          }
          } while (done == false);
          
          System.out.println("\nHave a great day!");
          
    } 
}
