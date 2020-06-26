package com.company;

import java.io.Serializable;

public class Oro extends Avion implements catering, Serializable {

    public Oro (int capacidadCombustible, int costoPorKM, int capacidadMaxPasajeros, int velocidadMax, TipoPropulsion propulsion/*boolean conexionWifi*/){
        super(capacidadCombustible, costoPorKM, capacidadMaxPasajeros, velocidadMax, 6000, propulsion, true);
    }

    @Override
    public String toString(){
        return "ID del avion: " + getId() + "\nCapacidad de combustible: " + getCapacidadCombustible() + "\nCosto por kilometro: " + getCostoPorKM() + "\nCapacidad de pasajeros: " + getCapacidadMaxPasajeros() + "\nVelocidad maxima: " + getVelocidadMax() + "\nTarifa: " + getTarifaAvion() + "\nTipo de propulsion: " + getPropulsion()/* + "\nConexion a WiFi: " + isConexionWifi()*/;
    }

    @Override
    public boolean servicioDeCatering(){
        return true;
    }

    /*public boolean isConexionWifi() {
        return conexionWifi;
    }*/
}
