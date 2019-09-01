package com.c7dataviz.Model;

import java.util.Date;

public class KronData {

    public String fecha;
    public String hora;
    public String usuario;
    public String funcionalidad;
    public String accion;
    public String objeto;
    public String dato_modificado;
    public String old_data;
    public String new_data;

    public KronData(String fecha, String hora, String usuario, String funcionalidad, String accion, String objeto, String dato_modificado, String old_data, String new_data) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getDato_modificado() {
        return dato_modificado;
    }

    public void setDato_modificado(String dato_modificado) {
        this.dato_modificado = dato_modificado;
    }

    public String getOld_data() {
        return old_data;
    }

    public void setOld_data(String old_data) {
        this.old_data = old_data;
    }

    public String getNew_data() {
        return new_data;
    }

    public void setNew_data(String new_data) {
        this.new_data = new_data;
    }
}
