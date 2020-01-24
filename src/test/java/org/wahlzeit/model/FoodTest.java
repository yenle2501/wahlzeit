package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FoodTest{

    private FoodType foodType;
    private Food food;

    @Before
    public void setup() {
        foodType = new FoodType("soup");
        food = new Food(foodType, "Pho");
    }

    @Test
    public void testGetType() {
        String type_name = "soup";
        assertEquals(food.getType().getFoodType(), type_name);
    }

    @Test
    public void testGetDishname() {
        assertEquals(food.getDishname(), "Pho");
    }

    @Test
    public void testSetDishname() {
        food.setDishname("photai");
        assertEquals(food.getDishname(), "photai");
    }

    @Test
    public void testSetFoodType() {
        FoodType udon = new FoodType("udon");
        food.setFoodType(udon);
        assertEquals(food.getType().getFoodType(), udon.getFoodType());
    }

}