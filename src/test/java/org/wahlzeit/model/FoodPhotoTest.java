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

    private Food pho;
    private Food spicy_beef_pho;

    private FoodType photype;

    @Before
    public void setUp(){
        photype = new FoodType("photype");

        pho = new Food(photype,"pho");
        spicy_beef_pho = new Food(photype,"spicy_beef_pho");

        foodPhoto1 = new FoodPhoto(pho);
        foodPhoto2 = new FoodPhoto(spicy_beef_pho);


    }

    /** testcase for method getdishname()
     * */
    @Test
    public void testGetFood(){

        assertEquals(foodPhoto1.getFood(), pho);
        assertEquals(foodPhoto2.getFood(),spicy_beef_pho);
    }

    /** testcase for method setdishname()
     * */
    @Test
    public void testSetFood(){
        foodPhoto1.setFood(new Food(photype,"beef_pho"));
        assertEquals(foodPhoto1.getFood().getDishname(),"beef_pho");
    }
}
