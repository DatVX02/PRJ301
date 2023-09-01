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
public class CategoriesDTO {
   private int CateID;
   private String CateName;
   private int Status;

    public CategoriesDTO() {
    }

    public CategoriesDTO(int CateID, String CateName, int Status) {
        this.CateID = CateID;
        this.CateName = CateName;
        this.Status = Status;
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
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
}
