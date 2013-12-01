/**
 * Interface
 * 
 * Description: The interface class simplifies the readability of main by separating the majority 
 *              of the ParkingTracker's prompts
 *          
 * 
 * @author: Archana Gumber & Jordan Thompson
 * @version: 4.0
 */
package Interface;
import java.util.Scanner;   //for user input
import ParkingClasses.ParkingLot;   //to temporarily hold a ParkingLot object for initialization

public class Interface {
    private Scanner user_input;  //needed for user input
    
    //default constructor just creates the variable for user input
    public Interface(){
        user_input = new Scanner(System.in);
    }
    
    //interface seen by the user when the program begins
    //has the user initialize their lot with a name (uneccessary in this version) and number of stalls
    public ParkingLot Initialize() {
        int numStalls;      //the number of stalls the lot will be initialized with
        String lotName;     //the name of the lot (uneccessary in this version)
        
        System.out.println("First, you must initialize the parking lot you wish to track.");
        System.out.print("Please enter the name of the parking lot you are creating: ");
        lotName = user_input.next();
        do {
            System.out.print("Please enter the number of stalls in the parking lot you are creating: ");
            numStalls = user_input.nextInt();
            if (numStalls <= 0)
                System.out.println("The parking lot must be initialized with a positive number of stalls");
        } while (numStalls <= 0);
        
        //returns a ParkingLot initialized as specified
        ParkingLot tempLot = new ParkingLot(lotName, numStalls);
        return tempLot;
    }
    
    //prompts user for the number of stalls to add, returns the value
    public int AddStallsInterface() {
        System.out.print("How many stalls would you like to add? ");
        return user_input.nextInt();
    }
    
    //prompts the user for the number of the stall to delete, reurns number
    public int DeleteStallsInterface() {
        System.out.print("What is the number of the stall you would like to delete? ");
        return user_input.nextInt();
    }
    
    //prompts the user for the number of the stall to find, returns number
     public int FindStallInterface() {
        System.out.print("What is the number of the stall you are searching for? ");
        return user_input.nextInt();
    }
 
    //shows the main list of available options to the user, and returns a command
    public char ParkingLotInterface() {
        System.out.println("\n-----------------------------------------------------------\n");
        System.out.println("Enter 'A' to add stalls");
        System.out.println("Enter 'D' to delete a stall");
        System.out.println("Enter 'L' to print a list");
        System.out.println("Enter 'S' to search for a stall by number");
        System.out.println("Enter 'Q' to quit");
        System.out.print("What would you like to do? ");
        return user_input.next().charAt(0);
    }
    
    //shows the list of available parking stall options to the user, and returns a command
    public char ParkingStallInterface() {
        System.out.println("\n-----------------------------------------------------------\n");
        System.out.println("Enter 'O' to change the stall to occupied");
        System.out.println("Enter 'V' to change the stall to vacant");
        System.out.println("Enter 'S' to change the stall to in-service");
        System.out.println("Enter 'X' to change the stall to out-of-service");
        System.out.print("What would you like to do? ");
        return user_input.next().charAt(0);
    }
    
    //shows the list of available listing options to the user, and returns a command
    public char ListInterface() {
        System.out.println("\n-----------------------------------------------------------\n");
        System.out.println("Enter 'O' to print a list of occupied stalls");
        System.out.println("Enter 'V' to print a list of vacant stalls");
        System.out.println("Enter 'S' to print a list of in-service stalls");
        System.out.println("Enter 'X' to quit to print a list of out-of-service stalls");
        System.out.print("What would you like to do? ");
        return user_input.next().charAt(0);
    }
}
