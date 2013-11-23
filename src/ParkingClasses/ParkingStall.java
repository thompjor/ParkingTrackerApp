/**
 * ParkingTracker
 * 
 * Description: The ParkingStall class contains the attributes and methods representing a real-world parking stall
 *              The stalls themselves are represented as links within a linked list (the parking lot)
 * 
 * @author: Archana Gumber & Jordan Thompson
 * @version: 3.0
 */

package ParkingClasses;

public class ParkingStall {
    private boolean isOccupied;       //is the stall occupied or vacant?
    private boolean isInService;      //is the stall in service or out of service?
    private int number;               //the stall's number
    private ParkingStall next;        //points to the next stall in the linked list
    
    //default constructor; initializes the stall to in service & vacant, but gives it an invalid number
    public ParkingStall() {
        isOccupied =  false;
        isInService = false;
        number = -1;
        next = null;
    }
    
    //initializing constructor; initializes the object to the parameters supplied
    public ParkingStall(boolean occupied_in, boolean service_in, int number_in, ParkingStall next_in) {
        isOccupied = occupied_in;
        isInService = service_in;
        number = number_in;
        next = next_in;
    }
    
    //changes the stall to occupied, provided it is currently in service and vacant
    public void toOccupied() {
        if (isOccupied == true)
            System.out.println("The stall is already occupied\n");
        else {
            if (isInService == false)
                System.out.println("The stall cannot become occupied while it is out of service");
            else {
               isOccupied = true;
               System.out.println("The stall has been changed to occupied\n");
            }
        }
    }
    
     //changes the stall to vacant, provided it is currently occupied
    public void toVacant() {
        if (isOccupied == false)
            System.out.println("The stall is already vacant\n");
        else {
            isOccupied = false;
            System.out.println("The stall has been changed to vacant\n");
        }
    }
    
     //changes the stall to in service, provided it is currently out of service
    public void toInService() {
        if (isInService == true)
            System.out.println("The stall is already in service\n");
        else {
            isInService = true;
            System.out.println("The stall has been changed to in service\n");
        }
    }
    
     //changes the stall to out of service, provided it is currently in service and vacant
    public void toOutOfService() {
        if (isInService == false)
            System.out.println("The stall is already out of service\n");
        else {
            if (isOccupied == true)
               System.out.println("The stall cannot be changed to out of service while it is occupied");
            else {
               isInService = false;
               System.out.println("The stall has been changed to out of service\n");
            }
        }
    }
    
    //returns the next ParkingStall in the linked list
    public ParkingStall getNext() {
        return next;
    }
    
    //sets the next ParkingStall in the linked list
    public void setNext(ParkingStall next_in) {
        next = next_in;
    }
    
    //returns whether or not the ParkingStall is in service
    public boolean getIsInService() {
        return isInService;
    }
    
    //returns whether or not the ParkingStall is occupied
    public boolean getIsOccupied() {
        return isOccupied;
    }
    
    //returns the stall's number
    public int getNumber() {
        return number;
    }
    
    //prints the status of a ParkingStall
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
