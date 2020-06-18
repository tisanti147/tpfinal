package Usuario;

import com.company.Avion;

import java.util.List;

public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private long dni;
    private int edad;
    private Cliente infoVuelo;
    private static int contadorUsuario=0;

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


    public Usuario(/*int id, */String nombre, String apellido, long dni, int edad, Cliente infoVuelo) {
        this.contadorUsuario++;
        this.id = contadorUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.infoVuelo = infoVuelo;
    }

    @Override
    public String toString(){
        return "ID de usuario: " + getId() + "\nNombre y apellido: " + getNombre() + getApellido() + "\nEdad: " + getEdad() + "\nCategoria mas alta: ";
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }
}