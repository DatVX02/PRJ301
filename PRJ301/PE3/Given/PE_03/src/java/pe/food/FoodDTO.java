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
    private String foodID;
    private String name;
    private String descrip;
    private String price;
    private String time;
    private String status;

    public FoodDTO() {
    }

    public FoodDTO(String foodID, String name, String descrip, String price, String time, String status) {
        this.foodID = foodID;
        this.name = name;
        this.descrip = descrip;
        this.price = price;
        this.time = time;
        this.status = status;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FoodDTO{" + "foodID=" + foodID + ", name=" + name + ", descrip=" + descrip + ", price=" + price + ", time=" + time + ", status=" + status + '}';
    }
    
    
    
}
