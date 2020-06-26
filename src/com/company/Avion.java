package com.company;

import java.io.Serializable;

public class Avion implements Serializable {
    private static int contador = 0;
    private int id;
    private int capacidadCombustible;
    private int costoPorKM;
    private int capacidadMaxPasajeros;
    private int velocidadMax;
    private int tarifaAvion;
    private TipoPropulsion propulsion;
    private boolean conexionWifi;

    public Avion(){
        super();
    }

    public Avion (int capacidadCombustible, int costoPorKM, int capacidadMaxPasajeros, int velocidadMax, int tarifaAvion, TipoPropulsion propulsion, boolean conexionWifi){
        this.contador++;
        this.id = contador;
        this.capacidadCombustible = capacidadCombustible;
        this.costoPorKM = costoPorKM;
        this. capacidadMaxPasajeros = capacidadMaxPasajeros;
        this.velocidadMax = velocidadMax;
        this.tarifaAvion = tarifaAvion;
        this.propulsion = propulsion;
        this.conexionWifi = conexionWifi;
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

    @Override
    public String toString() {
        return
                "\nID del avion: " + id +
                "\nCapacidad de combustible: " + capacidadCombustible +
                "\nCosto por KM: " + costoPorKM +
                "\nCapacidad de pasajeros: " + capacidadMaxPasajeros +
                "\nVelocidad maxima: " + velocidadMax +
                "\nTarifa del avion: " + tarifaAvion +
                "\nTipo de propulsion: " + propulsion;
    }

    public boolean isConexionWifi() {
        return conexionWifi;
    }

    public void setConexionWifi(boolean conexionWifi) {
        this.conexionWifi = conexionWifi;
    }
}
