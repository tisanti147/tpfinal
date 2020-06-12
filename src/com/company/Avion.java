package com.company;

public abstract class Avion {
    private int capacidadCombustible;
    private int costoPorKM;
    private int capacidadMaxPasajeros;
    private int velocidadMax;
    private int tarifaAvion;
    private TipoPropulsion propulsion;

    public Avion (int capacidadCombustible, int costoPorKM, int capacidadMaxPasajeros, int velocidadMax, int tarifaAvion, TipoPropulsion propulsion){
        this.capacidadCombustible = capacidadCombustible;
        this.costoPorKM = costoPorKM;
        this. capacidadMaxPasajeros = capacidadMaxPasajeros;
        this.velocidadMax = velocidadMax;
        this.tarifaAvion = tarifaAvion;
        this.propulsion = propulsion;
    }

}
