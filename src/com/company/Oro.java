package com.company;

public class Oro extends Avion implements catering{
    private boolean conexionWifi;

    public Oro (int capacidadCombustible, int costoPorKM, int capacidadMaxPasajeros, int velocidadMax, TipoPropulsion propulsion, boolean conexionWifi){
        super(capacidadCombustible, costoPorKM, capacidadMaxPasajeros, velocidadMax, 6000, propulsion);
        this.conexionWifi = conexionWifi;
    }

    @Override
    public String toString(){
        return "Categoria Oro: \nID del avion: " + getId() + "\nCapacidad de combustible: " + getCapacidadCombustible() + "\nCosto por kilometro: " + getCostoPorKM() + "\nCapacidad de pasajeros: " + getCapacidadMaxPasajeros() + "\nVelocidad maxima: " + getVelocidadMax() + "\nTarifa: " + getTarifaAvion() + "\nTipo de propulsion: " + getPropulsion();
    }

    @Override
    public boolean servicioDeCatering(){
        return true;
    }

}
