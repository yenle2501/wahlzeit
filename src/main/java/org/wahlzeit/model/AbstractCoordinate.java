package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
        patternName = "Template",
        participants = {"AbstractCoordinate", "Coordinate"}
)
public abstract class AbstractCoordinate implements Coordinate {


    /**
     * @methodtype assertion
     * @param object object to check
     * @param argument as comment
     * @throws IllegalArgumentException  if object is null
     */
    protected void assertIsNotNull(Object object, String argument){
        if(object==null) {
            throw new IllegalArgumentException(argument + " must not be null");
        }
    }


    /**
     * @methodtype get
     * @param coordinate the given coordinate
     * @return distance between this coordinate and the given cartesian coordinate
     * @throws IllegalArgumentException in case coord is null
     */
    @Override
    public  double getCartesianDistance(Coordinate coordinate) throws IllegalArgumentException {
        assertIsNotNull(coordinate,"The given coordinate" );
        CartesianCoordinate cartesianCoordinate = this.asCartesianCoordinate();

        double result = cartesianCoordinate.getCartesianDistance(coordinate);
        assert result >= 0;
        return result;
    }

    /**
     * @methodtype get
     * @param coordinate a Coordinate
     * @return central angle between this Coordinate and the given Coordinate
     * @throws IllegalArgumentException in case coord is null
     */
    @Override
    public double getCentralAngle (Coordinate coordinate)  throws  IllegalArgumentException{
        assertIsNotNull(coordinate,"The given coordinate");
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
    public boolean equals(Object obj){
            return this == obj;
    }

}
