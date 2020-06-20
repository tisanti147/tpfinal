package Interfaz;

import Usuario.Provincia;
import Usuario.Vuelo;
import com.company.Avion;
import com.company.Compañia;

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
        int opcion = 0;
        String fecha;

        System.out.println("|   MENU SELECTION DEMO    |");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Reservar pasaje       |");
        System.out.println("|        2. Option 2       |");
        System.out.println("|        3. Exit           |");
        swValue = Keyin.inInt(" Seleccionar opcion: ");

        switch (swValue) {
            case 1:
                System.out.println("Indicar fecha");
                System.out.println("Fecha: ");
                fecha = Keyin.inString();

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
                // Falta comprobar la disponibilidad en la fecha que ingresa el usuario
                // Seguramente esto ultimo haga conflicto con la variable ID que agregue en la clase Avion

                System.out.println(fecha);
                company.mostrarAvionesDisponibles(fecha);

                //int aviones = company.getListaAviones();
                System.out.println("Elija el avion para su vuelo: ");

                // Comprueba que la opcion ingresada sea acorde a las aviones disponibles
                /*do{
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

                System.out.println("Costo total del vuelo: " + costoTotal);

                vuelo.setCostoTotal(costoTotal);

            /*case 2:
                System.out.println("Option 2 selected");
                break;
            case 3:
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
