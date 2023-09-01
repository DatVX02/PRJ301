/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.dto;

public class Categorie {

    String CateId;
    String CateName;
    int status;

    public Categorie(String CateId, String CateName, int status) {
        this.CateId = CateId;
        this.CateName = CateName;
        this.status = status;
    }

    public String getCateId() {
        return CateId;
    }

    public void setCateId(String CateId) {
        this.CateId = CateId;
    }

    public String getCateName() {
        return CateName;
    }

    public void setCateName(String CateName) {
        this.CateName = CateName;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Categorie{" + "CateId=" + CateId + ", CateName=" + CateName + ", status=" + status + '}';
    }

}
