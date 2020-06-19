package com.company;

import Usuario.Provincia;
import Usuario.Usuario;
import Usuario.Vuelo;
import Interfaz.Menu;

public class Main {

    public static void main(String[] args) {
        // Creando aviones
        Bronce avion1 = new Bronce(3000, 200, 5, 700, TipoPropulsion.HELICE);
        Bronce avion2 = new Bronce(2500, 150, 4, 600, TipoPropulsion.PISTONES);

        // Cargando un usuario
        Usuario user1 = new Usuario("Santiago", "Martinez", 41928128, 20);

        // Creando la compañia con los aviones y usuario
        Compañia company = new Compañia("Tisanti");

        company.addAvion(avion1);
        company.addAvion(avion2);

        company.addUsuario(user1);

        Vuelo flight1 = new Vuelo("23 de mayo", 3, avion1, 1000, Provincia.BSAS, Provincia.CORDOBA);
        Vuelo flight2 = new Vuelo("8 de julio", 3, avion2, 1000, Provincia.BSAS, Provincia.CORDOBA);

        company.addVuelo(flight1);
        company.addVuelo(flight2);

        //company.getListaVuelos();

        company.mostrarAvionesDisponibles("9 de marzo");

        // Generando el vuelo. El menu recibe una variable tipo Vuelo vacia y la compañia cargada
        Vuelo vuelo = new Vuelo();

        Menu menu = new Menu();
        menu.ejecutarMenu(vuelo, company);

        user1.addVuelo(vuelo);
        user1.toString();

        company.addVuelo(vuelo);
        company.getListaVuelos();

        /*System.out.println("\nMostrando aviones disponibles \n");
        company.getAvionesDisponibles("3 de julio");*/

    }


}
