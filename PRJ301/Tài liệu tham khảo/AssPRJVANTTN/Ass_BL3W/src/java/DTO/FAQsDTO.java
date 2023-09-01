/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DELL
 */
public class FAQsDTO {
    private int Id;
    private String custName;
    private String custContent;
    private String ItemsName;

    public FAQsDTO() {
    }

    public FAQsDTO(int Id, String custName, String custContent, String ItemsName) {
        this.Id = Id;
        this.custName = custName;
        this.custContent = custContent;
        this.ItemsName = ItemsName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustContent() {
        return custContent;
    }

    public void setCustContent(String custContent) {
        this.custContent = custContent;
    }

    public String getItemsName() {
        return ItemsName;
    }

    public void setItemsName(String ItemsName) {
        this.ItemsName = ItemsName;
    }
    

    
    
}
