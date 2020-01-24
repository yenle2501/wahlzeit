package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.PatternInstance;

import java.util.logging.Logger;

@PatternInstance(
        patternName = "Abstract Factory",
        participants = {"AbstractFactory", "ConcreteFactory"}
)

/**
 * An FoodPhotoFactory for creating photos and related objects.
 */
public class FoodPhotoFactory  extends PhotoFactory{
    /**
     * Hidden singleton instance; needs to be initialized from the outside
     */
    private static FoodPhotoFactory instance;
    private static final Logger log = Logger.getLogger(PhotoFactory.class.getName());

    /** @methodtype constructor
     * */
    protected FoodPhotoFactory(){
        super();
    }

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize(){
        getInstance();
    }
    /**
     * Public singleton access method
     * @methodtype get
     * @methodproperties primitive
     */
    public static synchronized  FoodPhotoFactory getInstance(){
        if(instance == null){
            log.config(LogBuilder.createSystemMessage().addAction("setting generic FoodPhotoFactory").toString());
            setInstance(new FoodPhotoFactory());
        }
        return instance;
    }

    /**
     * Method to set the singleton instance of PhotoFactory.
     *
     */
    protected static synchronized void setInstance(FoodPhotoFactory foodphotoFactory) throws IllegalStateException{
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize FoodPhotoFactory twice");
        }

        instance = foodphotoFactory;
    }

    /**
     * @methodtype factory
     */
    @Override
    public FoodPhoto createPhoto(){
        return new FoodPhoto();
    }

    /**
     * Creates a new photo with the specified id
     * @methodtype factory
     */
    @Override
    public FoodPhoto createPhoto(PhotoId id) throws IllegalArgumentException{
        if(id == null){
            throw new IllegalArgumentException("Photo Id should not be null");
        }
        return new FoodPhoto(id);
    }

}
