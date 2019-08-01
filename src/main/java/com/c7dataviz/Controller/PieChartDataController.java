package com.c7dataviz.Controller;

import com.c7dataviz.Model.PieChart;
import com.c7dataviz.Model.SuperHero;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class PieChartDataController {


    public ArrayList<PieChart> generatePieChartData(String attribute, ArrayList<SuperHero> superheroes) throws NoSuchFieldException, IllegalAccessException {

        int i = 0;

        HashMap<String,PieChart> pieChartHashMap = new HashMap<String, PieChart>();
        for(SuperHero s : superheroes){
            Field field = s.getClass().getDeclaredField(attribute);
            String attr = field.get(s).toString();
            if(pieChartHashMap.containsKey(attr)){
                pieChartHashMap.get(attr).addQuantity();
            }else{
                PieChart pC = new PieChart(0.9,attr,"",attribute+"_"+i);
                pieChartHashMap.put(attr,pC);
            }
            i++;
        }
        Collection<PieChart> values = pieChartHashMap.values();
        ArrayList<PieChart> pieCharts = new ArrayList<>(values);

        return pieCharts;
    }

}
