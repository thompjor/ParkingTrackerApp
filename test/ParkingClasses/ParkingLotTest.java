/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ParkingClasses;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jordan
 */
public class ParkingLotTest {
    
    public ParkingLotTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println ("Before Class ParkingLot");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println ("After Class ParkingLot");
    }
    
    @Before
    public void setUp() {
        System.out.print("Before Method ");
    }
    
    @After
    public void tearDown() {
        System.out.println("After Method\n\n");
    }

    /**
     * Test of showOccupiedList method, of class ParkingLot.
     */
    @Test
    public void testShowOccupiedList() {
        System.out.println("showOccupiedList");
        ParkingLot instance = new ParkingLot("Test Lot", 3);
        //none of the stalls in the initialized lot should be occupied
        System.out.println("SHOULD OUTPUT 'None':"); 
        instance.showOccupiedList();
    }

    /**
     * Test of showVacantList method, of class ParkingLot.
     */
    @Test
    public void testShowVacantList() {
        System.out.println("showVacantList");
        ParkingLot instance = new ParkingLot("Test Lot", 3);
        //all 3 stalls in the initialized lot should be vacant
        System.out.println("SHOULD OUTPUT STALLS 1, 2, AND 3:");
        instance.showVacantList();
    }

    /**
     * Test of showInServiceList method, of class ParkingLot.
     */
    @Test
    public void testShowInServiceList() {
        System.out.println("showInServiceList");
        ParkingLot instance = new ParkingLot("Test Lot", 3);
        //all 3 stalls in the initialized lot should be in service
        System.out.println("SHOULD OUTPUT STALLS 1, 2, AND 3:");
        instance.showInServiceList();
    }

    /**
     * Test of showOutOfServiceList method, of class ParkingLot.
     */
    @Test
    public void testShowOutOfServiceList() {
        System.out.println("showOutOfServiceList");
        ParkingLot instance = new ParkingLot("Test Lot", 3);
        //none of the stalls in the initialized lot should be out of service
        System.out.println("SHOULD OUTPUT 'None':");
        instance.showOutOfServiceList();
    }

    /**
     * Test of DeleteParkingStall method, of class ParkingLot.
     */
    @Test
    public void testDeleteParkingStall() {
        System.out.println("DeleteParkingStall");
        int num = 3;
        ParkingLot instance = new ParkingLot("Test Lot", 3);
        assert(instance.FindParkingStall(num) != null);  //the last stall exists
        instance.DeleteParkingStall(num);
        assert(instance.FindParkingStall(num) == null);  //the last stall no longer exists
        num = 1;
        assert(instance.FindParkingStall(num) != null);  //the first stall exists 
        instance.DeleteParkingStall(num);
        assert(instance.FindParkingStall(num) == null);  //the first stall no longer exists
        System.out.println("SHOULD OUTPUT THAT THE STALL WAS NOT FOUND");
        instance.DeleteParkingStall(num); //cannot delete the same stal again, since it no longer exists
    }

    /**
     * Test of AddParkingStall method, of class ParkingLot.
     */
    @Test
    public void testAddParkingStall() {
        System.out.println("AddParkingStall");
        ParkingLot instance = new ParkingLot("Test Lot", 3);
        assert(instance.FindParkingStall(4) == null); //the stall does not yet exist
        instance.AddParkingStall();
        assert(instance.FindParkingStall(4) != null); //the stall now exists
    }

    /**
     * Test of AddStalls method, of class ParkingLot.
     */
    @Test
    public void testAddStalls() {
        System.out.println("AddStalls");
        int num = 3;
        ParkingLot instance = new ParkingLot("Test Lot", 3);
        //the next three stalls do not exist
        assert(instance.FindParkingStall(4) == null);
        assert(instance.FindParkingStall(5) == null);
        assert(instance.FindParkingStall(6) == null);
        instance.AddStalls(num);
        //now, the next three stalls exist
        assert(instance.FindParkingStall(4) != null);
        assert(instance.FindParkingStall(5) != null);
        assert(instance.FindParkingStall(6) != null);
        
    }

    /**
     * Test of FindParkingStall method, of class ParkingLot.
     */
    @Test
    public void testFindParkingStall() {
        System.out.println("FindParkingStall");
        int num = 0;
        ParkingLot instance = new ParkingLot("Test Lot", 3);
        //try to find a stall which does not exist, should return null
        ParkingStall expResult = null;
        ParkingStall result = instance.FindParkingStall(num);
        assertEquals(expResult, result);
        
        num = 3;
        ParkingStall testStall = new ParkingStall(true, true, num, null);
        //try to find a stall which does  exist, should return the stall
        result = instance.FindParkingStall(num);
        expResult = testStall;
        assertEquals(expResult.getNumber(), result.getNumber());
    
    }
    
}
