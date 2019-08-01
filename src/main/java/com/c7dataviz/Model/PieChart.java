package com.c7dataviz.Model;

public class PieChart {

    private double innerRadius;
    private int angle;
    private String label;
    private String subLabel;
    private int quantity;
    private String className;
    public PieChart(double innerRadius,String label, String subLabel, String className) {
        this.innerRadius = innerRadius;
        this.angle = 0;
        this.label = label;
        this.subLabel = subLabel;
        this.quantity = 0;
        this.className = className;
    }

    public void addQuantity(){
        this.quantity++;
        this.angle++;
    }

}
