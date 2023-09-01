/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.food;

/**
 *
 * @author ACER
 */
public class BookDTO {

    private String id;
    private String name;
    private String description;
    private int price;
    private boolean status;

    public BookDTO(String id, String name, String description, int price, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public BookDTO() {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
