package com.company;

import Interfaz.Keyin;
import Usuario.Provincia;
import Usuario.Usuario;
import Usuario.Vuelo;
import Interfaz.Menu;
import Archivos.DataBase;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        // Creando aviones
        Bronce avion1 = new Bronce(3000, 200, 4, 700, TipoPropulsion.HELICE);
        Bronce avion2 = new Bronce(2500, 150, 5, 600, TipoPropulsion.PISTONES);
        Oro avion3 = new Oro(5000, 250, 10, 800, TipoPropulsion.PISTONES, true);

        // Cargando un usuario
        Usuario user1 = new Usuario("Santiago Martinez", 41928128, 20);

        // Creando la compañia con los aviones y usuario
        Compañia company = new Compañia("Tisanti");

        company.addAvion(avion1);
        company.addAvion(avion2);
        company.addAvion(avion3);

        company.addUsuario(user1);

        // Creando vuelos y cargandolos en compañia
        Vuelo flight1 = new Vuelo("23 de mayo", 3, avion1, 1000, Provincia.BSAS, Provincia.CORDOBA);
        Vuelo flight2 = new Vuelo("8 de julio", 3, avion2, 1000, Provincia.BSAS, Provincia.CORDOBA);
        Vuelo flight3 = new Vuelo("2 de abril", 2, avion3, 5000, Provincia.CORDOBA, Provincia.MONTEVIDEO);

        user1.addVuelo(flight1);
        user1.addVuelo(flight3);

        company.addVuelo(flight1);
        company.addVuelo(flight2);
        company.addVuelo(flight3);

        // El menu recibe la compañia cargada. El vuelo y el usuario se generan dentro del menu

        Menu menu = new Menu();
        menu.ejecutarMenu(company);

        company.getListaVuelos();

        /*DataBase archivo = new DataBase();
        archivo.escribirArchivoCompañia(company);
        archivo.leerArchivoCompañia();*/

    }


}
