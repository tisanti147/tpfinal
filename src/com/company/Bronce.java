package com.company;

public class Bronce extends Avion {

    public Bronce (int capacidadCombustible, int costoPorKM, int capacidadMaxPasajeros, int velocidadMax, TipoPropulsion propulsion){
        super(capacidadCombustible, costoPorKM, capacidadMaxPasajeros, velocidadMax, 3000, propulsion);
    }

    @Override
    public String toString(){
        return "Capacidad de combustible: " + getCapacidadCombustible() + "\nCosto por kilometro: " + getCostoPorKM() + "\nCapacidad de pasajeros: " + getCapacidadMaxPasajeros() + "\nVelocidad maxima: " + getVelocidadMax() + "\nTarifa: " + getTarifaAvion() + "\nTipo de propulsion: " + getPropulsion();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Bronce )) return false;
        Bronce brc = (Bronce)obj;
        return  brc.getCostoPorKM() == getCostoPorKM()
                && brc.getCapacidadCombustible() == getCapacidadCombustible()
                && brc.getCapacidadMaxPasajeros() == getCapacidadMaxPasajeros()
                && brc.getPropulsion() == getPropulsion()
                && brc.getVelocidadMax() == getVelocidadMax();
    }
}
