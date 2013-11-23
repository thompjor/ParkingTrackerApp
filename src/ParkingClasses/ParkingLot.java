/**
 * ParkingTracker
 * 
 * Description: The ParkingLot class contains the attributes and methods representing a real-world parking lot
 *              The parking lot is represented as a linked list of parking stalls
 * @author: Archana Gumber & Jordan Thompson
 * @version: 3.0
 */

package ParkingClasses;

import java.util.Scanner;

public class ParkingLot {
    private String name;         //parking lot's name
    private ParkingStall head;   //address of the first stall in the lot (since the lot is represented as a linked list)
    
    //default constructor; initializes both fields to empty values
    public ParkingLot() {
        name = "";
        head = null;
    }
    
    //initializing constructor; creates a ParkingLot object with the requested name and number of stalls. The stall are 
    //automatically assigned numbers counting from 1 to the # of stalls, and are connected in that order in a linked list
    public ParkingLot(String name_in, int num_stalls) {
        ParkingStall prev;
        ParkingStall newStall;
        name = name_in;
        head = new ParkingStall(false, true, 1,  null);
        prev = head;
        for (int i = 1; i < num_stalls; i++) {
            newStall = new ParkingStall(false, true, i + 1, null);
            prev.setNext(newStall);
            prev = newStall;
        }     
    }
    
    //displays a list of all stalls in the lot which are occupied, if any
    public void showOccupiedList() {
        int counter = 0;
        System.out.println("The following stalls are occupied:");
        for (ParkingStall current = head; current != null; current = current.getNext()) {
            if (current.getIsOccupied() == true) {
                System.out.println(current.getNumber());
                counter += 1;
            }
        }  
        if (counter == 0)
            System.out.println("None");
    }
    
    //displays a list of all stalls in the lot which are vacant, if any
    public void showVacantList() {
        int counter = 0;
        System.out.println("The following stalls are vacant:");
        for (ParkingStall current = head; current != null; current = current.getNext()) {
            if (current.getIsOccupied() == false) {
                System.out.println(current.getNumber());
                counter += 1;
            }
        }  
        if (counter == 0)
           System.out.println("None");
    }
    
    //displays a list of all stalls in the lot which are in service, if any
    public void showInServiceList() {
        int counter = 0;
        System.out.println("The following stalls are in service:");
        for (ParkingStall current = head; current != null; current = current.getNext()) {
            if (current.getIsInService() == true) {
                System.out.println(current.getNumber());
                counter += 1;
            }
        }     
        if (counter == 0)
          System.out.println("None");
    }
    
    //displays a list of all stalls in the lot which are out of service, if any
    public void showOutOfServiceList() {
        int counter = 0;
        System.out.println("The following stalls are out of service:");
        for (ParkingStall current = head; current != null; current = current.getNext()) {
            if (current.getIsInService() == false) {
                System.out.println(current.getNumber());
                counter += 1;
            }
        }     
        if (counter == 0)
          System.out.println("None");
    }
    
    //deletes the stall requested by the user from the linked list, and connects the surrounding links
    public void DeleteParkingStall() {
        //I still need to code this one...
    }
    
    //adds a parking stall to the end of the linked list, and numbers it 1 higher than the previous number
    public void AddParkingStall() {
        ParkingStall current;
        
        for (current = head; current.getNext() != null; current = current.getNext()) {
        }
        
        ParkingStall newStall = new ParkingStall(false, true, current.getNumber() + 1, null);
        current.setNext(newStall);
        
        System.out.println("A stall has been added (number " + newStall.getNumber() + ")");
    }
    
    //finds the stall requested by the user and returns it (returns null if it is not found)
    public ParkingStall FindParkingStall() {
        Scanner user_input = new Scanner(System.in);
        ParkingStall current;
        int num;
        System.out.print("What is the number of the stall you are searching for? ");
        num = user_input.nextInt();
        
        
        for (current = head; current != null; current = current.getNext()) {
            if (current.getNumber() == num) {
                System.out.println("The stall was found\n");
                return current; 
            }
        }
        
        System.out.println("The stall was not found\n");
        return current;
    }
}


