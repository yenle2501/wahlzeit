
package org.wahlzeit.model;

public class FoodType  {
    public FoodManager manager = FoodManager.getInstance();

    private String foodtype;
    private FoodType parent_foodtype = null;

    public FoodType(String foodtype){
        this.foodtype = foodtype;
    }


    public Food createInstance(String dishname){
        return new Food(this, dishname);
    }

    public String getFoodType(){
        return foodtype;
    }

    public FoodType getParent_foodtype(){
        return parent_foodtype;
    }

    public boolean isSubtype (FoodType foodtype){
        if (foodtype == null) {
            throw new IllegalArgumentException("foodtype is invalid");
        }
        if (parent_foodtype == foodtype) {
            return true;
        }
        return false;
    }

    public void setParentFoodType(FoodType foodtype){
        parent_foodtype = foodtype;
    }
}