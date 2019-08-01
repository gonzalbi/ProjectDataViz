package com.c7dataviz.Controller;
import com.c7dataviz.Model.BarChart;
import com.c7dataviz.Model.SuperHero;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class BarChartDataController {

    public ArrayList<BarChart> generateBarChartData(String attribute, ArrayList<SuperHero> superheroes) throws NoSuchFieldException, IllegalAccessException {

        HashMap<String,BarChart> barChartHashMap = new HashMap<String, BarChart>();
        for(SuperHero s : superheroes){
            Field field = s.getClass().getDeclaredField(attribute);
            String attr = field.get(s).toString();
            if(barChartHashMap.containsKey(attr)){
                barChartHashMap.get(attr).addQuantity(1);
            }else{
                BarChart pC = new BarChart(attr,0);
                barChartHashMap.put(attr,pC);
            }

        }

        int max_quantity = 0;

        for(HashMap.Entry<String, BarChart> entry : barChartHashMap.entrySet()) {
            String key = entry.getKey();
            int quantity = entry.getValue().getY();

            if(quantity> max_quantity){
                max_quantity = quantity;
            }
        }

        BarChart pC_other = new BarChart("Other",0);

        List<String> keys =  new ArrayList<String>();
        for(HashMap.Entry<String, BarChart> entry : barChartHashMap.entrySet()) {
            String key = entry.getKey();
            int quantity = entry.getValue().getY();

            if(max_quantity/3 > quantity){
                pC_other.addQuantity(quantity);
                keys.add(key);
            }
        }

        if(pC_other.getY() > 0) barChartHashMap.put("Other",pC_other);

        for(String key : keys){
            barChartHashMap.remove(key);
        }

        Collection<BarChart> values = barChartHashMap.values();
        return new ArrayList<>(values);
    }


}
