
package Interface;

import ParkingClasses.ParkingLot;
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
public class InterfaceTest {
    
    public InterfaceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Before Class Interface");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("After Class Interface");
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
     * Test of Initialize method, of class Interface.
     */
    @Test
    public void testInitialize() {
        System.out.println("Initialize");
    }

    /**
     * Test of AddStallsInterface method, of class Interface.
     */
    @Test
    public void testAddStallsInterface() {
        System.out.println("AddStallsInterface");
    }

    /**
     * Test of DeleteStallsInterface method, of class Interface.
     */
    @Test
    public void testDeleteStallsInterface() {
        System.out.println("DeleteStallsInterface");
    }

    /**
     * Test of FindStallInterface method, of class Interface.
     */
    @Test
    public void testFindStallInterface() {
        System.out.println("FindStallInterface");
    }

    /**
     * Test of ParkingLotInterface method, of class Interface.
     */
    @Test
    public void testParkingLotInterface() {
        System.out.println("ParkingLotInterface");
    }

    /**
     * Test of ParkingStallInterface method, of class Interface.
     */
    @Test
    public void testParkingStallInterface() {
        System.out.println("ParkingStallInterface");
    }

    /**
     * Test of ListInterface method, of class Interface.
     */
    @Test
    public void testListInterface() {
        System.out.println("ListInterface");
    }
    
}
