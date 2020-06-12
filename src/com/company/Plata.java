package com.company;

public class Plata extends Avion implements catering{
    public Plata (int capacidadCombustible, int costoPorKM, int capacidadMaxPasajeros, int velocidadMax, TipoPropulsion propulsion){
        super(capacidadCombustible, costoPorKM, capacidadMaxPasajeros, velocidadMax, 4000, propulsion);
    }

    @Override
    public void servicioDeCatering(){
        System.out.println("Pidiendo servicio de catering.");
    }

}
