package com.company;

public class Bronce extends Avion {
    public Bronce (int capacidadCombustible, int costoPorKM, int capacidadMaxPasajeros, int velocidadMax, TipoPropulsion propulsion){
        super(capacidadCombustible, costoPorKM, capacidadMaxPasajeros, velocidadMax, 3000, propulsion);
    }

    @Override
    public String toString(){
        return "ID del avion: " + getId() + "\nCapacidad de combustible: " + getCapacidadCombustible() + "\nCosto por kilometro: " + getCostoPorKM() + "\nCapacidad de pasajeros: " + getCapacidadMaxPasajeros() + "\nVelocidad maxima: " + getVelocidadMax() + "\nTarifa: " + getTarifaAvion() + "\nTipo de propulsion: " + getPropulsion();
    }
}
