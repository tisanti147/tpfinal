package com.company;

import java.io.Serializable;

public class Plata extends Avion implements catering, Serializable {
    public Plata (int capacidadCombustible, int costoPorKM, int capacidadMaxPasajeros, int velocidadMax, TipoPropulsion propulsion){
        super(capacidadCombustible, costoPorKM, capacidadMaxPasajeros, velocidadMax, 4000, propulsion, false);
    }

    @Override
    public String toString(){
        return "\nCategoria: Plata \nID del avion: " + getId() + "\nCapacidad de combustible: " + getCapacidadCombustible() + "\nCosto por kilometro: " + getCostoPorKM() + "\nCapacidad de pasajeros: " + getCapacidadMaxPasajeros() + "\nVelocidad maxima: " + getVelocidadMax() + "\nTarifa: " + getTarifaAvion() + "\nTipo de propulsion: " + getPropulsion();
    }

    @Override
    public boolean servicioDeCatering(){
        return true;
    }

}
