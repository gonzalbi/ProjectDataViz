package com.c7dataviz.Model;

public class BarChart {

    private String x;
    private int y;

    public BarChart(String x, int y) {
        this.x = x;
        if(y > 0){
            this.y = 0;
        }else{
            this.y = y;
        }
    }

    public void addQuantity(int val){
        if(val > 1){
            this.y += val;
        }else{
            this.y++;
        }
    }

    public int getY(){
        return this.y;
    }
}
