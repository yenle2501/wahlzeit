
package org.wahlzeit.model;
import java.util.HashMap;
import java.util.Map;

public class FoodManager{

    private   static FoodManager foodManager_instance = new FoodManager();

    private   Map<String, FoodType> foodTypes ;
    private   Map<String, Food> foods ;


    public FoodManager(){
        foodTypes = new HashMap<String, FoodType>();
        foods = new HashMap<String, Food>();
    }


    public static FoodManager getInstance(){
        return foodManager_instance;
    }


    public Food createFood(FoodType foodType, String dishname){
        if(foodType == null) {
            throw new IllegalArgumentException("foodType should not be null");
        }
        if(dishname == null) {
            throw new IllegalArgumentException("dishname should not be null");
        }
        Food newFood = new Food(foodType, dishname);
        foods.put(dishname, newFood);
        return newFood;
    }


    /**
     * @methodtype boolean-query
     */
    public boolean hasFoodType(String foodType) {
        if (foodType == null) {
            throw new IllegalArgumentException("given foodType must not be null.");
        }
        return foodTypes.containsKey(foodType);
    }


    public void addFoodType(String foodType) {
        if (foodType == null) {
            throw new IllegalArgumentException(" given foodType must not be null.");
        }
        if (foodTypes.containsKey(foodType)) {
            throw new IllegalArgumentException(" given foodType exists already");
        }

        FoodType newfoodtype = new FoodType(foodType);
        foodTypes.put(foodType, newfoodtype);
    }

    public FoodType getFoodType(String key) {
        if (key == null) {
            throw new IllegalArgumentException("The given foodType must not be null.");
        }
        if (!foodTypes.containsKey(key)) {
            throw new IllegalArgumentException(" given foodType does not exists");
        }
        return foodTypes.get(key);
    }

    public void addFood(Food dishname) {
        if (dishname == null) {
            throw new IllegalArgumentException("The given dishname must not be null.");
        }
        if (foods.containsKey(dishname)) {
            throw new IllegalArgumentException(" given dishname exists");
        }
        else {
            foods.put(dishname.getDishname(), dishname);
        }
    }

    /**
     * @methodtype boolean-query
     */
    public boolean hasFood(String dishname) {
        if (dishname == null) {
            throw new IllegalArgumentException("given dishname must not be null.");
        }
        return foods.containsKey(dishname);
    }

    public Food getFood(String dishname) {
        if (dishname == null) {
            throw new IllegalArgumentException("The given dishname must not be null.");
        }
        if (!foods.containsKey(dishname)) {
            throw new IllegalArgumentException(" given dishname does not exists");
        }
        return foods.get(dishname);
    }
}