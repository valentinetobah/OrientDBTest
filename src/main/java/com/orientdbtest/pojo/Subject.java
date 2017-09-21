/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orientdbtest.pojo;

/**
 *
 * @author tobah
 */
public class Subject {
    
    private String rid;
    private String title;
    private int percentageScore;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPercentageScore() {
        return percentageScore;
    }

    public void setPercentageScore(int percentageScore) {
        this.percentageScore = percentageScore;
    }

    
    
}
