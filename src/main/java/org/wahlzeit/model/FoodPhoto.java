package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import org.wahlzeit.utils.PatternInstance;

        /* ==============================================================================================================
        *  The sequence of method calls that lead to the new object:
        *      1. the method createPhoto(String filename, Image uploadedImage) is inherited from class PhotoManager
        *      2. the createPhoto method calls by using method createPhoto(filename, id, uploadedImage) in class PhotoUtil
        *      3. constructor of the super-class super(PhotoId myId) is called by the constructor
        *           FoodPhoto(PhotoId myId)
        *      4. new FoodPhoto is created in class FoodPhotoFactory by using method createPhoto(PhotoId id)
        *      5. the constructor new FoodPhoto(PhotoId myId, String dishname) is called to create a new FoodPhoto
        *      6. in class UploadPhotoFromHandler, the method doHandlePost(UserSession us, Map args) create new Photo by
        *       using access on  PhotoManager pm = PhotoManager.getInstance(); to createPhoto
        *       Photo photo = pm.createPhoto(fileName, uploadedImage);
         ______________________________________________________________________________________________________________
        * Object creation described in the solution space:
        *      1. Delegation of object creation
        *         - separate-object; created via FoodPhotoManager and -Factory
        *      2. Selection of concrete class
        *         - By-subclassing;  FoodPhotoFactory is subtype of PhotoFactory
        *      3. Configuration of class mapping
        *         - in code
        *      4. Instantiation of concrete class
        *         - In-code and constructor directly called via new
        *      5. Initialization of new Object
        *         - Default; by constructor arguments
        *      6. Building of object structure
        *         - Default;by building
        * ==============================================================================================================
        */

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
     * method to set name for a food
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