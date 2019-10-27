package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test cases for Coordinate-class
 */
public class CoordinateTest {

    /**
     * Testcase for constructor
     */
    @Test
    public void testCoordinateTest(){
            double x = 1.0;
            double y = 2.0;
            double z = 3.0;

            Coordinate coord = new Coordinate(1.0,2.0,3.0);

            assertTrue(x == coord.getX());
            assertTrue(y == coord.getY());
            assertTrue(z == coord.getZ());
    }

    /**
     * Testcase for method getDistance()
     */
    @Test
    public void testgetDistance(){
        double epsilon = 0.00000001;

        Coordinate coord1 = new Coordinate(1.0,2.0,3.0);
        Coordinate coord2 = new Coordinate(2.0,3.0,4.0);

       assertEquals(0.0,coord1.getDistance(coord1),epsilon);
       assertEquals(0.0,coord2.getDistance(coord2),epsilon);
       assertEquals(Math.sqrt(3.0),coord1.getDistance(coord2),epsilon);
    }

    /**
     * Testcase for method getDistance() in case the given coordinate is null
     */
    @Test(expected = NullPointerException.class)
    public void testgetDistance_withNullCoordinate(){
        Coordinate coord1 = new Coordinate(1.0,2.0,3.0);
        coord1.getDistance(null);
    }

    /**
     * Testcase for method IsEqual()
     */
    @Test
    public void testIsEqual(){
        Coordinate coord1 = new Coordinate(1.0,2.0,3.0);
        Coordinate coord2 = new Coordinate(2.0,3.0,4.0);

        assertTrue(coord1.isEqual(coord1));
        assertFalse(coord1.isEqual(coord2));
        assertFalse(coord2.isEqual(coord1));

    }

    /**
     * Testcase for method  isEqual() in case the given coordinate is null
     */
    @Test(expected = NullPointerException.class)
    public void testIsEqual_withNullCoordinate(){
        Coordinate coord1 = new Coordinate(1.0,2.0,3.0);
        coord1.isEqual(null);
    }

    /**
     * Testcase for method equals()
     */
    @Test
    public void testEquals(){
        Coordinate coord1 = new Coordinate(1.0,2.0,3.0);
        Coordinate coord2 = new Coordinate(2.0,3.0,4.0);

        assertTrue(coord1.equals(coord1));
        assertFalse(coord1.equals(coord2));
        assertFalse(coord2.equals(coord1));

    }
}
