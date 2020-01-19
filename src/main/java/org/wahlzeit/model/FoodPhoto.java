package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.utils.PatternInstance;
/**
 * A food photo represents a user-provided (uploaded) photo.
 */
@PatternInstance(
        patternName = "Abstract Factory",
        participants = {"AbstractProduct", "ConcreteProduct"}
)

@Entity
public class FoodPhoto extends Photo {

    private Food food;

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
    public FoodPhoto(Food food){
        super();
        this.food = food;
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
    public FoodPhoto(PhotoId myId, Food food){
        super(myId);
        this.food = food;
    }

    /**
     * method to get food
     * @return food
     * @methodtype get
     * @methodproperties primitive
     * */
    public Food getFood(){
        return food;
    }

    /**
     * method to set name for a dish
     * @methodtype set
     *
     * */
    public void setFood(Food food) throws NullPointerException{
        if (food == null) {
            throw new NullPointerException("food must not be null");
        }
        this.food = food;
    }
}
