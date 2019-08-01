package com.c7dataviz.Controller;

import com.c7dataviz.DAO.SelectionDAOImpl;
import com.c7dataviz.Model.FilteredSelection;

import java.util.ArrayList;

public class SelectionController {

    public FilteredSelection getAll(){

        SelectionDAOImpl sd = new SelectionDAOImpl();
        Double[] h = new Double[2];
        h[0] = 0.0;
        h[1] = 999.9;
        return new FilteredSelection(
                castToStringArray(sd,"Gender"),
                castToStringArray(sd,"Eye color"),
                castToStringArray(sd,"Race"),
                castToStringArray(sd,"Hair color"),
                h,
                castToStringArray(sd,"Publisher"),
                castToStringArray(sd,"Skin color"),
                castToStringArray(sd,"Alignment"),
                h);

    }

    private String[] castToStringArray(SelectionDAOImpl sd,String attr){
        ArrayList<String> data = sd.getDistinctAttribute(attr);
        String[] data_arr = new String[data.size()];

        return data.toArray(data_arr);
    }

}
