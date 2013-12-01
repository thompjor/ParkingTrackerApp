/**
 * ParkingTracker
 * 
 * Description: The ParkingLot class contains the attributes and methods representing a real-world parking lot
 *              The parking lot is represented as a linked list of parking stalls
 * @author: Archana Gumber & Jordan Thompson
 * @version: 4.0
 */

package ParkingClasses;


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
        //if there are no occupied stalls... 
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
        //if there are no vacant stalls... 
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
        //if there are no in service stalls... 
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
        //if there are no out of service stalls... 
        if (counter == 0)
          System.out.println("None");
    }
    
    //deletes the stall requested by the user from the linked list, and connects the surrounding links
    public void DeleteParkingStall(int num) {
        ParkingStall current;      //the ParkingStall link in the list which is currently being tested
        ParkingStall prev = null;  //the ParkingStall link in the list just before current
        
        //cycles through the list until either the end is reached (current == null), or the link with the requested number is found
        for (current = head; current != null; current = current.getNext()) {
            if (current.getNumber() == num)
                break;
            prev = current;
        } 
        
        //if current is the first element in the list (current == head), make the next element the head and delete
        //if current is null, the item was not found
        //otherwise, perform normal deletion from list
        if (current == head) {
            head = current.getNext();
            System.out.println("Stall number " + num + " has been deleted");
        }
        else if (current == null) 
            System.out.println("The requested stall number was not found"); 
        else  {
            prev.setNext(current.getNext());
            System.out.println("Stall number " + num + " has been deleted");
        }
    }
    
    //adds a parking stall to the end of the linked list, and numbers it 1 higher than the previous number
    public void AddParkingStall() {
        ParkingStall current;
        
        //if there are no elements in the list (head == null), start a brand new one
        if (head == null) {
            ParkingStall firstStall = new ParkingStall(false, true, 1, null);
            head = firstStall;
            System.out.println("A stall has been added (number 1)");
            return;
        }
        
        //find the end of the list
        for (current = head; current.getNext() != null; current = current.getNext()) {
        }
        
        //create a new link and connect it at the end
        ParkingStall newStall = new ParkingStall(false, true, current.getNumber() + 1, null);
        current.setNext(newStall);
        
        System.out.println("A stall has been added (number " + newStall.getNumber() + ")");
    }
    
    //adds a single stall repeatedly, up to the number of times requested by the user
    public void AddStalls(int num) {
        for (int i = 0; i < num; i++)
            this.AddParkingStall();
    }
    
    //finds the stall requested by the user and returns it (returns null if it is not found)
    public ParkingStall FindParkingStall(int num) {
        ParkingStall current;
        
        //searches for the stall, returns it if found
        for (current = head; current != null; current = current.getNext()) {
            if (current.getNumber() == num) {
                System.out.println("The stall was found\n");
                return current; 
            }
        }
        
        //if not found, outputs message and returns null
        System.out.println("The stall was not found\n");
        return current;
    }
}


