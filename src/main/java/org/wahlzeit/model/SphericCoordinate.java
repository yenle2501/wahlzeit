package org.wahlzeit.model;
/**
 * This class represents the spherical coordinate system
 * Source: https://en.wikipedia.org/wiki/Spherical_coordinate_system
 */
public class SphericCoordinate implements Coordinate {
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
     *  @methodtype: constructor
    */
    public SphericCoordinate(double radius, double theta, double phi) {

        checkValidRadius(radius);
        checkValidTheta(theta);
        checkValidPhi(phi);

        this.radius = radius;
        this.theta = theta;
        this.phi = phi;
    }

    /**
     * check value of Radius
     * @methodtpye assertion
     */
    private void checkValidRadius(double radius){
        if (radius < 0 ) {
            throw new IllegalArgumentException("value of radius is invalid. Radius must be greater or equal 0");
        }
    }
    /**
     * check value of Theta
     * @methodtpye assertion
     */
    private void checkValidTheta(double theta){
        if (theta < 0 || theta > Math.PI) {
            throw new IllegalArgumentException("value of theta is invalid. Theta must be in range [0, PI]");
        }
    }
    /**
    * check value of Phi
     * @methodtpye assertion
    */
    private void checkValidPhi(double phi){
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
     * @methodtype get
     * @param coordinate the given coordinate
     * @return distance between this coordinate and the given cartesian coordinate
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {

        CartesianCoordinate cartesianCoordinate = this.asCartesianCoordinate();
        double result = cartesianCoordinate.getCartesianDistance(coordinate);
        return result;
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
    public double getCentralAngle(Coordinate given_coord) {
        if (given_coord == null) {
            throw new NullPointerException("the given given_coord must not be null");
        }

        SphericCoordinate sphericCoordinate = given_coord.asSphericCoordinate();
        if (sphericCoordinate == null) {
            throw new NullPointerException("the spherical Coordinate must not be null");
        }
        double deltaPhi = Math.abs(phi - sphericCoordinate.phi);
        double acosParam = Math.sin(theta) * Math.sin(sphericCoordinate.theta)
                + Math.cos(theta) * Math.cos(sphericCoordinate.theta) * Math.cos(deltaPhi);

        return Math.acos(acosParam);

    }
    /**
     * compare this coordinate and the given coordinate
     * @methodtype boolean query
     * @param coordinate the given coordinate
     * @return true : if coordinates are equal
     *         false: otherwise
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
        if (coordinate == null) {
            return false;
        }
        SphericCoordinate sphericCoordinate= coordinate.asSphericCoordinate();
        if (sphericCoordinate == null) {
            return false;
        }
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
    private boolean isDoubleEqual(double value1, double value2){
        if(Math.abs(value1 - value2) <= THRESHOLD){
            return true;
        }
        return false;
    }

    /**
     * @methodtype boolean query
     *
    * */
    @Override
    public boolean equals(Object object) {
        if(object == this){
            return true;
        }
        if (object instanceof SphericCoordinate) {
            return isEqual((SphericCoordinate) object);
        }

        return false;
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
