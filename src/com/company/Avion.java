package com.company;

import java.io.Serializable;

public abstract class Avion implements Serializable {
    private static int contador = 0;
    private int id;
    private int capacidadCombustible;
    private int costoPorKM;
    private int capacidadMaxPasajeros;
    private int velocidadMax;
    private int tarifaAvion;
    private TipoPropulsion propulsion;

    /*public Avion() {
    }*/

    public Avion (int capacidadCombustible, int costoPorKM, int capacidadMaxPasajeros, int velocidadMax, int tarifaAvion, TipoPropulsion propulsion){
        this.contador++;
        this.id = contador;
        this.capacidadCombustible = capacidadCombustible;
        this.costoPorKM = costoPorKM;
        this. capacidadMaxPasajeros = capacidadMaxPasajeros;
        this.velocidadMax = velocidadMax;
        this.tarifaAvion = tarifaAvion;
        this.propulsion = propulsion;
    }

    public int getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public int getCostoPorKM() {
        return costoPorKM;
    }

    public int getCapacidadMaxPasajeros() {
        return capacidadMaxPasajeros;
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

    public int getTarifaAvion() {
        return tarifaAvion;
    }

    public TipoPropulsion getPropulsion() {
        return propulsion;
    }

    public int getId() {
        return id;
    }
}
