/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ACER
 */
public class ItemDTO {
    private int ItemID;
    private String ItemName;
    private int Price;
    private int CateID; 
    private String CateName;
    private int status;

    public ItemDTO() {
    }

    public ItemDTO(int ItemID, String ItemName, int Price, int CateID, String CateName, int status) {
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.Price = Price;
        this.CateID = CateID;
        this.CateName = CateName;
        this.status = status;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int ItemID) {
        this.ItemID = ItemID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getCateID() {
        return CateID;
    }

    public void setCateID(int CateID) {
        this.CateID = CateID;
    }

    public String getCateName() {
        return CateName;
    }

    public void setCateName(String CateName) {
        this.CateName = CateName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
    
}
