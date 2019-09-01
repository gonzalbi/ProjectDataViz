package com.c7dataviz.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class FilteredKSelection {

    //KRON
    public String[] fecha;
    public String[] hora;
    public String[] usuario;
    public String[] funcionalidad;
    public String[] accion;
    public String[] objeto;
    public String[] dato_modificado;
    public String[] old_data;
    public String[] new_data;


    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public FilteredKSelection(@JsonProperty("fecha") String[] fecha,
                             @JsonProperty("hora") String[] hora,
                             @JsonProperty("usuario") String[] usuario,
                             @JsonProperty("funcionalidad") String[] funcionalidad,
                             @JsonProperty("accion") String[] accion,
                             @JsonProperty("objeto") String[] objeto,
                             @JsonProperty("dato_modificado") String[] dato_modificado,
                             @JsonProperty("old_data") String[] old_data,
                             @JsonProperty("new_data") String[] new_data) {
        this.fecha = fecha;
        this.hora = hora;
        this.usuario = usuario;
        this.funcionalidad = funcionalidad;
        this.accion = accion;
        this.objeto = objeto;
        this.dato_modificado = dato_modificado;
        this.old_data = old_data;
        this.new_data = new_data;
    }

}
