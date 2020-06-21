package Interfaz;

import Usuario.Provincia;
import Usuario.Usuario;
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

    public Menu(){

    }

    // Switch construct
    public void ejecutarMenu(/*Vuelo vuelo, */Compañia company/*, Usuario user*/){
        int IdAvion = 0;
        int aviones;
        long dni;
        int idVuelo;
        String fecha;
        Scanner scDNI = new Scanner(System.in);
        Scanner scFecha = new Scanner(System.in);
        ArrayList<Avion> listaAviones = new ArrayList<Avion>();
        Vuelo vuelo = new Vuelo();
        Usuario user = null;


        System.out.println("|          AERTOTAXI          |");
        System.out.println("|  1. Reservar pasaje         |");
        System.out.println("|  2. Registrarse             |");
        System.out.println("|  3. Cancelar vuelo          |");
        System.out.println("|  4. Mostrar vuelos          |");
        System.out.println("|  5. Informacion de usuario  |");
        swValue = Keyin.inInt(" Seleccionar opcion: ");

        switch (swValue) {
            case 1:
                System.out.println("Ingrese su DNI: ");
                do{
                    dni = scDNI.nextLong();
                    user = company.getUsuarioDNI(dni);
                    if (user == null)
                        System.out.println("No hay usuario registrado con ese DNI");
                } while (user == null);

                System.out.println("Indicar fecha");
                System.out.println("Fecha: ");

                fecha = scFecha.nextLine();

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

                // Se guarda el destino del vuelo
                vuelo.setDestino(destinationProv);

                // Comprueba que haya un avion con la capacidad de pasajeros ingresados

                System.out.println("Ingrese la cantidad de pasajeros que abordaran");
                do {
                    pasajeros = Keyin.inInt("Pasajeros: ");
                    listaAviones = company.getAvionesDisponiblesFecha(fecha, pasajeros);
                    if (listaAviones.size() == 0)
                        System.out.println("No tenemos aviones disponibles con esa capacidad de pasajeros.");
                }while (listaAviones.size() == 0);

                // Guarda los pasajeros en el vuelo
                vuelo.setCantPasajeros(pasajeros);

                // Muestra los aviones disponibles tomando en cuenta la fecha
                System.out.println("Aviones disponibles: ");
                for (Avion avion: listaAviones){
                    System.out.println(avion.toString());
                }

                // El usuario ingresa el ID del avion que quiere reservar
                System.out.println("Ingrese el ID del avion que desea abordar");
                aviones = company.getListaAviones(); // Esto comprueba la cantidad de aviones que hay

                // Comprueba que el ID ingresado no sea de un avion que no existe o que ya esta reservado
                do{
                    IdAvion = Keyin.inInt("Ingrese ID del avion: ");
                    if (company.comprobarIdAvion(IdAvion, fecha))
                        System.out.println("El avion con esa ID no está disponible en la fecha ingresada");
                    if (IdAvion < 1 || IdAvion > aviones)
                        System.out.println("No existen aviones con ese numero de ID");
                }while (company.comprobarIdAvion(IdAvion, fecha) || IdAvion < 1 || IdAvion >aviones);

                // Registrando avion en el vuelo
                company.registrarAvionEnVuelo(vuelo, IdAvion);

                // Calculando costo total con la distancia
                vuelo.setDistances();

                int distancia = vuelo.getDistance(vuelo.getOrigen().getNombre(), vuelo.getDestino().getNombre());
                System.out.println(distancia);

                double costoTotal = vuelo.calcularCosto(vuelo.getAvion(), vuelo.getCantPasajeros(), distancia);

                System.out.println("Costo total del vuelo: " + costoTotal);

                // Guardando el costo en el vuelo
                vuelo.setCostoTotal(costoTotal);

                // Guardando el vuelo en el usuario y la compañia
                user.addVuelo(vuelo);
                company.addVuelo(vuelo);

                break;
            case 2:
                // Pide los datos personales
                System.out.println("Ingrese sus datos personales: ");
                System.out.println("Nombre y apellido: ");
                String nombre = Keyin.inString();
                System.out.println("DNI: ");
                long DNI = scDNI.nextLong();
                int edad = Keyin.inInt("Edad: ");
                Usuario usuario = new Usuario(nombre, DNI, edad);

                // Guarda el usuario en la compañia
                company.addUsuario(usuario);
                break;
            case 3:
                System.out.println("Ingrese su DNI: ");

                // Comprueba que el DNI ingresado este registrado en algun usuario
                do{
                    dni = scDNI.nextLong();
                    user = company.getUsuarioDNI(dni);
                    if (user == null)
                        System.out.println("No hay usuario registrado con ese DNI");
                } while (user == null);

                // Muestra los vuelos cargados en el usuario
                System.out.println("Mostrando sus vuelos reservados");
                user.mostrarVuelos();

                // Comprueba que el ID ingresado pertenezca a algun vuelo
                do{
                    idVuelo = Keyin.inInt("Ingrese el ID del vuelo que desea cancelar");
                    if (user.getVueloConID(idVuelo) == null)
                        System.out.println("No hay vuelos que tengan ese ID");
                } while (user.getVueloConID(idVuelo) == null);

                // Elimina el vuelo en el arreglo de Usuario y Compañia
                user.cancelarVuelo(user.getVueloConID(idVuelo));
                company.cancelarVuelo(company.getVueloConID(idVuelo));

                break;
            case 4:
                System.out.println("Ingrese la fecha: ");
                ArrayList<Vuelo> aux = new ArrayList<Vuelo>();
                fecha = scFecha.nextLine();
                aux = company.getVuelosConFecha(fecha);
                if (aux.size() == 0) {
                    System.out.println("No hay vuelos programados para la fecha ingresada");
                    break;
                }
                else {
                    for (Vuelo flight: aux)
                        System.out.println(flight.toString());
                }
                break;
            case 5:
                System.out.println("Ingrese su DNI: ");
                dni = scDNI.nextLong();
                user = company.getUsuarioDNI(dni);
                if (user == null) {
                    System.out.println("No hay usuario registrado con ese DNI");
                    break;
                }
                System.out.println("1. Informacion: ");
                System.out.println("2. Gastos totales: ");
                System.out.println("3. Nivel de la cuenta: ");
                swValue = Keyin.inInt("Opcion: ");
                switch (swValue){
                    case 1:
                        System.out.println("Datos personales: ");
                        company.mostrarUsuarioDNI(dni);
                        break;
                    case 2:
                        System.out.println("Gastos totales: ");
                        System.out.println(user.getGastosTotales());
                        break;
                    case 3:
                        System.out.println("Membresía: " + user.mejorCategoria());
                        break;
                }
            default:
                System.out.println("Invalid selection");
                break; // This break is not really necessary
        }
    }

}
