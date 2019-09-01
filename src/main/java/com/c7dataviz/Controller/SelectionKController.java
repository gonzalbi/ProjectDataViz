package com.c7dataviz.Controller;

import com.c7dataviz.DAO.SelectionKDAOImpl;
import com.c7dataviz.Model.FilteredKSelection;

import java.util.ArrayList;

public class SelectionKController {


    public FilteredKSelection getAll(){

        SelectionKDAOImpl sd = new SelectionKDAOImpl();
        return new FilteredKSelection(
                castToStringArray(sd,"fecha"),
                castToStringArray(sd,"hora"),
                castToStringArray(sd,"usuario"),
                castToStringArray(sd,"funcionalidad"),
                castToStringArray(sd,"accion"),
                castToStringArray(sd,"objeto"),
                castToStringArray(sd,"dato_modificado"),
                castToStringArray(sd,"old_data"),
                castToStringArray(sd,"new_data")
                );

    }

    private String[] castToStringArray(SelectionKDAOImpl sd,String attr){
        ArrayList<String> data = sd.getDistinctAttribute(attr);
        String[] data_arr = new String[data.size()];

        return data.toArray(data_arr);
    }

}
