package com.company;

public class Plata extends Avion implements ICatering {

    public Plata(){
        super();
    }

    public Plata (int capacidadCombustible, int costoPorKM, int capacidadMaxPasajeros, int velocidadMax, TipoPropulsion propulsion){
        super(capacidadCombustible, costoPorKM, capacidadMaxPasajeros, velocidadMax, 4000, propulsion);
    }

    @Override
    public String toString(){
        return "Capacidad de combustible: " + getCapacidadCombustible() + "\nCosto por kilometro: " + getCostoPorKM() + "\nCapacidad de pasajeros: " + getCapacidadMaxPasajeros() + "\nVelocidad maxima: " + getVelocidadMax() + "\nTarifa: " + getTarifaAvion() + "\nTipo de propulsion: " + getPropulsion();
    }

    public boolean servicioDeCatering(){
        return this.catering;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Plata )) return false;
        Plata silver = (Plata)obj;
        return  silver.getCostoPorKM() == getCostoPorKM()
                && silver.getCapacidadCombustible() == getCapacidadCombustible()
                && silver.getCapacidadCombustible() == getCapacidadCombustible()
                && silver.getPropulsion() == getPropulsion()
                && silver.getVelocidadMax() == getVelocidadMax();
    }


}
