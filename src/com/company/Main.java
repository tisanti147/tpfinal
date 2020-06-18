package com.company;

import Usuario.Provincia;
import Usuario.Vuelo;
import Interfaz.Menu;

public class Main {

    public static void main(String[] args) {
        //Bronce avion = new Bronce(3000, 150, 50, 700, TipoPropulsion.HELICE);

        Vuelo vuelo = new Vuelo();

        Menu menu = new Menu();
        menu.ejecutarMenu(vuelo);

        /*Vuelo vuelo1 = new Vuelo("2 de mayo", 5, avion, 0, Provincia.MONTEVIDEO, Provincia.BSAS);

        vuelo1.setDistances();

        int distancia = vuelo1.getDistance(vuelo1.getOrigen().getNombre(), vuelo1.getDestino().getNombre());
        System.out.println(distancia);

        int costoTotal = vuelo1.calcularCosto(avion, vuelo1.getCantPasajeros(), distancia);

        Vuelo vuelo2 = new Vuelo("2 de mayo", 5, avion, costoTotal, vuelo1.getOrigen(), vuelo1.getDestino());

        //(Cantidad de kms * Costo del km) + (cantidad de pasajeros * 3500) + (Tarifa del tipo de avión)

        System.out.println(vuelo2.toString());*/
    }


}
