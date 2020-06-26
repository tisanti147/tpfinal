package com.company;

import Usuario.Provincia;
import Usuario.Usuario;
import Usuario.Vuelo;
import Interfaz.Menu;
import Archivos.BaseDatos;

import java.io.*;
import java.util.ArrayList;

public class Main implements Serializable {

    public static void main(String[] args) throws IOException {
        // Creando aviones
        Bronce avion1 = new Bronce(3000, 200, 4, 700, TipoPropulsion.HELICE);
        Bronce avion2 = new Bronce(2500, 150, 5, 600, TipoPropulsion.PISTONES);
        Oro avion3 = new Oro(5000, 250, 10, 800, TipoPropulsion.REACCION);
        Plata avion4 = new Plata(4000, 225, 7, 750, TipoPropulsion.PISTONES);
        Plata avion5 = new Plata(3500, 210, 5, 650, TipoPropulsion.HELICE);
        Bronce avion6 = new Bronce(3200, 175, 4, 675, TipoPropulsion.HELICE);

        // Creando la compañia y cargandola con los aviones y usuario
        Empresa company = new Empresa("Tisanti");

        company.addAvion(avion1);
        company.addAvion(avion2);
        company.addAvion(avion3);
        company.addAvion(avion4);
        company.addAvion(avion5);
        company.addAvion(avion6);

        // Creando vuelos y cargandolos en compañia y usuario
        Vuelo flight1 = new Vuelo("23 de mayo", 3, avion1, 1000, Provincia.BSAS, Provincia.CORDOBA);
        Vuelo flight2 = new Vuelo("8 de julio", 3, avion2, 1000, Provincia.BSAS, Provincia.CORDOBA);
        Vuelo flight3 = new Vuelo("18 de abril", 2, avion3, 5000, Provincia.CORDOBA, Provincia.MONTEVIDEO);
        Vuelo flight4 = new Vuelo("2 de enero", 6, avion4, 4000, Provincia.MONTEVIDEO, Provincia.SANTIAGO);
        Vuelo flight5 = new Vuelo("4 de octubre", 5, avion5, 3500, Provincia.SANTIAGO, Provincia.BSAS);
        Vuelo flight6 = new Vuelo("15 de septiembre", 4, avion6, 4000, Provincia.MONTEVIDEO, Provincia.CORDOBA);

        ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
        vuelos.add(flight1);
        vuelos.add(flight3);
        vuelos.add(flight2);

        Usuario user1 = new Usuario("Santiago Martinez", 41928128, 20, vuelos);

        company.addVuelo(flight1);
        company.addVuelo(flight2);
        company.addVuelo(flight3);
        company.addVuelo(flight4);
        company.addVuelo(flight5);
        company.addVuelo(flight6);
        company.addUsuario(user1);

        // El menu recibe la compañia cargada. El vuelo y el usuario se generan dentro del menu
        BaseDatos db = new BaseDatos();
        Empresa comp = BaseDatos.levantarCompania();

        Menu menu = new Menu();
        menu.ejecutarMenu(comp);

        // Guarda la compañia en un archivo JSON
        db.guardarCompania(comp);
    }
}
