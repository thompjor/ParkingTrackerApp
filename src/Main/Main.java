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
 * @version: 3.0
 */

package Main;

import ParkingClasses.ParkingLot;
import ParkingClasses.ParkingStall;
import Interface.Interface;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
          //needed for user inpt
          Scanner user_input = new Scanner(System.in);
          //places most of the prompts within another class, simplifying the presentation of main
          Interface inter = new Interface();
         
          boolean done = false;     //determines if the user is done entering commands       
          char command;             //represents the commands a user can enter
          int numStalls;            //the number of stalls a user wants to initialize the parking lot to 
          String lotName;           //the name the user wants to initialize the parking lot with
          ParkingStall stall;       //holds the address for a single stall within the lot, which can be manipulated
          
          
          System.out.println("Welcome to the parking tracker application!\n");
          
          //Prompts the user for the name and number of stalls within their lot, and initializes it
          System.out.println("First, you must initialize the parking lot you wish to track.");
          System.out.print("Please enter the name of the parking lot you are creating: ");
          lotName = user_input.next();
          System.out.print("Please enter the number of stalls in the parking lot you are creating: ");
          numStalls = user_input.nextInt();
          ParkingLot Lot1 = new ParkingLot(lotName, numStalls);
          
          //do-loop repeatedly requests and executes user commands, and continues until the user is done (enters 'q'/'Q')
          do {
          //shows the main list of available options to the user, and gets a command
          command = inter.ParkingLotInterface();
          
          //interprets the command, and executes the appropriate functions
          switch (command) {
              case 'A':
              case 'a': Lot1.AddParkingStall(); break;
              case 'S':
              case 's': stall = Lot1.FindParkingStall(); //finds the requested stall
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
          
          System.out.println("Have a great day!");
          
    } 
}
