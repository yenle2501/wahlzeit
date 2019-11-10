package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testclass for Class FoodPhotoFactory
 */

public class FoodPhotoFactoryTest {


    @Before
    public void setUp(){
        FoodPhotoFactory.initialize();
    }

    /** Testcase for method getInstance()
     * */
    @Test
    public void testGetInstance(){
        PhotoFactory foodPhotoFactory1 = FoodPhotoFactory.getInstance();
        PhotoFactory foodPhotoFactory2 = FoodPhotoFactory.getInstance();

        assertNotNull(foodPhotoFactory1);
        assertNotNull(foodPhotoFactory2);
        assertEquals(foodPhotoFactory1,foodPhotoFactory2);
    }

    /**
     * Testcase for method setInstance
     * */
    @Test(expected = IllegalStateException.class)
    public void testSetInstanceWithException(){
        FoodPhotoFactory foodPhotoFactory =  new FoodPhotoFactory();
        PhotoFactory.setInstance(foodPhotoFactory);
    }

    /**
     *  Testcase for method createPhoto without PhotoId
     * */
    @Test
    public void testCreatePhoto(){
        FoodPhoto foodphoto = FoodPhotoFactory.getInstance().createPhoto();
        assertNotNull(foodphoto);
        assertEquals(FoodPhoto.class, foodphoto.getClass());
    }

    /**
     *  Testcase for method createPhoto with PhotoId
     * */
    @Test
    public void testCreatePhotoId(){

        PhotoId photoId =  new PhotoId(1);
        FoodPhoto foodphoto = FoodPhotoFactory.getInstance().createPhoto(photoId);
        assertNotNull(foodphoto);
        assertEquals(foodphoto.getId(),photoId);
    }

}
