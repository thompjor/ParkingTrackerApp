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
public class ParkingStallTest {
    
    public ParkingStallTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Before Class ParkingStall");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("After Class ParkingStall");
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
     * Test of toOccupied method, of class ParkingStall.
     */
    @Test
    public void testToOccupied() {
        System.out.println("toOccupied");
        ParkingStall instance1 = new ParkingStall(false, true, 1, null);
        ParkingStall instance2 = new ParkingStall(false, false, 1, null);
        instance1.toOccupied();
        instance2.toOccupied();
        //first instance should change to occupied , but second should not because it is out of service
        assert(instance1.getIsOccupied() == true);
        assert(instance2.getIsOccupied() == false);
    }

    /**
     * Test of toVacant method, of class ParkingStall.
     */
    @Test
    public void testToVacant() {
        System.out.println("toVacant");
        ParkingStall instance = new ParkingStall(true, true, 1, null);
        instance.toVacant();
        //should be changed to vacant
        assert(instance.getIsOccupied() == false);
    }

    /**
     * Test of toInService method, of class ParkingStall.
     */
    @Test
    public void testToInService() {
        System.out.println("toInService");
        ParkingStall instance = new ParkingStall(true, false, 1, null);
        instance.toInService();
        //should be changed to in service
        assert(instance.getIsInService() == true);
     
    }

    /**
     * Test of toOutOfService method, of class ParkingStall.
     */
    @Test
    public void testToOutOfService() {
        System.out.println("toOutOfService");
        ParkingStall instance1 = new ParkingStall(true, true, 1, null);
        ParkingStall instance2 = new ParkingStall(false, true, 1, null);
        instance1.toOutOfService();
        instance2.toOutOfService();
        //first instance should change to out of service, but second should not because it is occupied
        assert(instance1.getIsInService() == true);
        assert(instance2.getIsInService() == false);
    }

    /**
     * Test of getNext method, of class ParkingStall.
     */
    @Test
    public void testGetNext() {
        System.out.println("getNext");
        ParkingStall instance = new ParkingStall(true, true, 1, null);
        ParkingStall expResult = null;
        ParkingStall result = instance.getNext();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNext method, of class ParkingStall.
     */
    @Test
    public void testSetNext() {
        System.out.println("setNext");
        ParkingStall next_in = null;
        ParkingStall instance = new ParkingStall();
        instance.setNext(next_in);
        assert(instance.getNext() == null);
    }

    /**
     * Test of getIsInService method, of class ParkingStall.
     */
    @Test
    public void testGetIsInService() {
        System.out.println("getIsInService");
        ParkingStall instance = new ParkingStall(true, true, 1, null);
        boolean expResult = true;
        boolean result = instance.getIsInService();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsOccupied method, of class ParkingStall.
     */
    @Test
    public void testGetIsOccupied() {
        System.out.println("getIsOccupied");
        ParkingStall instance = new ParkingStall(true, true, 1, null);
        boolean expResult = true;
        boolean result = instance.getIsOccupied();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumber method, of class ParkingStall.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        int num = 6;
        ParkingStall instance = new ParkingStall(true, true, num, null );
        int expResult = num;
        int result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of printStall method, of class ParkingStall.
     */
    @Test
    public void testPrintStall() {
        System.out.println("printStall");
        ParkingStall instance = new ParkingStall(true, true, 6, null);
        System.out.println("SHOULD PRINT OUT THAT STALL 6 IS OCCUPIED AND IN SERVICE");
        instance.printStall();
    }
    
}
