package org.wahlzeit.model;

/*=======================================================================================================================
 *  The sequence of method calls that lead to the new object:
 *      1. FoodManager accessed by using createFood method like  createFood(FoodType foodType, String dishname)
 *      2. new Food is created by using Food newFood = new Food(FoodType foodtype,String dishname)
 * _______________________________________________________________________________________________________________________
 * Object creation described in the solution space:
 *      1. Delegation of object creation
 *         - by delegating to a seperate-object;
 *      2. Selection of concrete class
 *         - On-the-spot;
 *      3. Configuration of class mapping
 *         - N/A
 *      4. Instantiation of concrete class
 *         - In-code; the constructor is called via new
 *      5. Initialization of new Object
 *         - Default; by constructor arguments
 *      6. Building of object structure
 *         - default
 * =======================================================================================================================
 */

public class Food{

    public FoodManager manager = FoodManager.getInstance();

    private FoodType foodtype;
    private String dishname;


    public Food(FoodType foodtype, String dishname){
        this.foodtype = foodtype;
        this.dishname = dishname;
    }


    public FoodType getType(){
        return foodtype;
    }

    public void setFoodType(FoodType foodtype){
        this.foodtype = foodtype;
    }

    public String getDishname(){
        return dishname;
    }
    public void setDishname(String dishname){
        this.dishname = dishname;
    }
}