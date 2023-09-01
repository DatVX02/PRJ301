/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.dto;

public class Item {

    String ItemId;
    String ItemName;
    double Price;
    String CateId;

    public Item(String ItemId, String ItemName, double Price, String CateId) {
        this.ItemId = ItemId;
        this.ItemName = ItemName;
        this.Price = Price;
        this.CateId = CateId;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String ItemId) {
        this.ItemId = ItemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getCateId() {
        return CateId;
    }

    public void setCateId(String CateId) {
        this.CateId = CateId;
    }

    @Override
    public String toString() {
        return "Item{" + "ItemId=" + ItemId + ", ItemName=" + ItemName + ", Price=" + Price + ", CateId=" + CateId + '}';
    }

}
