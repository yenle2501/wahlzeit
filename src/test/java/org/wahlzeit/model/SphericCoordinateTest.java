package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

/**
 * Test-class for class SphericCoordinate
 */
public class SphericCoordinateTest {

        /**
         * two double values are assumed equal if it's different is lower than this THRESHOLD
         */
        private static final double THRESHOLD =  0.00000000001;

        // Cartesian Coordinates
        private CartesianCoordinate cartesian1;
        private CartesianCoordinate cartesian2;


        // Spherical Coordinates
        private SphericCoordinate spheric1;
        private SphericCoordinate spheric2;

        @Before
        public void setUp(){
            cartesian1 = CartesianCoordinate.getCoordinate(1.0,2.0,3.0);
            cartesian2 = CartesianCoordinate.getCoordinate(4.0,5.0,6.0);

            spheric1 = SphericCoordinate.getCoordinate(3.7416573867739413, 0.6405223126794245, 1.1071487177940904);
            spheric2 = SphericCoordinate.getCoordinate(8.774964387392123, 0.8178885561654512, 0.8960553845713439);
        }

         @Test(expected = IllegalArgumentException.class)
         public void testConstructor_withNullValue(){
             SphericCoordinate  spheric_n1 =  SphericCoordinate.getCoordinate(Double.NaN, 0.6405223126794245, 1.1071487177940904);
             SphericCoordinate  spheric_n2 =  SphericCoordinate.getCoordinate(8.774964387392123, Double.NaN, 1.1071487177940904);
             SphericCoordinate  spheric_n3 =  SphericCoordinate.getCoordinate(8.774964387392123, 0.6405223126794245, Double.NaN);

             SphericCoordinate  spheric_n4 =  SphericCoordinate.getCoordinate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
             SphericCoordinate  spheric_n5 =  SphericCoordinate.getCoordinate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY);
             SphericCoordinate  spheric_n6 =  SphericCoordinate.getCoordinate(Double.NEGATIVE_INFINITY,2.0,Double.POSITIVE_INFINITY);
             SphericCoordinate  spheric_n7 =  SphericCoordinate.getCoordinate(2.0,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
             SphericCoordinate  spheric_n8 =  SphericCoordinate.getCoordinate(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,2.0);
         }

        @Test
        public void testConstructor(){
            assertEquals(cartesian1.getX(),1.0, THRESHOLD);
            assertEquals(cartesian1.getY(), 2.0,THRESHOLD);
            assertEquals(cartesian1.getZ(),3.0, THRESHOLD)  ;

            assertEquals(cartesian2.getX(),4.0, THRESHOLD)  ;
            assertEquals(cartesian2.getY() ,5.0, THRESHOLD) ;
            assertEquals(cartesian2.getZ(), 6.0, THRESHOLD)  ;

            assertEquals(spheric1.getRadius(),3.7416573867739413, THRESHOLD)  ;
            assertEquals(spheric1.getTheta(),0.6405223126794245, THRESHOLD) ;
            assertEquals(spheric1.getPhi(),1.1071487177940904, THRESHOLD)  ;

            assertEquals(spheric2.getRadius(),8.774964387392123, THRESHOLD)  ;
            assertEquals(spheric2.getTheta(), 0.8178885561654512, THRESHOLD) ;
            assertEquals(spheric2.getPhi() ,0.8960553845713439, THRESHOLD)  ;

        }


        @Test
        public void testAsCartesianCoordinate(){
            CartesianCoordinate cartesian_2 = spheric2.asCartesianCoordinate();

            assertEquals(cartesian2.getX(), cartesian_2.getX(), THRESHOLD);
            assertEquals(cartesian2.getY(), cartesian_2.getY(), THRESHOLD);
            assertEquals(cartesian2.getZ(), cartesian_2.getZ(), THRESHOLD);
        }


        @Test
        public void testGetCartesianCoordinate(){
            assertEquals(0.0, spheric1.getCartesianDistance(spheric1), THRESHOLD);
            assertEquals(0.0, spheric2.getCartesianDistance(spheric2), THRESHOLD);

            double power_distance = Math.pow(4.0 - 1.0,2) + Math.pow(5.0- 2.0,2) + Math.pow(6.0 - 3.0,2);
            assertEquals(Math.sqrt(power_distance), spheric1.getCartesianDistance(spheric2), THRESHOLD);
            assertEquals(Math.sqrt(power_distance), spheric2.getCartesianDistance(spheric1), THRESHOLD);
        }


        @Test
        public void testAsSphericCoordinate(){
            assertTrue(spheric1.asSphericCoordinate().isEqual(spheric1));
            assertTrue(spheric2.asSphericCoordinate().isEqual(spheric2));
        }


        @Test
        public void testGetCentralAngle(){
            assertEquals(0.0, spheric1.getCentralAngle(spheric1), THRESHOLD);
            assertEquals(0.0, spheric2.getCentralAngle(spheric2), THRESHOLD);

            assertEquals(0.23659206192641294, spheric1.getCentralAngle(spheric2), THRESHOLD);
            assertEquals(0.23659206192641294, spheric2.getCentralAngle(spheric1), THRESHOLD);
        }

        @Test(expected=IllegalArgumentException.class)
        public void testGetCentralAngle_withNullValue(){
            spheric1.getCentralAngle(null);
            spheric2.getCentralAngle(null);
        }

        @Test
        public void testIsEqual(){

            assertTrue(spheric1.isEqual(spheric1));
            assertTrue(spheric2.isEqual(spheric2));

            assertFalse(spheric2.isEqual(spheric1));
            assertFalse(spheric1.isEqual(spheric2));
        }



    @Test
        public void testEquals(){
            assertTrue(spheric1.equals(spheric1));
            assertFalse(spheric2.equals(spheric1));
        }


        @Test
        public void testHashCode(){
            assertEquals(-598768273, spheric1.hashCode());
            assertEquals(-1471042909, spheric2.hashCode());
        }

    }

