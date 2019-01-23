package com.dt.demo14;

/**
 * Created by robin on 19/1/22.
 */
public class Vertex {

    private String value; // 值
    private boolean isVisit; // 是否被访问过

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Vertex(String value) {
        this.value = value;
    }

    public boolean isVisit() {
        return isVisit;
    }

    public void setVisit(boolean visit) {
        isVisit = visit;
    }

    @Override
    public String toString() {
        return value;
    }

}
