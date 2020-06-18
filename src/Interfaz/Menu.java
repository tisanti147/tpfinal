package Interfaz;

import Usuario.Provincia;
import Usuario.Vuelo;
import com.company.Compañia;

public class Menu {
    private int swValue;
    private int origen;
    private int destino;
    private Provincia originProv;
    private Provincia destinationProv;
    private String fecha;
    //private Compañia company;

    public Menu(){

    }

    // Switch construct
    public void ejecutarMenu(Vuelo vuelo, Compañia company){
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

                company.getListaAviones();

                // Se guardan los pasajeros del vuelo
                System.out.println("Indique el total de pasajes que desea reservar");
                vuelo.setCantPasajeros(Keyin.inInt("Pasajeros: "));

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
