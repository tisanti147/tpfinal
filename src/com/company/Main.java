package com.company;

import Usuario.Provincia;
import Usuario.Vuelo;
import Interfaz.Menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.ejecutarMenu();
        /*Bronce avion = new Bronce(3000, 150, 50, 700, TipoPropulsion.HELICE);

        Vuelo vuelo1 = new Vuelo("2 de mayo", 5, avion, 0);

        Vuelo vuelo2 = new Vuelo("2 de mayo", 5, avion, vuelo1.calcularCosto(avion, 5, 1100));

        vuelo1.setDistances();

        System.out.println(vuelo1.getDistance(Provincia.BSAS.getNombre(), Provincia.CORDOBA.getNombre()));*/

        //System.out.println(vuelo2.toString());
    }


}
