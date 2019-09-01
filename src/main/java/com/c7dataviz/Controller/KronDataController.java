package com.c7dataviz.Controller;

import com.c7dataviz.DAO.KronDataDAOImpl;
import com.c7dataviz.Model.FilteredKSelection;
import com.c7dataviz.Model.KronData;

import java.util.ArrayList;

public class KronDataController {

    public static ArrayList<KronData> getAllData(){
        KronDataDAOImpl kd = new KronDataDAOImpl();

        return kd.getAllData();
    }

    public static ArrayList<KronData> getFilteredData(FilteredKSelection selection){
        KronDataDAOImpl kd = new KronDataDAOImpl();

        return kd.getFilteredData(selection);

    }
}
