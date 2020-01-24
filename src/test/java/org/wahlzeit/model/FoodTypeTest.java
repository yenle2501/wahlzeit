package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FoodTypeTest {


    private FoodType soup;
    private FoodType pho;  // subtype of soup
    private FoodType phobo; //subtype of pho

    @Before
    public void setup() {

        soup = new FoodType("soup");
        pho = new FoodType("pho");
        phobo = new FoodType("phobo");

    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetParentTypeWithNullValue() {
        phobo.setParentFoodType(null);
    }

    @Test
    public void testSetParentType() {
        phobo.setParentFoodType(pho);
        pho.setParentFoodType(soup);

        assertEquals(phobo.getParent_foodtype().getFoodType(), pho.getFoodType());
        assertEquals(pho.getParent_foodtype().getFoodType(),soup.getFoodType());
    }

    @Test
    public void testGetParentType() {
        phobo.setParentFoodType(pho);
        pho.setParentFoodType(soup);

        assertEquals(phobo.getParent_foodtype(), pho);
        assertEquals(pho.getParent_foodtype(),soup);
    }

    @Test
    public void testIsSubType() {
        phobo.setParentFoodType(pho);
        pho.setParentFoodType(soup);

        assertTrue(phobo.isSubtype(pho));
        assertTrue(pho.isSubtype(soup));

    }

    @Test
    public void testCreateInstance() {
        Food phobogan = pho.createInstance("phobogan");

        assertEquals(pho, phobogan.getType());
        assertEquals("phobogan", phobogan.getDishname());

    }

    @Test
    public void testGetFoodType() {
        assertEquals("pho", pho.getFoodType());
        assertEquals("soup", soup.getFoodType());
    }
}