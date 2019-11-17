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
        @Test
        public void testLocationConstructor(){
                CartesianCoordinate coord = new CartesianCoordinate(2.0,3.0,4.0);
                Location location = new Location(coord);
                assertEquals(coord,location.coord);
        }
}

