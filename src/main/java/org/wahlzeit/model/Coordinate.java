package org.wahlzeit.model;

/**
 * This class represents the cartesian coordinate system
 */
public class Coordinate {

    //x,y,z represent point x, y and z in the x-axis, y-axis and z-axis
    private  double x;
    private  double y;
    private  double z;


    // constructor
    public Coordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * get Distance of this coordinate to a given coordinate
     * @param given_coord the given coordinate
     * @return distance between this coordinate and the given coordinate
    */
    public double getDistance(Coordinate given_coord){
        if(given_coord == null){
            throw new NullPointerException("the given coordinate must not be null");
        }
        double power_distance = Math.pow(given_coord.x - this.x,2) + Math.pow(given_coord.y - this.y,2) + Math.pow(given_coord.z - this.z,2);
        double distance = Math.sqrt(power_distance);

        return distance;
    }

    /**
     * compare this coordinate and the given coordinate
     * @param given_coord the given coordinate
     * @return true : if coordinates are equal
     *         false: otherwise
     */
    public boolean isEqual(Coordinate given_coord){
        if(given_coord == null){
            throw new NullPointerException("the given coordinate must not be null");
        }
        if(given_coord.x == this.x && given_coord.y == this.y && given_coord.z == this.z){
            return true;
        }
        return false;
    }

    /** compare this coordinate and the given object
     * @param obj the given object
     * @return true : if the coordinate and the given object are equal
     *         false: otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coordinate) {
            return isEqual((Coordinate) obj);
        }
        return false;
    }

    /** get x of the coordinate
     * @return x
     */
    public double getX(){
        return x;
    }

    /** get y of the coordinate
     * @return y
     */
    public double getY(){
        return y;
    }

    /** get z of the coordinate
     * @return z
     */
    public double getZ(){
        return z;
    }

}
