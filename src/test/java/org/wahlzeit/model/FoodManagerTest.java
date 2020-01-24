package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodManagerTest{

    private FoodManager manager;
    private FoodType pho;  // subtype of soup
    private FoodType phobo; //subtype of pho

    private Food phobotai;
    @Before
    public void setup() {

        manager = new FoodManager();
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
    public void testCreateFood(){
        manager.createFood(pho, "phobotai");
        assertEquals(manager.getFood("phobotai").getDishname(),phobotai.getDishname());
    }

    @Test
    public void testGetPho(){
        manager.addFood(phobotai);

        assertEquals(phobotai, manager.getFood("phobotai"));
    }

    @Test
    public void testHasFood(){
        manager.addFood(phobotai);

        assertTrue(manager.hasFood("phobotai"));
        assertFalse(manager.hasFood("pho"));
    }
}