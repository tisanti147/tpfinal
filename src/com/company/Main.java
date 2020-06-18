package com.company;

import Usuario.Provincia;
import Usuario.Usuario;
import Usuario.Vuelo;
import Interfaz.Menu;

public class Main {

    public static void main(String[] args) {
        Bronce avion1 = new Bronce(3000, 200, 50, 700, TipoPropulsion.HELICE);
        Bronce avion2 = new Bronce(2500, 150, 40, 600, TipoPropulsion.PISTONES);

        Usuario user1 = new Usuario("Santiago", "Martinez", 41928128, 20, null);

        Compañia company = new Compañia("Tisanti");

        company.addAvion(avion1);
        company.addAvion(avion2);
        company.addUsuario(user1);
        company.getListaUsuario();

        Vuelo vuelo = new Vuelo();

        Menu menu = new Menu();
        menu.ejecutarMenu(vuelo, company);

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
