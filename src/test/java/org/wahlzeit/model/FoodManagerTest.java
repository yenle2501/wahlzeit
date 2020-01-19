package org.wahlzeit.model;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;
import static org.junit.Assert.*;


public class FoodManagerTest{

    private FoodManager manager;
    private FoodType soup;
    private FoodType pho;  // subtype of soup
    private FoodType phobo; //subtype of pho

    private Food phobotai;
    @Before
    public void setup() {

        manager = new FoodManager();
        soup = new FoodType("soup");
        pho = new FoodType("pho");
        phobo = new FoodType("phobo");

        phobotai = new Food(pho,"phobotai");
    }


    @Test
    public void testGetFoodType(){
        manager.addFoodType("phobo");

        assertEquals(phobo.getFoodType(), manager.getFoodType("phobo").getFoodType());
    }

    @Test
    public void testHasFoodType(){
        manager.addFoodType("phobo");

        assertTrue(manager.hasFoodType("phobo"));
        assertFalse(manager.hasFoodType("pho"));
    }



    @Test
    public void testGetDishname(){
        manager.addDishname(phobotai);

        assertEquals(phobotai, manager.getDishname("phobotai"));
    }

    @Test
    public void testHasDishname(){
        manager.addDishname(phobotai);

        assertTrue(manager.hasDishname("phobotai"));
        assertFalse(manager.hasDishname("pho"));
    }
}