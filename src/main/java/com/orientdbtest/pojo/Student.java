 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orientdbtest.pojo;

import com.orientechnologies.orient.core.id.ORID;

/**
 *
 * @author tobah
 */
public class Student {
    
    private String rid;
    private String name;
    private String surname;

    public Student() {
        
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
    
}
