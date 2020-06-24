package Usuario;

import com.company.Bronce;
import com.company.Oro;
import com.company.Plata;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

    private int id;
    private String nombre;
    private long dni;
    private int edad;
    private ArrayList<Vuelo> listaVuelos;
    private static int contadorUsuario = 0;

    public Usuario() {
    }

    public Usuario(String nombre, long dni, int edad) {
        this.id = contadorUsuario;
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        listaVuelos = new ArrayList<Vuelo>();
    }

    @Override
    public String toString(){
        return "\nID de usuario: " + getId() + "\nNombre y apellido: " + getNombre() + "\nDNI: " + getDni() + "\nEdad: " + getEdad();
    }

    public void addVuelo(Vuelo vuelo){
        this.listaVuelos.add(vuelo);
    }

    public void mostrarVuelos(){
        if(listaVuelos !=null) {
            for (Vuelo vuelo : listaVuelos)
                if(vuelo.getUsuario().getNombre() == getNombre())
                    System.out.println(vuelo.toString());
        }else{
            System.out.println("No tenes ningun vuelo reservado");
        }
    }

    public ArrayList<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    public Vuelo getVueloConID(int id){
        Vuelo aux = null;
        for (Vuelo vuelo: listaVuelos) {
            if (vuelo.getIdVuelo() == id)
                aux = vuelo;
        }
        return aux;
    }

    public void cancelarVuelo(Vuelo vuelo){
        listaVuelos.remove(vuelo);
    }


    public String mejorCategoria(){
        String categoria = null;
        int nivel = 0;
        for (Vuelo vuelo: listaVuelos){
            if (vuelo.getAvion() instanceof Bronce && nivel < 2) {
                categoria = "Bronce";
                nivel = 1;
            }
            if (vuelo.getAvion() instanceof Plata && nivel < 3) {
                categoria = "Plata";
                nivel = 2;
            }
            if (vuelo.getAvion() instanceof Oro) {
                categoria = "Oro";
                nivel = 3;
            }
        }
        return categoria;
    }

    public int gastosTotales(){
        int gastos = 0;
        for (Vuelo vuelo: listaVuelos){
            gastos += vuelo.getCostoTotal();
        }
        return gastos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }
}