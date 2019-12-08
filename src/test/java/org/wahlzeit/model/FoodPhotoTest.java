package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

/** Testcases for class FoodPhoto
 * */
public class FoodPhotoTest {

    private FoodPhoto foodPhoto1;
    private FoodPhoto foodPhoto2;

    @Before
    public void setUp(){
         foodPhoto1 = new FoodPhoto("pho");
         foodPhoto2 = new FoodPhoto("spicy_beef_noodle");
    }

    /** testcase for method getdishname()
     * */
    @Test
    public void testGetDishname(){

        assertEquals(foodPhoto1.getDishname(),"pho");
        assertEquals(foodPhoto2.getDishname(),"spicy_beef_noodle");
    }

    /** testcase for method setdishname()
     * */
    @Test
    public void testSetDishname(){
        foodPhoto1.setDishname("beef_pho");
        assertEquals(foodPhoto1.getDishname(),"beef_pho");
    }

    /** testcase for method setdishname() with null value of dishname
     * */
    @Test(expected = IllegalArgumentException.class)
    public void testSetNullDishname(){
        foodPhoto1.setDishname(null);
    }

}

