package com.c7dataviz.Controller;

import com.c7dataviz.DAO.SuperHeroDAOImpl;
import com.c7dataviz.Model.FilteredSelection;
import com.c7dataviz.Model.SuperHero;

import java.util.ArrayList;

public class SuperHeroController {

    public static ArrayList<SuperHero> getAllSupers(){
        SuperHeroDAOImpl sd = new SuperHeroDAOImpl();

        return sd.getAllSuperHeroes();
    }

    public static ArrayList<SuperHero> getFilteredSuperHeroes(FilteredSelection selection){
        SuperHeroDAOImpl sd = new SuperHeroDAOImpl();

        return sd.getFilteredSuperHeroes(selection);

    }

}
