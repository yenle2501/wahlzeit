package org.wahlzeit.model;

/**
 *  A class represents a location of a photo
 * */
public class Location {

    // the coordinate of loccation
    private Coordinate coord;


    // constructor
    public Location(Coordinate coord){
        if (coord == null) {
            throw new IllegalArgumentException("The given coordinate must not be null.");
        }
        this.coord = coord;
    }


    /**@methodtype get
     * @return the coordinate of Location
     * */
    public Coordinate getCoordinate(){
        return coord;
    }

    /**
     * @methodtype set
     * @param coordinate coordinate of location
     * */

    public void setCoordinate(Coordinate coord){
        if (coord == null) {
            throw new IllegalArgumentException("The given coordinate must not be null.");
        }
        this.coord = coord;
    }
}
