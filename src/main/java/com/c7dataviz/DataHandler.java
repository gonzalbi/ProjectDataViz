package com.c7dataviz;
import com.c7dataviz.Controller.*;
import com.c7dataviz.Model.*;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class DataHandler {
    @RequestMapping("/data")
    public String index(){
        Gson gson = new Gson();
        ArrayList<SuperHero> sups = SuperHeroController.getAllSupers();
        SelectionController sc = new SelectionController();
        HashMap<String,ArrayList> return_data = generateCharts(sups);
        ArrayList<FilteredSelection> fs = new ArrayList<>();
        fs.add(sc.getAll());
        return_data.put("Selection", fs);
        return gson.toJson(return_data);
    }

    @PostMapping("/filterData")
    public String filter(@RequestBody FilteredSelection selection){
        Gson gson = new Gson();
        ArrayList<SuperHero> sups = SuperHeroController.getFilteredSuperHeroes(selection);
        HashMap<String,ArrayList> return_data = generateCharts(sups);
        return gson.toJson(return_data);
    }

    private HashMap<String,ArrayList> generateCharts(ArrayList<SuperHero> sups){
        PieChartDataController pC = new PieChartDataController();
        BarChartDataController bC = new BarChartDataController();
        AreaSeriesController aC = new AreaSeriesController();
        ArrayList<PieChart> gender_pcs;
        ArrayList<PieChart> aligment_pcs;
        ArrayList<BarChart> publisher_barCharts;
        ArrayList<AreaSeries> height_area;
        ArrayList<AreaSeries> weight_area;

        HashMap<String,ArrayList> return_data = new HashMap<>();

        try{
            gender_pcs = pC.generatePieChartData("gender",sups);
            aligment_pcs = pC.generatePieChartData("alignment",sups);
            publisher_barCharts = bC.generateBarChartData("publisher",sups);
            height_area = aC.generateAreaSeriesData("height",sups);
            weight_area = aC.generateAreaSeriesData("weight",sups);
            ArrayList<Integer> size = new ArrayList<>();
            size.add(sups.size());

            return_data.put("dataLenght",size);
            return_data.put("gender",gender_pcs);
            return_data.put("alignment",aligment_pcs);
            return_data.put("publisher",publisher_barCharts);
            return_data.put("height",height_area);
            return_data.put("weight",weight_area);

        }catch (Exception e){
            System.out.println(e);
        }
        return return_data;
    }

}
