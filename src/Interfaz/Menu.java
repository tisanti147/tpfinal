package Interfaz;

import Archivos.BaseDatos;
import Usuario.Provincia;
import Usuario.Vuelo;
import com.company.Avion;
import com.company.Compañia;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private int swValue;
    private int origen;
    private int destino;
    private int pasajeros;
    private Provincia originProv;
    private Provincia destinationProv;
    private BaseDatos archivoCompañia = new BaseDatos();
    //private String fecha;
    //private Compañia company;

    public Menu(){

    }

    // Switch construct
    public void ejecutarMenu(Vuelo vuelo, Compañia company){


        try {
            archivoCompañia.leerArchivoCompañia();

        int opcion = 0;
        String fecha;
        Scanner sc = new Scanner(System.in);

        System.out.println("|   MENU SELECTION DEMO             |");
        System.out.println("| Options:                          |");
        System.out.println("|        1. Reservar pasaje         |");
        System.out.println("|        2. Option 2                |");
        System.out.println("|        3. Exit                    |");
        swValue = Keyin.inInt(" Seleccionar opcion: ");


        switch (swValue) {
            case 1:

                System.out.println("Indicar fecha");
                System.out.println("Fecha: ");

                //fecha = Keyin.inString();
                fecha = sc.nextLine();
                //System.out.println(fecha);

                //company.mostrarAvionesDisponibles(fecha);

                // Se guarda la fecha del vuelo
                vuelo.setFecha(fecha);

                System.out.println("Indicar lugar de origen: ");
                do {
                    System.out.println("1. Buenos Aires\n2. Cordoba\n3. Santiago de Chile\n4. Montevideo");
                    origen = Keyin.inInt("Origen: ");

                    if (origen > 4 || origen < 1)
                        System.out.println("Opcion incorrecta.");
                }while (origen > 4 || origen < 1);

                // Se guarda el origen del vuelo
                originProv = Provincia.valueOf(origen);
                System.out.println(originProv);
                vuelo.setOrigen(originProv);

                switch (origen) {
                    case 1:
                        System.out.println("1. Cordoba\n2. Santiago de Chile\n3. Montevideo");
                        break;
                    case 2:
                        System.out.println("1. Buenos Aires\n2. Santiago de Chile\n3. Montevideo");
                        break;
                    case 3:
                        System.out.println("1. Buenos Aires\n2. Cordoba\n3. Montevideo");
                        break;
                    case 4:
                        System.out.println("1. Buenos Aires\n2. Cordoba\n3. Santiago de Chile");
                        break;
                }

                do{
                    destino = Keyin.inInt("Destino: ");
                    if (destino < 1 || destino > 3)
                        System.out.println("Opcion incorrecta.");
                }while (destino < 1 || destino > 3);

                // Comprobando cual es el destino
                if (origen > 1 && destino == 1)
                    destinationProv = Provincia.BSAS;
                if (origen < 4 && destino == 3)
                    destinationProv = Provincia.MONTEVIDEO;
                if (origen == 1 && destino == 1)
                    destinationProv = Provincia.CORDOBA;
                if (origen > 2 && destino == 2)
                    destinationProv = Provincia.CORDOBA;
                if (origen < 3 && destino == 2)
                    destinationProv = Provincia.SANTIAGO;
                if (origen == 4 && destino == 3)
                    destinationProv = Provincia.SANTIAGO;

                System.out.println(destinationProv);

                // Se guarda el destino del vuelo
                vuelo.setDestino(destinationProv);

                // Muestra los aviones. El usuario tiene que elegir uno
                // Comprueba que la opcion ingresada sea acorde a las aviones disponibles
                // Comprueba que el avion elegido no este reservado para la fecha ingresada

                company.mostrarAvionesDisponibles(fecha);
                int aviones = company.getListaAviones();
                System.out.println("\n\n");

                System.out.println("Elija el avion para su vuelo: ");
                do{
                    opcion = Keyin.inInt("Ingrese ID del avion: ");
                    if (company.comprobarIdAvion(opcion, fecha))
                        System.out.println("El avion con esa ID no está disponible en la fecha ingresada");
                    if (opcion < 1 || opcion >aviones)
                        System.out.println("No existen aviones con esa numero de ID");
                }while (company.comprobarIdAvion(opcion, fecha) || opcion < 1 || opcion >aviones);

                /*int aviones = company.getListaAviones();

                // Comprueba que la opcion ingresada sea acorde a las aviones disponibles
                do{
                    opcion = Keyin.inInt("Opcion: ");
                    if (opcion < 1 || opcion > aviones)
                        System.out.println("Opcion invalida.");
                }while (opcion < 1 || opcion > aviones);*/

                // Guarda el avion en el vuelo

                company.registrarAvionEnVuelo(vuelo, opcion);

                // Comprueba que los pasajeros no se pasen de la capacidad del avion
                System.out.println("Indique el total de pasajes que desea reservar");
                do{
                    pasajeros = Keyin.inInt("Pasajeros: ");
                    if (pasajeros > vuelo.getAvion().getCapacidadMaxPasajeros())
                        System.out.println("El avion elegido no cuenta con esa capacidad de pasajeros.");
                }while (pasajeros > vuelo.getAvion().getCapacidadMaxPasajeros());

                // Se guardan los pasajeros del vuelo
                vuelo.setCantPasajeros(pasajeros);

                // Calculando costo total con la distancia
                vuelo.setDistances();

                int distancia = vuelo.getDistance(vuelo.getOrigen().getNombre(), vuelo.getDestino().getNombre());
                System.out.println(distancia);

                double costoTotal = vuelo.calcularCosto(vuelo.getAvion(), vuelo.getCantPasajeros(), distancia);

                System.out.println("Costo total del vuelo: $" + (int)costoTotal);

                vuelo.setCostoTotal(costoTotal);


            case 2:
                System.out.println("Opcion 2 seleccionada");
                break;
            case 3:

                System.out.println("Gracias por confiar en nosotros. Mucha suerte en estos tiempos dificiles. BUEN VIAJE");
                break;
            default:
                System.out.println("Esa opción no es válida. Por favor, ingrese una opción válida.");
                break; // This break is not really necessary*/

        }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                archivoCompañia.escribirArchivoCompañia2(company);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
