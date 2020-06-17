package com.company;

import Usuario.Provincia;
import Usuario.Vuelo;

public class Main {

    public static void main(String[] args) {
        Bronce avion = new Bronce(3000, 150, 50, 700, TipoPropulsion.HELICE);

        Vuelo vuelo1 = new Vuelo("2 de mayo", 5, avion, 0);

        Vuelo vuelo2 = new Vuelo("2 de mayo", 5, avion, vuelo1.calcularCosto(avion, 5, 1100));


        System.out.println(vuelo2.toString());

    }


}
