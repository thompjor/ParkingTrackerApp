/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ParkingClasses;

/**
 *
 * @author Jordan
 */
public class ParkingStall {
    private boolean isOccupied;
    private boolean isInService;
    private int number;
    private ParkingStall next;
    
    public ParkingStall() {
        isOccupied =  false;
        isInService = false;
        number = -1;
        next = null;
    }
    
    public ParkingStall(boolean occupied_in, boolean service_in, int number_in, ParkingStall next_in) {
        isOccupied = occupied_in;
        isInService = service_in;
        number = number_in;
        next = next_in;
    }
    
    public void toOccupied() {
        if (isOccupied == true)
            System.out.println("The stall is already occupied\n");
        else {
            isOccupied = true;
            System.out.println("The stall has been changed to occupied\n");
        }
    }
    
    public void toVacant() {
        if (isOccupied == false)
            System.out.println("The stall is already vacant\n");
        else {
            isOccupied = false;
            System.out.println("The stall has been changed to vacant\n");
        }
    }
    
    public void toInService() {
        if (isInService == true)
            System.out.println("The stall is already in service\n");
        else {
            isInService = true;
            System.out.println("The stall has been changed to in service\n");
        }
    }
    
    public void toOutOfService() {
        if (isInService == false)
            System.out.println("The stall is already out of service\n");
        else {
            isInService = false;
            System.out.println("The stall has been changed to out of service\n");
        }
    }
    
    public ParkingStall getNext() {
        return next;
    }
    
    public void setNext(ParkingStall next_in) {
        next = next_in;
    }
    
    public boolean getIsInService() {
        return isInService;
    }
    
    public boolean getIsOccupied() {
        return isOccupied;
    }
     
    public int getNumber() {
        return number;
    }
    
    public void printStall() {
        System.out.println("Status of parking stall " + number + ":");
        if (isOccupied)
            System.out.println("Occupied");
        else
            System.out.println("Vacant");
        
        if (isInService)
            System.out.println("In service");
        else
            System.out.println("Out of service");  
    }
}
