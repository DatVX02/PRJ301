/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.food;

/**
 *
 * @author Hoa Doan
 */
public class FoodDTO {
   private String id;
   private String name;
   private String description;
   private int price;
   private int cookingtime;
   private boolean status;

    public FoodDTO(String id, String name, String description, int price, int cookingtime, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.cookingtime = cookingtime;
        this.status = status;
    }

    public FoodDTO() {
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCookingtime() {
        return cookingtime;
    }

    public void setCookingtime(int cookingtime) {
        this.cookingtime = cookingtime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   
    
}
