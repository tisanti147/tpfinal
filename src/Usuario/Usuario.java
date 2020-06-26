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
    private static int contadorUsuario=0;

    public Usuario(){
        super();
    }

    public Usuario(String nombre, long dni, int edad) {
        this.contadorUsuario++;
        this.id = contadorUsuario;
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.listaVuelos = new ArrayList<Vuelo>();
    }

    public Usuario(String nombre, long dni, int edad, ArrayList<Vuelo> listaVuelos) {
        this.contadorUsuario++;
        this.id = contadorUsuario;
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.listaVuelos = listaVuelos;
    }

    public void addVuelo(Vuelo vuelo){
        this.listaVuelos.add(vuelo);
    }

    @Override
    public String toString(){
        return "\nID de usuario: " + getId() + "\nNombre y apellido: " + getNombre() + "\nDNI: " + getDni() + "\nEdad: " + getEdad();
    }

    public void mostrarVuelos(){
        for (Vuelo vuelo: listaVuelos)
            System.out.println(vuelo.toString());
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
            if (vuelo.getAvion().isConexionWifi()) {
                categoria = "Oro";
                nivel = 3;
            } else {
                if (vuelo.getAvion().getCostoPorKM() <= 200 && nivel < 2) {
                    categoria = "Bronce";
                    nivel = 1;
                } else if (nivel < 3){
                    categoria = "Plata";
                    nivel = 2;
                }
            }
        }
        return categoria;
    }

    public int gastosTotales(){
        int gastos = 0;
        for (Vuelo vuelo: listaVuelos){
            System.out.println(vuelo);
            gastos += vuelo.getCostoTotal();
        }
        return gastos;
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

    public ArrayList<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(ArrayList<Vuelo> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }
}