/**
 packageName    : com.company
 fileName       : DIsh
 author         : ipeac
 date           : 2023-01-19
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-19        ipeac       최초 생성 */
package com.company.ch5.ch1;

/**
 packageName    : com.company
 fileName       : DIsh
 author         : ipeac
 date           : 2023-01-19
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-19        ipeac       최초 생성 */
public class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;
    
    public Type getType() {
        return type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isVegetarian() {
        return vegetarian;
    }
    
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
    
    public int getCalories() {
        return calories;
    }
    
    public void setCalories(int calories) {
        this.calories = calories;
    }
    
    @Override
    public String toString() {
        return "Dish{" +
            "name='" + name + '\'' +
            ", vegetarian=" + vegetarian +
            ", calories=" + calories +
            ", type=" + type +
            '}';
    }
    
    public enum Type {
        MEAT, FISH, OTHER
    }
}
