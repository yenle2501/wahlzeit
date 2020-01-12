package org.wahlzeit.model;

import java.util.HashMap;
import org.wahlzeit.utils.PatternInstance;
/**
 * This class represents the spherical coordinate system
 * Source: https://en.wikipedia.org/wiki/Spherical_coordinate_system
 */
@PatternInstance(
        patternName = "Value Object",
        participants = { "SphericCoordinate" }
)
public class SphericCoordinate extends  AbstractCoordinate {
    // the radial distance: radius  >= 0
    private final double radius;
    // the polar angle: 0 <= theta <= PI
    private final double theta;
    // the azimuthal angle: 0 <= phi < 2PI
    private final double phi;
    /**
     * two double values are assumed equal if it's different is lower than this THRESHOLD
     */
    private static final double THRESHOLD =  0.00000000001;

    /**
     * HashSet of all spherical coordinates
     */
    private static final HashMap<Integer,SphericCoordinate> coordinates = new HashMap<Integer, SphericCoordinate>();


    /**@param radius:the radial distance: radius  >= 0
     * @param theta: the polar angle: 0 <= theta <= PI
     * @param phi :the azimuthal angle: 0 <= phi < 2PI
     * @methodtype: constructor
    */
    public SphericCoordinate(double radius, double theta, double phi) {

        this.radius = radius;
        this.theta = theta;
        this.phi = phi;

        try {
            assertClassInvariants();
        }
        catch( IllegalArgumentException e){
            throw new IllegalArgumentException("one of 3 paramenters is invalid.");

        }
    }

    /**
     * @methodtype factory
     * @param radius:the radial distance: radius  >= 0
     * @param theta: the polar angle: 0 <= theta <= PI
     * @param phi :the azimuthal angle: 0 <= phi < 2PI
     * @return a spherical coordinate
     */
    public static SphericCoordinate getCoordinate(double radius, double theta, double phi) {
        int key = computeHashcode(radius, theta, phi);
        synchronized (coordinates) {
            if(!coordinates.containsKey(key)){
                SphericCoordinate sphericCoordinate = new SphericCoordinate(radius, theta, phi);
                coordinates.put(key,sphericCoordinate);
            }
            return coordinates.get(key);
        }
    }

    /** this method converts a coordinate to a Cartesian Coordinate
     * @methodtype conversion
     * @return a Cartesian Coordinate
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {

        double x = this.radius * Math.sin(this.theta) * Math.cos(this.phi);
        double y = this.radius * Math.sin(this.theta) * Math.sin(this.phi);
        double z = this.radius * Math.cos(this.theta);

        try {
            assertClassInvariants();
        }
        catch( IllegalArgumentException e){
            throw new IllegalArgumentException("one of 3 paramenters is invalid.");

        }

        return CartesianCoordinate.getCoordinate(x, y, z);
    }

    /**
     * this method converts a coordinate to a Spheric Coordinate
     * @methodtype conversion
     * @return this Spheric Coordinate
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    /**
     * @methodtype get
     * @param given_coord  the given Coordinate
     * @return central angle between this Coordinate and the given Coordinate
     * Sources:  https://en.wikipedia.org/wiki/Great-circle_distance
     *           https://en.wikipedia.org/wiki/Spherical_coordinate_system
     */
    @Override
    public double getCentralAngle(Coordinate given_coord) throws IllegalArgumentException{
        assertIsNotNull(given_coord,"The given Coordinate" );

        SphericCoordinate sphericCoordinate = given_coord.asSphericCoordinate();

        double deltaPhi = Math.abs(phi - sphericCoordinate.phi);
        double acosParam = Math.sin(theta) * Math.sin(sphericCoordinate.theta)
                + Math.cos(theta) * Math.cos(sphericCoordinate.theta) * Math.cos(deltaPhi);

       double centralAngle = Math.acos(acosParam);

       assert Double.isFinite(centralAngle);
       assert centralAngle >= 0;

       return centralAngle;

    }
    /**
     * compare this coordinate and the given coordinate
     * @methodtype boolean query
     * @param coordinate the given coordinate
     * @return true : if coordinates are equal
     *         false: otherwise
     */
    @Override
    public boolean isEqual(Coordinate coordinate) throws IllegalArgumentException{

        return this == coordinate;
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

    /**
     * compute hash codes
     * @methodtype get
     */
    @Override
    public int hashCode() {
        return computeHashcode(this.radius, this.theta, this.phi);
    }

    /** compute hashcode with given parameters
    * @return hashcode
    */

    private static int computeHashcode(double radius, double theta, double phi){
        int hash = 7;
        hash = (int) (Double.doubleToLongBits(radius) ^ (Double.doubleToLongBits(radius) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(theta) ^ (Double.doubleToLongBits(theta)>>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(phi) ^ (Double.doubleToLongBits(phi)>>> 32));

        return hash;
    }

    /**
     * @methodtype get
     * @return value of radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @methodtype get
     * @return value of theta
     */
    public double getTheta() {
        return theta;
    }

    /**
     * @methodtype get
     * @return value of phi
     */
    public double getPhi() {
        return phi;
    }


    /** this method checks class invariant.
     * @methodtype assert
     */
    private void assertClassInvariants(){
        assertValidRadius(radius);
        assertValidTheta(theta);
        assertValidPhi(phi);
    }

    /**
     * check value of Radius
     * @methodtpye assertion
     */
    private void assertValidRadius(double radius) throws IllegalArgumentException{

        try{
            assertIsValidDouble(radius);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("radius is invalid");
        }
        if (radius < 0 ) {
            throw new IllegalArgumentException("value of radius is invalid. Radius must be greater or equal 0");
        }
    }
    /**
     * check value of Theta
     * @methodtpye assertion
     */
    private void assertValidTheta(double theta) throws IllegalArgumentException{

        try{
            assertIsValidDouble(theta);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("theta is invalid");
        }

        if (theta < 0 || theta > Math.PI) {
            throw new IllegalArgumentException("value of theta is invalid. Theta must be in range [0, PI]");
        }
    }
    /**
     * check value of Phi
     * @methodtpye assertion
     */
    private void assertValidPhi(double phi) throws IllegalArgumentException{
        try{
            assertIsValidDouble(phi);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("phi is invalid");
        }
        if (phi < 0 || phi >= 2 * Math.PI) {
            throw new IllegalArgumentException("value of phi is invalid. Phi must be in range [0, 2*PI]");
        }
    }
}
