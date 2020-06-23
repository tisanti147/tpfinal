package com.company;

import Interfaz.Keyin;
import Usuario.Provincia;
import Usuario.Usuario;
import Usuario.Vuelo;
import Interfaz.Menu;
import Archivos.BaseDatos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Main implements Serializable {

    public static void main(String[] args) throws IOException {
        // Creando aviones
        Bronce avion1 = new Bronce(3000, 200, 4, 700, TipoPropulsion.HELICE);
        Bronce avion2 = new Bronce(2500, 150, 5, 600, TipoPropulsion.PISTONES);
        Oro avion3 = new Oro(5000, 250, 10, 800, TipoPropulsion.PISTONES, true);
        Plata avion4 = new Plata(4000, 225, 7, 750, TipoPropulsion.PISTONES);

        // Cargando un usuario
        Usuario user1 = new Usuario("Santiago Martinez", 41928128, 20);

        // Creando la compañia y cargandola con los aviones y usuario
        Compañia company = new Compañia("Tisanti");

        company.addAvion(avion1);
        company.addAvion(avion2);
        company.addAvion(avion3);
        company.addAvion(avion4);

        company.addUsuario(user1);

        // Creando vuelos y cargandolos en compañia y usuario
        Vuelo flight1 = new Vuelo("23 de mayo", 3, avion1, 1000, Provincia.BSAS, Provincia.CORDOBA);
        Vuelo flight2 = new Vuelo("8 de julio", 3, avion2, 1000, Provincia.BSAS, Provincia.CORDOBA);
        Vuelo flight3 = new Vuelo("2 de abril", 2, avion3, 5000, Provincia.CORDOBA, Provincia.MONTEVIDEO);
        Vuelo flight4 = new Vuelo("1 de enero", 6, avion4, 4000, Provincia.MONTEVIDEO, Provincia.SANTIAGO);

        user1.addVuelo(flight1);
        user1.addVuelo(flight4);
        user1.addVuelo(flight2);

        company.addVuelo(flight1);
        company.addVuelo(flight2);
        company.addVuelo(flight3);
        company.addVuelo(flight4);

        // El menu recibe la compañia cargada. El vuelo y el usuario se generan dentro del menu
        BaseDatos db = new BaseDatos();
        //Compañia comp = BaseDatos.levantarCompania();

        Menu menu = new Menu();
        menu.ejecutarMenu(company);


        db.guardarCompania(company);

        /*company.mostrarListaVuelos();
        company.mostrarListaUsuario();
        company.mostrarListaAviones();*/


        /*
        String path = "D:\\USUARIOS\\Desktop\\Santi\\tpfinal\\Compañia.txt";

        File myFile = new File(path);

        if (myFile.exists()) {

            try {

                // Escritura
                FileOutputStream fileOutputStream = new FileOutputStream(myFile);

                ObjectOutputStream objOutputStream = new ObjectOutputStream(fileOutputStream);

                objOutputStream.writeObject(company);

                objOutputStream.close();

//              ESCRITURA EN JACKSON
                File file = new File("Compañia.json");
                ObjectMapper mapper = new ObjectMapper();
                //Object to JSON in file
                mapper.writeValue(file, company);
//

                //Lectura
                FileInputStream fileInputStream = new FileInputStream(myFile);

                ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);

                Object aux = objInputStream.readObject();

                System.out.println("OBJECTINPUTSTREAM:\n" + aux.toString());

                objInputStream.close();

//                LECTURA EN JACKSON
                file = new File("Compañia.json");
                //Compañia[] comp = mapper.readValue(file, Compañia[].class);
                ArrayList<Compañia> comp = mapper.readValue(file, new TypeReference<ArrayList<Compañia>>(){});
                //Collection<Compañia> comp = mapper.readValue("Compañia.json", new TypeReference<Collection<Compañia>>() { });
                System.out.println("JACKSON:\n" + comp.toString());
                //comp.mostrarListaUsuario();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("No se pudo leer/escribir el archivo: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("No se encuentra el archivo.");
        }*/


    }
}
