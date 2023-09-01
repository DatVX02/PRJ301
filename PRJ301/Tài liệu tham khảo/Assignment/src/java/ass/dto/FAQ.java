/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.dto;

public class FAQ {

    String Id;
    String CustName;
    String CustContent;
    String ItemId;

    public FAQ(String Id, String CustName, String CustContent, String ItemId) {
        this.Id = Id;
        this.CustName = CustName;
        this.CustContent = CustContent;
        this.ItemId = ItemId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String CustName) {
        this.CustName = CustName;
    }

    public String getCustContent() {
        return CustContent;
    }

    public void setCustContent(String CustContent) {
        this.CustContent = CustContent;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String ItemId) {
        this.ItemId = ItemId;
    }

    @Override
    public String toString() {
        return "FAQ{" + "Id=" + Id + ", CustName=" + CustName + ", CustContent=" + CustContent + ", ItemId=" + ItemId + '}';
    }

}
