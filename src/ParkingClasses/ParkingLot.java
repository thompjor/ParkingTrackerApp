/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ParkingClasses;

import java.util.Scanner;
/**
 *
 * @author Jordan
 */
public class ParkingLot {
    private String name;
    private ParkingStall head;
    
    public ParkingLot() {
        name = "";
        head = null;
    }
    
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
    
    public void showOccupiedList() {
        System.out.println("The following are the stalls which are occupied:");
        for (ParkingStall current = head; current != null; current = current.getNext()) {
            if (current.getIsOccupied() == true)
                System.out.println(current.getNumber());
        }      
    }
    
    public void showVacantList() {
        System.out.println("The following are the stalls which are vacant:");
        for (ParkingStall current = head; current != null; current = current.getNext()) {
            if (current.getIsOccupied() == false)
                System.out.println(current.getNumber());
        }     
    }
    
    public void showInServiceList() {
        System.out.println("The following are the stalls which are in service:");
        for (ParkingStall current = head; current != null; current = current.getNext()) {
            if (current.getIsInService() == true)
                System.out.println(current.getNumber());
        }     
    }
    
    public void showOutOfServiceList() {
        System.out.println("The following are the stalls which are currently out of service:");
        for (ParkingStall current = head; current != null; current = current.getNext()) {
            if (current.getIsInService() == false)
                System.out.println(current.getNumber());
        }     
    }
    
    public void AddParkingStall() {
        ParkingStall current;
        
        for (current = head; current.getNext() != null; current = current.getNext()) {
        }
        
        ParkingStall newStall = new ParkingStall(false, true, current.getNumber() + 1, null);
        current.setNext(newStall);
        
        System.out.println("A stall has been added (number " + newStall.getNumber() + ")");
    }
    
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


