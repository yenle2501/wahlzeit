package org.wahlzeit.model;

import java.util.HashMap;
import org.wahlzeit.utils.PatternInstance;
/**
 * This class represents the cartesian coordinate system
 */
@PatternInstance(
        patternName = "Value Object",
        participants = {"CartesianCoordinate"}
)
public class CartesianCoordinate extends  AbstractCoordinate {

    //x,y,z represent point x, y and z in the x-axis, y-axis and z-axis
    private final double x;
    private final double y;
    private final double z;


    /**
     * HashSet of all cartesian coordinates
     */
    private static final HashMap<Integer,CartesianCoordinate> coordinates = new HashMap<Integer, CartesianCoordinate>();

    /**
     * two double values are assumed equal if it's different is lower than this THRESHOLD
     */
    private static final double THRESHOLD =  0.00000000001;

    // constructor
    public CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException{

        this.x = x;
        this.y = y;
        this.z = z;

        try {
            assertClassInvariants();
        }
        catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Cartesian Coordinate constructor is not valid");
        }
    }

    /**
     * @methodtype factory
     * @param x value in x-axis
     * @param y value in y-axis
     * @param z value in z-axis
     * @return a cartesian coordinate
     */
    public static CartesianCoordinate getCoordinate(double x, double y , double z){
        int key =  computeHashcode(x,y,z);
            if(!coordinates.containsKey(key)){
                CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);
                coordinates.put(key,cartesianCoordinate);

            }
            return coordinates.get(key);
    }


    /**
     * this method converts a coordinate to a Cartesian Coordinate
     * @methodtype conversion
     * @return a Cartesian Coordinate
     * */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    /**
    * get Distance of this coordinate to a given coordinate
    * @methodtype get
    * @param given_coord the given coordinate
    * @return distance between this coordinate and the given coordinate
    */
    @Override
    public double getCartesianDistance(Coordinate given_coord)  throws IllegalArgumentException  {
        assertIsNotNull(given_coord,"The given Coordinate");

        CartesianCoordinate cartesianCoordinate = given_coord.asCartesianCoordinate();

        double power_distance = Math.pow(cartesianCoordinate.x - this.x,2) + Math.pow(cartesianCoordinate.y - this.y,2) + Math.pow(cartesianCoordinate.z - this.z,2);
        double distance = Math.sqrt(power_distance);

        assert Double.isFinite(distance);
        assert distance >= 0;

      return distance;
    }

    /**
     * this method converts a coordinate to a Spherical Coordinate
     * @methodtype conversion
     * @return a Spherical Coordinate
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        double power = Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2);
        double radius = Math.sqrt(power);
        double theta = (radius > 0.0) ? Math.acos(this.z/radius) : 0.0;
        double phi = (x != 0) ?  Math.atan2(this.y, this.x) :  0.0;

        return SphericCoordinate.getCoordinate(radius,theta,phi);
    }


    /**
     * compare this coordinate and the given coordinate
     * @methodtype boolean query
     * @param coordinate the given coordinate
     * @return true : if coordinates are equalTheta
     *         false: otherwise
     */
    @Override
    public boolean isEqual(Coordinate coordinate)  throws IllegalArgumentException {

        return this == coordinate;
    }

    /**
     * compute hash codes
     * @methodtype get
     */
    @Override
    public int hashCode() {
        return computeHashcode(this.x, this.y, this.z);
    }

    private static int computeHashcode(double x, double y, double z) {
        int hash = 7;
        hash = (int) (Double.doubleToLongBits(x) ^ (Double.doubleToLongBits(x) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(y) ^ (Double.doubleToLongBits(y)>>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(z) ^ (Double.doubleToLongBits(z)>>> 32));

        return hash;
    }


    /** get x of the coordinate
     * @methodtype get
     * @return x
     */
    public double getX(){
        return x;
    }

    /** get y of the coordinate
     * @methodtype get
     * @return y
     */
    public double getY(){
        return y;
    }

    /** get z of the coordinate
     * @methodtype get
     * @return z
     */
    public double getZ(){
        return z;
    }



    /**
     * check valid double value
     * @methodtpye assertion
     */
    protected void assertIsValidDouble(double value) {
        if(Double.isNaN(value) || !Double.isFinite(value)){
            throw new IllegalArgumentException("variable is not a double value");
        }
    }


    /** this method checks class invariant.
     * @methodtype assert
     */
    private void assertClassInvariants() throws IllegalArgumentException{
        assertIsValidDouble(x);
        assertIsValidDouble(y);
        assertIsValidDouble(z);
    }

}
