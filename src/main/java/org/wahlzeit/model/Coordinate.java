package org.wahlzeit.model;

public interface Coordinate{

    public CartesianCoordinate asCartesianCoordinate();

    public double getCartesianDistance(Coordinate coordinate)  throws IllegalArgumentException ;

    public SphericCoordinate asSphericCoordinate();

    public double getCentralAngle(Coordinate coordinate ) throws IllegalArgumentException ;

    public boolean isEqual(Coordinate coordinate) throws IllegalArgumentException ;
}
