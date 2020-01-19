package org.wahlzeit.model;

import org.junit.Test;
import org.junit.Before;
import org.junit.*;
import static org.junit.Assert.*;


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

}