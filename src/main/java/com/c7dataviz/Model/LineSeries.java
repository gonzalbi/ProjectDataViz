package com.c7dataviz.Model;

public class LineSeries {
    public float x;
    public float y;

    public AreaSeries(String x, float y) {
        this.x = Float.parseFloat(x);
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void addQuantity(){
        this.y++;
    }
}
