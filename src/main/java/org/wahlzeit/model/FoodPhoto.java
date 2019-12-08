package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;
/**
 * A food photo represents a user-provided (uploaded) photo.
 */
@Entity
public class FoodPhoto extends Photo {

    private String dishname;
    /**
     * @methodtype constructor
     * */
    public FoodPhoto(){
        super();
    }
    /**
     * @methodtype constructor
     *
     * */
    public FoodPhoto(String dishname){
        super();
        this.dishname = dishname;
    }

    /**
     * @methodtype constructor
     * */
    public FoodPhoto(PhotoId myId){

        super(myId);
    }

    /**
     * @methodtype constructor
     * */
    public FoodPhoto(PhotoId myId, String dishname){
        super(myId);
        this.dishname = dishname;
    }

    /**
     * method to get name of dish
     * @return dishname
     * @methodtype get
     * @methodproperties primitive
     * */
    public String getDishname(){
        return dishname;
    }

    /**
     * method to set name for a dish
     * @methodtype set
     *
     * */
    public void setDishname(String dishname) {
        this.dishname = dishname;
    }
}
