package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test cases for Cartesian Coordinate-class
 */
public class CartesianCoordinateTest {

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
        cartesian1 =  CartesianCoordinate.getCoordinate(1.0,2.0,3.0);
        cartesian2 =  CartesianCoordinate.getCoordinate(4.0,5.0,6.0);

        spheric1 = SphericCoordinate.getCoordinate(3.7416573867739413, 0.6405223126794245, 1.1071487177940904);
        spheric2 = SphericCoordinate.getCoordinate(8.774964387392123, 0.8178885561654512, 0.8960553845713439);
    }

    @Test
    public void testContsructor(){
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

    @Test(expected = IllegalArgumentException.class)
    public void test_invalidConstructor(){
        CartesianCoordinate  cartesian_i1 =  CartesianCoordinate.getCoordinate(Double.NaN,5.0,6.0);
        CartesianCoordinate  cartesian_i2 =  CartesianCoordinate.getCoordinate(4.0,Double.NaN,6.0);
        CartesianCoordinate  cartesian_i3 =  CartesianCoordinate.getCoordinate(4.0,5.0,Double.NaN);

        CartesianCoordinate  cartesian_i4 =  CartesianCoordinate.getCoordinate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
        CartesianCoordinate  cartesian_i5 =  CartesianCoordinate.getCoordinate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY);
        CartesianCoordinate  cartesian_i6 =  CartesianCoordinate.getCoordinate(Double.NEGATIVE_INFINITY,2.0,Double.POSITIVE_INFINITY);
        CartesianCoordinate  cartesian_i7 =  CartesianCoordinate.getCoordinate(2.0,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
        CartesianCoordinate  cartesian_i8 =  CartesianCoordinate.getCoordinate(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,2.0);

    }


    @Test
    public void testAsCartesianCoordinate(){

        assertEquals(cartesian1, cartesian1.asCartesianCoordinate());
        assertEquals(cartesian2, cartesian2.asCartesianCoordinate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCartesianCoordinate_withNullValue(){
        cartesian1.getCartesianDistance(null);
    }

    @Test
    public void testGetCartesianCoordinate(){
        assertEquals(0.0, cartesian1.getCartesianDistance(cartesian1), THRESHOLD);
        assertEquals(0.0, cartesian2.getCartesianDistance(cartesian2), THRESHOLD);

        double power_distance = Math.pow(4.0 - 1.0,2) + Math.pow(5.0- 2.0,2) + Math.pow(6.0 - 3.0,2);
        assertEquals(Math.sqrt(power_distance), cartesian1.getCartesianDistance(cartesian2), THRESHOLD);
        assertEquals(Math.sqrt(power_distance), cartesian2.getCartesianDistance(cartesian1), THRESHOLD);
    }


    @Test
    public void testAsSphericCoordinate(){
        assertTrue(cartesian1.asSphericCoordinate().isEqual(spheric1));
        assertTrue(cartesian2.asSphericCoordinate().isEqual(spheric2));
    }


    @Test
    public void testGetCentralAngle(){
        assertEquals(0.0, cartesian1.getCentralAngle(spheric1), THRESHOLD);
        assertEquals(0.0, cartesian2.getCentralAngle(spheric2), THRESHOLD);

        assertEquals(0.23659206192641294, cartesian1.getCentralAngle(spheric2), THRESHOLD);
        assertEquals(0.23659206192641294, cartesian2.getCentralAngle(spheric1), THRESHOLD);
    }


    @Test
    public void testIsEqual(){

        assertTrue(cartesian1.isEqual(cartesian1));
        assertTrue(cartesian2.isEqual(cartesian2));
        assertFalse(cartesian1.isEqual(cartesian2));
    }

    @Test
    public void testEquals(){
        assertTrue(cartesian1.equals(cartesian1));
        assertFalse(cartesian1.equals(cartesian2));
    }


    @Test
    public void testHashCode(){
        assertEquals(66584576, cartesian1.hashCode());
        assertEquals(2123628544, cartesian2.hashCode());
    }

}
