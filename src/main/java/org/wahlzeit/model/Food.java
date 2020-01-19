package org.wahlzeit.model;

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

    public String getDishname(){
        return dishname;
    }
}