/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truonglnh.inventory;

import java.io.Serializable;

/**
 *
 * @author lnhtr
 */
public class InventoryDTO implements Serializable{
    private String ID;
    private String name;
    private int quantity;

    public InventoryDTO() {
    }

    public InventoryDTO(String ID, String name, int quantity) {
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
    }

    
    
    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
