
package org.wahlzeit.model;
import java.util.HashMap;
import java.util.Map;

/**==============================================================================================================
 * - Manager-element-collaboration: Binds the manager role in collaboration of {@link FoodManager} (manager) and {@link Food} (element).
 * ==============================================================================================================
 * */

public class FoodManager{

    private   static FoodManager foodManager_instance = new FoodManager();

    private   Map<String, FoodType> foodTypes ;
    private   Map<String, Food> foods ;

    /**
     * @methodtype constructor
     */
    public FoodManager(){
        foodTypes = new HashMap<String, FoodType>();
        foods = new HashMap<String, Food>();
    }


    public static FoodManager getInstance(){
        return foodManager_instance;
    }

    /**
     * @methodtype factory
     */
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

    /**
     * @methodtype set
     */
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

    /**
     * @methodtype get
     */
    public FoodType getFoodType(String key) {
        if (key == null) {
            throw new IllegalArgumentException("The given foodType must not be null.");
        }
        if (!foodTypes.containsKey(key)) {
            throw new IllegalArgumentException(" given foodType does not exists");
        }
        return foodTypes.get(key);
    }

    /**
     * @methodtype set
     */
    public void addFood(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("The given food must not be null.");
        }
        if (foods.containsKey(food)) {
            throw new IllegalArgumentException(" given food exists");
        }
        else {
            foods.put(food.getDishname(), food);
        }
    }

    /**
     * @methodtype boolean-query
     */
    public boolean hasFood(String food) {
        if (food == null) {
            throw new IllegalArgumentException("given food must not be null.");
        }
        return foods.containsKey(food);
    }

    /**
     * @methodtype get
     */
    public Food getFood(String food) {
        if (food == null) {
            throw new IllegalArgumentException("The given food must not be null.");
        }
        if (!foods.containsKey(food)) {
            throw new IllegalArgumentException(" given food does not exists");
        }
        return foods.get(food);
    }
}