package Usuario;

import com.company.Avion;
import com.company.Bronce;
import com.company.Oro;
import com.company.Plata;

import java.util.List;
import java.util.ArrayList;

public class Usuario {

    private int id;
    private String nombre;
    private long dni;
    private int edad;
    private ArrayList<Vuelo> listaVuelos;
    private static int contadorUsuario=0;

    public void addVuelo(Vuelo vuelo){
        this.listaVuelos.add(vuelo);
    }

    /*public Usuario() {
    }*/

    /*public Usuario(Cliente client)
    {
        this.contadorUsuario++;
        this.id=contadorUsuario;
        this.nombre="";
        this.apellido="";
        this.dni=0;
        this.edad=0;
        this.infoVuelo=client;
    }*/

    /*public Usuario(int dni)
    {
        this.contadorUsuario++;
        this.id=contadorUsuario;
        this.nombre="";
        this.apellido="";
        this.dni=dni;
        this.edad=0;
        this.infoVuelo=null;
    }*/


    public Usuario(/*int id, */String nombre, long dni, int edad) {
        this.contadorUsuario++;
        this.id = contadorUsuario;
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        listaVuelos = new ArrayList<Vuelo>();
    }

    @Override
    public String toString(){
        return "ID de usuario: " + getId() + "\nNombre y apellido: " + getNombre() + "\nDNI: " + getDni() + "\nEdad: " + getEdad() + "\nCategoria mas alta: ";
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public long getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public String mejorCategoria(){
        String categoria = "";
        for (Vuelo vuelo: listaVuelos){
            if (vuelo.getAvion() instanceof Bronce)
                categoria = "Bronce";
            if (vuelo.getAvion() instanceof Plata)
                categoria = "Plata";
            if (vuelo.getAvion() instanceof Oro)
                categoria = "Oro";
        }
        return categoria;
    }
}