package com.company;

public abstract class Avion {

    private int capacidadCombustible;
    private int costoPorKM;
    private int capacidadMaxPasajeros;
    private int velocidadMax;
    private int tarifaAvion;
    private TipoPropulsion propulsion;


    public Avion(){
        this.capacidadCombustible=0;
        this.costoPorKM=0;
        this.capacidadMaxPasajeros=0;
        this.velocidadMax=0;
        this.propulsion=null;
    }

    public Avion (int capacidadCombustible, int costoPorKM, int capacidadMaxPasajeros, int velocidadMax, int tarifaAvion, TipoPropulsion propulsion){
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


    public void setCapacidadCombustible(int capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }

    public void setCostoPorKM(int costoPorKM) {
        this.costoPorKM = costoPorKM;
    }

    public void setCapacidadMaxPasajeros(int capacidadMaxPasajeros) {
        this.capacidadMaxPasajeros = capacidadMaxPasajeros;
    }

    public void setVelocidadMax(int velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public void setPropulsion(TipoPropulsion propulsion) {
        this.propulsion = propulsion;
    }
}

