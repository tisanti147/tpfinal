package com.company;

import Usuario.Usuario;
import Usuario.Provincia;
import Usuario.Vuelo;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.Serializable;
import java.util.ArrayList;

public class Compañia implements Serializable {
    private String nombre;
    private ArrayList<Avion> ListaAviones;
    private ArrayList<Usuario> ListaUsuario;
    private ArrayList<Vuelo> ListaVuelos;

    public Compañia(String nombre) {
        this.nombre = nombre;
        ListaAviones = new ArrayList<Avion>();
        ListaUsuario = new ArrayList<Usuario>();
        ListaVuelos = new ArrayList<Vuelo>();
    }


    // Uso contador para registrar la cantidad de opciones que va a tener el usuario cuando use el menu
    public int cantListaAviones() {
        int contador = 0;
        for (Avion avioncito : ListaAviones) {
            contador++;
        }
        return contador;
    }

    public void mostrarListaAviones() {
        for (Avion avioncito : ListaAviones) {
            System.out.println(avioncito.toString());
        }
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

    public boolean comprobarIdAvionFecha(int id, String fecha){
        for (Vuelo vuelo: ListaVuelos){
            if(fecha.equals(vuelo.getFecha()) && id == vuelo.getAvion().getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean comprobarAvionPasajeros(ArrayList<Avion> lista, int ID){
        for (Avion avion: lista){
            if (ID == avion.getId())
                return true;
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

    public void mostrarListaUsuario() {
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

    public void mostrarListaVuelos() {
        for (Vuelo vuelito : ListaVuelos) {
            System.out.println(vuelito.toString());
        }
    }

    public void addVuelo(Vuelo vuelo){
        this.ListaVuelos.add(vuelo);
    }

    public Vuelo getVueloConID(int id){
        Vuelo aux = null;//new Vuelo();
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Avion> getListaAviones() {
        return ListaAviones;
    }

    public ArrayList<Usuario> getListaUsuario() {
        return ListaUsuario;
    }

    public ArrayList<Vuelo> getListaVuelos() {
        return ListaVuelos;
    }

    public void setListaAviones(ArrayList<Avion> listaAviones) {
        ListaAviones = listaAviones;
    }

    public void setListaVuelos(ArrayList<Vuelo> listaVuelos) {
        ListaVuelos = listaVuelos;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        ListaUsuario = listaUsuario;
    }
}
