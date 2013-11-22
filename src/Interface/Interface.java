/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;
import java.util.Scanner;

/**
 *
 * @author Jordan
 */
public class Interface {
    private Scanner user_input; 
    
    public Interface(){
        user_input = new Scanner(System.in);
    }
    
    public char ParkingLotInterface() {
        System.out.println("\n-----------------------------------------------------------\n");
        System.out.println("Enter 'A' to add a stall");
        System.out.println("Enter 'L' to print a list");
        System.out.println("Enter 'S' to search for a stall by number");
        System.out.println("Enter 'Q' to quit");
        System.out.print("What would you like to do? ");
        return user_input.next().charAt(0);
    }
    
    public char ParkingStallInterface() {
        System.out.println("\n-----------------------------------------------------------\n");
        System.out.println("Enter 'O' to change the stall to occupied");
        System.out.println("Enter 'V' to change the stall to vacant");
        System.out.println("Enter 'S' to change the stall to in-service");
        System.out.println("Enter 'X' to change the stall to out-of-service");
        System.out.print("What would you like to do? ");
        return user_input.next().charAt(0);
    }
    
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
