package com.company;

import Usuario.Vuelo;

public class VueloCompañia extends Vuelo {
    private static int vueloCompañiaContador=0;
    private int vueloCompañiaID;
    private int pasajerosVuelo;

    public VueloCompañia(){
        super();
        this.vueloCompañiaContador++;
        this.vueloCompañiaID=this.vueloCompañiaContador;
        this.pasajerosVuelo=0;
    }

    public int getPasajerosVuelo() {
        return pasajerosVuelo;
    }

    public void setPasajerosVuelo(int pasajerosVuelo) {
        this.pasajerosVuelo = pasajerosVuelo;
    }

}
