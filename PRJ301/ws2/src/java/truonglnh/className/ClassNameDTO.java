/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truonglnh.className;

import java.io.Serializable;

/**
 *
 * @author lnhtr
 */
public class ClassNameDTO implements Serializable{
    private String className;

    public ClassNameDTO(String className) {
        this.className = className;
    }

    public ClassNameDTO() {
    }
    
    

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }
    
    
}
