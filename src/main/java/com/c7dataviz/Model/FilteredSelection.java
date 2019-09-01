package com.c7dataviz.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class FilteredSelection {
    //SUPERHERO
    public String[] gender;
    public String[] eyecolor;
    public String[] race;
    public String[] haircolor;
    public Double[] height;
    public String[] publisher;
    public String[] skincolor;
    public String[] alignment;
    public Double[] weight;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public FilteredSelection(@JsonProperty("gender") String[] gender,
                             @JsonProperty("eyecolor") String[] eyecolor,
                             @JsonProperty("race") String[] race,
                             @JsonProperty("haircolor") String[] haircolor,
                             @JsonProperty("height") Double[] height,
                             @JsonProperty("publisher") String[] publisher,
                             @JsonProperty("skincolor") String[] skincolor,
                             @JsonProperty("alignment") String[] alignment,
                             @JsonProperty("weight") Double[] weight) {
        this.gender = gender;
        this.eyecolor = eyecolor;
        this.race = race;
        this.haircolor = haircolor;
        this.height = height;
        this.publisher = publisher;
        this.skincolor = skincolor;
        this.alignment = alignment;
        this.weight = weight;
    }

}
