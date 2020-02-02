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

/**==============================================================================================================
 * -Client-service-collaboration: Binds the service role in collaboration of {@link FoodPhoto} (client) and {@link Food} (service).
 * -Base-object-Type-object-collaboration:  Binds the base-object role in collaboration of {@link  FoodType}(type-object) and {@link Food} (base-object).
 * -Manager-Element-collaboration: Binds the element role in collaboration of {@link FoodManager} (manager) and {@link Food} (element).
 *==============================================================================================================
 */
import org.wahlzeit.utils.StringUtil;

public class Food{

    public FoodManager manager = FoodManager.getInstance();

    private FoodType foodtype;
    private String dishname;

    /**
     * @methodtype constructor
     */
    public Food(FoodType foodtype, String dishname){

        assertFoodTypeValid(foodtype);
        assertDishnameValid(dishname);
        this.foodtype = foodtype;
        this.dishname = dishname;
    }

    /**
     * @methodtype get
     */
    public FoodType getType(){
        return foodtype;
    }

    /**
     * @methodtype set
     */
    public void setFoodType(FoodType foodtype){
        assertFoodTypeValid(foodtype);
        this.foodtype = foodtype;
    }

    /**
     * @methodtype get
     */
    public String getDishname(){
        return dishname;
    }

    /**
     * @methodtype set
     */
    public void setDishname(String dishname){
        assertDishnameValid( dishname);
        this.dishname = dishname;
    }

    /**
     * @methodtype assert
     */
    private void assertDishnameValid(String dishname) {
        if (StringUtil.isNullOrEmptyString(dishname)) {
            throw new IllegalArgumentException("dishname must be not empty.");
        }
    }

    /**
     * @methodtype assert
     */
    private void assertFoodTypeValid(FoodType foodtype) {
        if (foodtype == null) {
            throw new IllegalArgumentException("foodtype must be not null.");
        }
    }

}