package org.wahlzeit.model;

/**
 * This class represents the spherical coordinate system
 * Source: https://en.wikipedia.org/wiki/Spherical_coordinate_system
 */
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
            throw new IllegalArgumentException("phi is invalid");
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
            throw new IllegalArgumentException("phi is invalid");
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

    /** this method converts a coordinate to a Cartesian Coordinate
     * @methodtype conversion
     * @return a Cartesian Coordinate
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {

        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);

        CartesianCoordinate cartesianCoordinate =  new CartesianCoordinate(x, y, z);

        return cartesianCoordinate;
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
        assertIsNotNull(coordinate,"The given Coordinate" );

        SphericCoordinate sphericCoordinate= coordinate.asSphericCoordinate();

        return isDoubleEqual(sphericCoordinate.radius, radius)
                && isDoubleEqual(sphericCoordinate.theta, theta)
                && isDoubleEqual(sphericCoordinate.phi, phi);
    }

    /** compare two double values
     * @methodtype boolean query
     * @param value1 first value
     *        value2 second value
     * @return true: if different between two values is lower than threshold
     *         false: otherwise
     */
    private boolean isDoubleEqual(double value1, double value2) throws IllegalArgumentException{
        assertIsValidDouble(value1);
        assertIsValidDouble(value2);

        if(Math.abs(value1 - value2) <= THRESHOLD){
            return true;
        }
        return false;
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
}
