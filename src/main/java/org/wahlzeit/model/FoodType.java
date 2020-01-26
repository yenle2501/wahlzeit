
package org.wahlzeit.model;

import org.wahlzeit.utils.StringUtil;

public class FoodType  {
    public FoodManager manager = FoodManager.getInstance();

    private String foodtype;
    private FoodType parent_foodtype = null;

    /**
     * @methodtype constructor
     */
    public FoodType(String foodtype){

        assertNameValid(foodtype);
        this.foodtype = foodtype;
    }

    /**
     * @methodtype factory
     */
    public Food createInstance(String dishname){
        assertNameValid(dishname);
        return new Food(this, dishname);
    }
    /**
     * @methodtype get
     */
    public String getFoodType(){
        return foodtype;
    }

    /**
     * @methodtype get
     */
    public FoodType getParent_foodtype(){
        return parent_foodtype;
    }

    /**
     * @methodtype get
     */
    public boolean isSubtype (FoodType foodtype){
        if (foodtype == null) {
            throw new IllegalArgumentException("foodtype is invalid");
        }
        if (parent_foodtype == foodtype) {
            return true;
        }
        return false;
    }

    protected void setParentFoodType(FoodType foodtype){
        if(foodtype == null){
            throw new IllegalArgumentException("foodtype should not be null");
        }
        parent_foodtype = foodtype;
    }


    /**
     * @methodtype assert
     */
    private void assertNameValid(String name) {
        if (StringUtil.isNullOrEmptyString(name)) {
            throw new IllegalArgumentException("name must be not empty.");
        }
    }

}