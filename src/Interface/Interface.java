/**
 * Interface
 * 
 * Description: The interface class simplifies the readability of main by separating the majority 
 *              of the ParkingTracker's prompts
 *          
 * 
 * @author: Archana Gumber & Jordan Thompson
 * @version: 3.0
 */
package Interface;
import java.util.Scanner;

public class Interface {
    private Scanner user_input;  //needed for user input
    
    //default constructor just creates the variable for user input
    public Interface(){
        user_input = new Scanner(System.in);
    }
    
    //shows the main list of available options to the user, and returns a command
    public char ParkingLotInterface() {
        System.out.println("\n-----------------------------------------------------------\n");
        System.out.println("Enter 'A' to add a stall");
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
