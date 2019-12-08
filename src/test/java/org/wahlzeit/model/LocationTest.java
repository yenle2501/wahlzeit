package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test cases for Location class
 */
public class LocationTest {

        /***
         * Testcase for Constructor of Location-class
         */
        @Test(expected=IllegalArgumentException.class)
         public void testNullLocationConstructor()
        {
            Location location = new Location(null);
        }


        @Test
        public void testLocationConstructor(){
                CartesianCoordinate coord = new CartesianCoordinate(2.0,3.0,4.0);
                Location location = new Location(coord);

                assertEquals(coord,location.getCoordinate());
        }

        @Test
        public void testSetCoordinate(){
                CartesianCoordinate coord = new CartesianCoordinate(2.0,3.0,4.0);
                Location location = new Location(coord);
                CartesianCoordinate new_coord = new CartesianCoordinate(3.0,3.0,4.0);
                location.setCoordinate(new_coord);
                assertEquals(new_coord,location.getCoordinate());
        }


        @Test(expected=IllegalArgumentException.class)
        public void testSetNullCoordinate(){
                CartesianCoordinate coord = new CartesianCoordinate(2.0,3.0,4.0);
                Location location = new Location(coord);
                location.setCoordinate(null);
        }
}

