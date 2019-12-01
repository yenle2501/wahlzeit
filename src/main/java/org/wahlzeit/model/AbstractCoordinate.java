package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {


    /**
     * @methodtype get
     * @param coordinate the given coordinate
     * @return distance between this coordinate and the given cartesian coordinate
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {

        CartesianCoordinate cartesianCoordinate = this.asCartesianCoordinate();
        double result = cartesianCoordinate.getCartesianDistance(coordinate);
        assert result >= 0;
        return result;
    }

    /**
     * @methodtype get
     * @param coordinate a Coordinate
     * @return central angle between this Coordinate and the given Coordinate
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        SphericCoordinate sphericCoordinate = asSphericCoordinate();
        double result = sphericCoordinate.getCentralAngle(coordinate);
        assert result >= 0;
        return result;
    }

    /** compare this coordinate and the given object
     * @methodtype boolean query
     * @param obj the given object
     * @return true : if the coordinate and the given object are equal
     *         false: otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if (obj instanceof CartesianCoordinate) {
            return isEqual((CartesianCoordinate) obj);
        }
        if (obj instanceof SphericCoordinate) {
            return isEqual((SphericCoordinate) obj);
        }
        return false;
    }

}
