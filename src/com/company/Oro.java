package com.company;

public class Oro extends Avion implements catering{
    private boolean conexionWifi;

    public Oro (int capacidadCombustible, int costoPorKM, int capacidadMaxPasajeros, int velocidadMax, TipoPropulsion propulsion, boolean conexionWifi){
        super(capacidadCombustible, costoPorKM, capacidadMaxPasajeros, velocidadMax, 6000, propulsion);
        this.conexionWifi = conexionWifi;
    }

    @Override
    public void servicioDeCatering(){
        System.out.println("Pidiendo servicio de catering.");
    }

}
