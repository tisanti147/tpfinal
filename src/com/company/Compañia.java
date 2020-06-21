package com.company;

import Usuario.Usuario;
import Usuario.Provincia;
import Usuario.Vuelo;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Compañia {
    private String nombre;
    private ArrayList<Avion> ListaAviones;
    private ArrayList<Usuario> ListaUsuario;
    //private List<Provincia> ListaProvincias;
    private ArrayList<Vuelo> ListaVuelos;

    public Compañia(String nombre/*List<Avion> listaAviones, List<Usuario> listaUsuario, List<Provincia> listaProvincias, List<Vuelo> listaVuelos*/) {
        this.nombre = nombre;
        ListaAviones = new ArrayList<Avion>();
        ListaUsuario = new ArrayList<Usuario>();
        //ListaProvincias = listaProvincias;
        ListaVuelos = new ArrayList<Vuelo>();
    }

    public String getNombre() {
        return nombre;
    }


    // Uso contador para registrar la cantidad de opciones que va a tener el usuario cuando use el menu
    public int getListaAviones() {
        int contador = 0;
        for (Avion avioncito : ListaAviones) {
            contador++;
            /*System.out.println(contador + ". ");
            System.out.println(avioncito.toString());*/
        }
        return contador;
    }

    public void registrarAvionEnVuelo(Vuelo vuelo, int id){
        for (Avion avion: ListaAviones){
            if (id == avion.getId())
                vuelo.setAvion(avion);
        }
    }

    public void addAvion(Avion avion){
        this.ListaAviones.add(avion);
    }

    public void mostrarAvionesDisponibles (String fecha){
        for (Vuelo vuelo: ListaVuelos){
            if(!fecha.equals(vuelo.getFecha()))
                System.out.println(vuelo.getAvion().toString());
        }
    }

    public boolean comprobarIdAvion(int id, String fecha){
        for (Vuelo vuelo: ListaVuelos){
            if(fecha.equals(vuelo.getFecha()) && id == vuelo.getAvion().getId()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Avion> getAvionesDisponiblesFecha(String fecha, int pasajeros){
        ArrayList<Avion> listaFecha = new ArrayList<Avion>();
        ArrayList<Avion> listaPasajeros = new ArrayList<Avion>();

        for (Vuelo vuelo: ListaVuelos){
            if (!fecha.equals(vuelo.getFecha()))
                listaFecha.add(vuelo.getAvion());
        }

        for (Avion avion: listaFecha){
            if (avion.getCapacidadMaxPasajeros() >= pasajeros)
                listaPasajeros.add(avion);
        }

        return listaPasajeros;
    }

    public void getListaUsuario() {
        for (Usuario user : ListaUsuario) {
            System.out.println(user.toString());
        }
    }

    public void mostrarUsuarioNombre(String nombre){
        for(Usuario user: ListaUsuario){
            if(user.getNombre().equals(nombre))
                System.out.println(user.toString());
        }
    }

    public void mostrarUsuarioDNI(long dni) {
        for (Usuario user : ListaUsuario) {
            if (user.getDni() == dni)
                System.out.println(user.toString());
        }
    }

    public Usuario getUsuarioDNI(long dni){
        Usuario aux = null;
        for (Usuario user: ListaUsuario){
            if(dni == user.getDni())
                aux = user;
        }
        return aux;
    }

    public void addUsuario(Usuario user){
        this.ListaUsuario.add(user);
    }

    /*public void getListaProvincias() {
        for (Provincia provincia : ListaProvincias) {
            System.out.println(provincia.toString());
        }
    }*/

    public void getListaVuelos() {
        for (Vuelo vuelito : ListaVuelos) {
            System.out.println(vuelito.toString());
        }
    }

    public void addVuelo(Vuelo vuelo){
        this.ListaVuelos.add(vuelo);
    }

    public Vuelo getVueloConID(int id){
        Vuelo aux = new Vuelo();
        for (Vuelo vuelo: ListaVuelos) {
            if (vuelo.getIdVuelo() == id)
                aux = vuelo;
        }
        return aux;
    }

    public ArrayList<Vuelo> getVuelosConFecha (String fecha){
        ArrayList<Vuelo> aux = new ArrayList<Vuelo>();
        for (Vuelo vuelo: ListaVuelos){
            if(fecha.equals(vuelo.getFecha()))
                aux.add(vuelo);
        }
        return aux;
    }

    public void mostrarVueloConFecha(String fecha){
        for (Vuelo vuelo: ListaVuelos){
            if(vuelo.getFecha().equals(fecha))
                System.out.println(vuelo.toString());
        }
    }

    public void cancelarVuelo(Vuelo vuelo){
        ListaVuelos.remove(vuelo);
    }

    //El metodo set de las listas para funcionar de forma optima, deberia tener una funcion que agregue la lista
    // de vuelos que le pases por parametro al final de la lista de vuelos existente ya dentro de la compania
    public void setListaVuelos(ArrayList<Vuelo> listaVuelos) {
        ListaVuelos = listaVuelos;
    }

    public void setListaAviones(ArrayList<Avion> listaAviones) {
        ListaAviones = listaAviones;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        ListaUsuario = listaUsuario;
    }

    /*public void setListaProvincias(List<Provincia> listaProvincias) {
        ListaProvincias = listaProvincias;
    }*/
}
