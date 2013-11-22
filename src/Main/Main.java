
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
 * @version: 2.0
 */

package Main;

import ParkingClasses.ParkingLot;
import ParkingClasses.ParkingStall;
import Interface.Interface;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        
          boolean done = false;
          char command;
          Scanner user_input = new Scanner(System.in);
          int numStalls;
          String lotName;
          ParkingStall stall;
          Interface inter = new Interface();
          
          System.out.println("Welcome to the parking tracker application!\n");
          
          System.out.print("Please enter the name of the parking lot you are creating: ");
          lotName = user_input.next();
          System.out.print("Please enter the number of stalls in the parking lot you are creating: ");
          numStalls = user_input.nextInt();
          ParkingLot Lot1 = new ParkingLot(lotName, numStalls);
          
          do {
          command = inter.ParkingLotInterface();
          
          switch (command) {
              case 'A':
              case 'a': Lot1.AddParkingStall(); break;
              case 'S':
              case 's': stall = Lot1.FindParkingStall();
                        if (stall == null)
                            break;
                       stall.printStall();
                       command = inter.ParkingStallInterface();
                  
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
              case 'l': command = inter.ListInterface();
                       
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
