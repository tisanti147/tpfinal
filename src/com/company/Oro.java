package com.company;

public class Oro extends Avion implements ICatering {
    private boolean conexionWifi;

    public Oro (){
        super();
        this.conexionWifi=false;
    }

    public Oro (int capacidadCombustible, int costoPorKM, int capacidadMaxPasajeros, int velocidadMax, TipoPropulsion propulsion, boolean conexionWifi){
        super(capacidadCombustible, costoPorKM, capacidadMaxPasajeros, velocidadMax, 6000, propulsion);
        this.conexionWifi = conexionWifi;
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
        if(!(obj instanceof Oro )) return false;
        Oro gold = (Oro)obj;
        return gold.conexionWifi == conexionWifi
                && gold.getCostoPorKM() == getCostoPorKM()
                && gold.getCapacidadCombustible() == getCapacidadCombustible()
                && gold.getCapacidadMaxPasajeros() == getCapacidadMaxPasajeros()
                && gold.getPropulsion() == getPropulsion()
                && gold.getVelocidadMax() == getVelocidadMax();
    }

}
