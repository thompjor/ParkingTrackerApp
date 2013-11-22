
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import ParkingClasses.ParkingLot;
import ParkingClasses.ParkingStall;
import java.util.Scanner;
/**
 *
 * @author Jordan
 */
public class Main {
    public static void main (String[] args) {
        
          boolean done = false;
          char command;
          Scanner user_input = new Scanner(System.in);
          int numStalls;
          String lotName;
          ParkingStall stall;
          
          System.out.println("Welcome to the parking tracker application!\n");
          System.out.print("Please enter the name of the parking lot you are creating: ");
          lotName = user_input.next();
          System.out.print("Please enter the number of stalls in the parking lot you are creating: ");
          numStalls = user_input.nextInt();
          ParkingLot Lot1 = new ParkingLot(lotName, numStalls);
          
          do {
          System.out.println("\n-----------------------------------------------------------\n");
          System.out.println("Enter 'A' to add a stall");
          System.out.println("Enter 'L' to print a list");
          System.out.println("Enter 'S' to search for a stall by number");
          System.out.println("Enter 'Q' to quit");
          System.out.print("What would you like to do? ");
          command = user_input.next().charAt(0);
          
          switch (command) {
              case 'A':
              case 'a': Lot1.AddParkingStall(); break;
              case 'S':
              case 's': stall = Lot1.FindParkingStall();
                        if (stall == null)
                            break;
                       stall.printStall();
                       System.out.println("\n-----------------------------------------------------------\n");
                       System.out.println("Enter 'O' to change the stall to occupied");
                       System.out.println("Enter 'V' to change the stall to vacant");
                       System.out.println("Enter 'S' to change the stall to in-service");
                       System.out.println("Enter 'X' to change the stall to out-of-service");
                       System.out.print("What would you like to do? ");
                       command = user_input.next().charAt(0);
                  
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
              case 'l': 
                       System.out.println("\n-----------------------------------------------------------\n");
                       System.out.println("Enter 'O' to print a list of occupied stalls");
                       System.out.println("Enter 'V' to print a list of vacant stalls");
                       System.out.println("Enter 'S' to print a list of in-service stalls");
                       System.out.println("Enter 'X' to quit to print a list of out-of-service stalls");
                       System.out.print("What would you like to do? ");
                       command = user_input.next().charAt(0);
                       
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
          
          
          
    } 
}
