package org.wahlzeit.model;
/**
 * This class represents the cartesian coordinate system
 */
public class CartesianCoordinate extends  AbstractCoordinate {

    //x,y,z represent point x, y and z in the x-axis, y-axis and z-axis
    private  double x;
    private  double y;
    private  double z;

    /**
     * two double values are assumed equal if it's different is lower than this THRESHOLD
     */
    private static final double THRESHOLD =  0.00000000001;

    // constructor
    public CartesianCoordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariants();
    }

    /** this method checks class invariant.
     * @methodtype assert
     */
    private void assertClassInvariants(){
        assertValidX(x);
        assertValidY(y);
        assertValidZ(z);
    }
    /**
     * check value of x
     * @methodtpye assertion
     */
    private  void assertValidX(double x){
        if(Double.isNaN(x)){
            throw new IllegalArgumentException("x-coordinate is invalid. x must be a number");
        }
    }
    /**
     * check value of y
     * @methodtpye assertion
     */
    private  void assertValidY(double y){
        if(Double.isNaN(y)){
            throw new IllegalArgumentException("x-coordinate is invalid. x must be a number");
        }
    }
    /**
     * check value of z
     * @methodtpye assertion
     */
    private  void  assertValidZ(double z){
        if(Double.isNaN(z)){
            throw new IllegalArgumentException("x-coordinate is invalid. x must be a number");
        }
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
    public double getCartesianDistance(Coordinate given_coord) {
      if(given_coord == null){
          throw new NullPointerException("the given coordinate must not be null");
      }
      CartesianCoordinate cartesianCoordinate = given_coord.asCartesianCoordinate();

      double power_distance = Math.pow(cartesianCoordinate.x - this.x,2) + Math.pow(cartesianCoordinate.y - this.y,2) + Math.pow(cartesianCoordinate.z - this.z,2);
      double distance = Math.sqrt(power_distance);

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
        double r = Math.sqrt(power);
        double theta = (r > 0.0) ? Math.acos(this.z/r) : 0.0;
        double phi = (x != 0) ?  Math.atan2(this.y, this.x) :  0.0;
        return new SphericCoordinate(r,theta,phi);
    }


    /**
     * compare this coordinate and the given coordinate
     * @methodtype boolean query
     * @param coordinate the given coordinate
     * @return true : if coordinates are equalTheta
     *         false: otherwise
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
        if (coordinate == null) {
            return false;
        }
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        if(cartesianCoordinate == null){
              return false;
        }
        if(cartesianCoordinate.x - this.x < THRESHOLD && cartesianCoordinate.y - this.y < THRESHOLD && cartesianCoordinate.z - this.z < THRESHOLD){
                return true;
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


}
