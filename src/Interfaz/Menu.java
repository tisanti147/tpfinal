package Interfaz;

import Usuario.Provincia;
import Usuario.Vuelo;
import com.company.Avion;
import com.company.Compañia;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private int swValue;
    private int origen;
    private int destino;
    private int pasajeros;
    private Provincia originProv;
    private Provincia destinationProv;
    //private String fecha;
    //private Compañia company;

    public Menu(){

    }

    // Switch construct
    public void ejecutarMenu(Vuelo vuelo, Compañia company){
        int IdAvion = 0;
        int aviones;
        String fecha;
        Scanner sc = new Scanner(System.in);
        ArrayList<Avion> listaAviones = new ArrayList<Avion>();


        System.out.println("|   MENU SELECTION DEMO    |");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Reservar pasaje       |");
        System.out.println("|        2. Registrarse       |");
        System.out.println("|        3. Exit           |");
        swValue = Keyin.inInt(" Seleccionar opcion: ");

        switch (swValue) {
            case 1:
                System.out.println("Indicar fecha");
                System.out.println("Fecha: ");

                fecha = sc.nextLine();

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

                System.out.println("Ingrese la cantidad de pasajeros que abordaran");
                do {
                    pasajeros = Keyin.inInt("Pasajeros: ");
                    listaAviones = company.getAvionesDisponiblesFecha(fecha, pasajeros);
                    if (listaAviones.size() == 0)
                        System.out.println("No tenemos aviones disponibles con esa capacidad de pasajeros.");
                }while (listaAviones.size() == 0);

                System.out.println("Aviones disponibles: ");
                for (Avion avion: listaAviones){
                    System.out.println(avion.toString());
                }

                System.out.println("Ingrese el ID del avion que desea abordar");
                aviones = company.getListaAviones();

                do{
                    IdAvion = Keyin.inInt("Ingrese ID del avion: ");
                    if (company.comprobarIdAvion(IdAvion, fecha))
                        System.out.println("El avion con esa ID no está disponible en la fecha ingresada");
                    if (IdAvion < 1 || IdAvion > aviones)
                        System.out.println("No existen aviones con esa numero de ID");
                }while (company.comprobarIdAvion(IdAvion, fecha) || IdAvion < 1 || IdAvion >aviones);

                // Registrando avion en el vuelo
                company.registrarAvionEnVuelo(vuelo, IdAvion);

                // Calculando costo total con la distancia
                vuelo.setDistances();

                int distancia = vuelo.getDistance(vuelo.getOrigen().getNombre(), vuelo.getDestino().getNombre());
                System.out.println(distancia);

                double costoTotal = vuelo.calcularCosto(vuelo.getAvion(), vuelo.getCantPasajeros(), distancia);

                System.out.println("Costo total del vuelo: " + costoTotal);

                vuelo.setCostoTotal(costoTotal);

            case 2:
                System.out.println("Ingrese sus datos personales: ");
                break;
            /*case 3:
                System.out.println("Exit selected");
                break;
            case 4:
                System.out.println("Probando");
            default:
                System.out.println("Invalid selection");
                break; // This break is not really necessary*/
        }
    }

}
