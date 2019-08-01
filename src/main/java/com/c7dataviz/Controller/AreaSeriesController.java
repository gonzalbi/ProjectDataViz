package com.c7dataviz.Controller;

import com.c7dataviz.Model.AreaSeries;
import com.c7dataviz.Model.SuperHero;

import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

public class AreaSeriesController {

    public ArrayList<AreaSeries> generateAreaSeriesData(String attribute, ArrayList<SuperHero> superheroes) throws NoSuchFieldException, IllegalAccessException {

        //superheroes.sort(Comparator.comparing(superHero -> superHero.getHeight()));

        HashMap<String, AreaSeries> areaSeriesHashMap = new HashMap<String, AreaSeries>();
        for (SuperHero s : superheroes) {
            Field field = s.getClass().getDeclaredField(attribute);
            String attr = field.get(s).toString();
            if (areaSeriesHashMap.containsKey(attr)) {
                areaSeriesHashMap.get(attr).addQuantity();
            } else {
                AreaSeries pC = new AreaSeries(attr, 1);
                areaSeriesHashMap.put(attr, pC);
            }

        }

        Collection<AreaSeries> values = areaSeriesHashMap.values();
        ArrayList<AreaSeries> as_ret = new ArrayList<>(values);

        as_ret.sort(Comparator.comparing(areaSeries -> areaSeries.x));
        return as_ret;
    }
}
