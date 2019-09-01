package com.c7dataviz.DAO.DAOInterface;
import com.c7dataviz.Model.FilteredKSelection;
import com.c7dataviz.Model.KronData;

import java.util.ArrayList;

public interface KronDataDao {
    public ArrayList<KronData> getAllData();
    public ArrayList<KronData> getFilteredData(FilteredKSelection selection);
}
