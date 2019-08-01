package com.c7dataviz.DAO.DAOInterface;

import com.c7dataviz.Model.FilteredSelection;
import com.c7dataviz.Model.SuperHero;

import java.util.ArrayList;

public interface SuperHeroDAO {
    public ArrayList<SuperHero> getAllSuperHeroes();

    public ArrayList<SuperHero> getFilteredSuperHeroes(FilteredSelection selection);
}
