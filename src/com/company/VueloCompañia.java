package com.company;

import Usuario.Vuelo;
import java.util.ArrayList;

public class VueloCompañia{
    private static int vueloCompañiaContador=0;
    private int vueloCompañiaID;
    private int pasajerosVuelo;
    private ArrayList<Vuelo> listaVuelos;

    public void addVuelo(Vuelo vuelo){
        this.listaVuelos.add(vuelo);
    }

    public VueloCompañia(){
        this.vueloCompañiaContador++;
        this.vueloCompañiaID=this.vueloCompañiaContador;
        this.pasajerosVuelo = 0;
    }

    public void agregarPasajeros (Vuelo vuelo){
        this.pasajerosVuelo += vuelo.getCantPasajeros();
    }

    @Override
    public String toString(){
        return "ID del vuelo: " + getVueloCompañiaID() + "\nPasajeros en el vuelo: " + getPasajerosVuelo();
    }

    public boolean capacidadVuelo(Vuelo vuelo, VueloCompañia flight){
        return ((flight.getPasajerosVuelo()+vuelo.getCantPasajeros()) <= vuelo.getAvion().getCapacidadMaxPasajeros())? true : false;
    }

    public int getPasajerosVuelo() {
        return pasajerosVuelo;
    }

    public void setPasajerosVuelo(int pasajerosVuelo) {
        this.pasajerosVuelo = pasajerosVuelo;
    }

    public int getVueloCompañiaID() {
        return vueloCompañiaID;
    }
}
