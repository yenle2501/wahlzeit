package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/** Testclass for class FoodPhotoManager
 * */
public class FoodPhotoManagerTest {

    private PhotoManager foodPhotoManager1;
    private PhotoManager foodPhotoManager2;

    @Before
    public void setUp(){
         foodPhotoManager1 = FoodPhotoManager.getInstance();
         foodPhotoManager2 = FoodPhotoManager.getInstance();
    }


    /** testcases for method getInstance()
     * */
    @Test
    public void testGetInstance(){
        assertNotNull(foodPhotoManager1);
        assertNotNull(foodPhotoManager2);
        assertEquals(foodPhotoManager1,foodPhotoManager2);

    }
}
