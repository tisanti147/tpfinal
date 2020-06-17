package com.company;

import Usuario.Usuario;
import Usuario.Provincia;
import Usuario.Vuelo;

import java.util.List;

public class Compañia {
    private String nombre;
    private List<Avion> ListaAviones;
    private List<Usuario> ListaUsuario;
    private List<Provincia> ListaProvincias;
    private List<Vuelo> ListaVuelos;


    public Compañia(String nombre){
        this.nombre = nombre;
    }

    public Compañia(String nombre, List<Avion> listaAviones, List<Usuario> listaUsuario, List<Provincia> listaProvincias, List<Vuelo> listaVuelos) {
        this.nombre = nombre;
        ListaAviones = listaAviones;
        ListaUsuario = listaUsuario;
        ListaProvincias = listaProvincias;
        ListaVuelos = listaVuelos;

    }

    public String getNombre() {
        return nombre;
    }

    public void getListaAviones() {
        for (Avion avioncito : ListaAviones) {
            System.out.println(avioncito.toString());
        }
    }

    public void getListaUsuario() {
        for (Usuario user : ListaUsuario) {
            System.out.println(user.toString());
        }
    }

    public void getListaProvincias() {
        for (Provincia provincia : ListaProvincias) {
            System.out.println(provincia.toString());
        }
    }

    public void getListaVuelos() {
        for (Vuelo vuelito : ListaVuelos) {
            System.out.println(vuelito.toString());
        }
    }

    //El metodo set de las listas para funcionar de forma optima, deberia tener una funcion que agregue la lista
    // de vuelos que le pases por parametro al final de la lista de vuelos existente ya dentro de la compania
    public void setListaVuelos(List<Vuelo> listaVuelos) {
        ListaVuelos = listaVuelos;
    }

    public void setListaAviones(List<Avion> listaAviones) {
        ListaAviones = listaAviones;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        ListaUsuario = listaUsuario;
    }

    public void setListaProvincias(List<Provincia> listaProvincias) {
        ListaProvincias = listaProvincias;
    }
}
