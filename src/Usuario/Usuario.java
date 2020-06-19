package Usuario;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private int edad;
    private Cliente infoVuelo;
    private List<UsuarioVuelo> listaVuelos;
    private static int contadorUsuario=0;


    public Usuario()
    {
        this.contadorUsuario++;
        this.id=contadorUsuario;
        this.nombre="";
        this.apellido="";
        this.dni=0;
        this.edad=0;
        this.listaVuelos=new ArrayList<>();
    }


    public Usuario(Cliente client)
    {
        this.contadorUsuario++;
        this.id=contadorUsuario;
        this.nombre="";
        this.apellido="";
        this.dni=0;
        this.edad=0;
        this.infoVuelo=client;
    }

    public Usuario(int dni)
    {
        this.contadorUsuario++;
        this.id=contadorUsuario;
        this.nombre="";
        this.apellido="";
        this.dni=dni;
        this.edad=0;
        this.infoVuelo=null;
        this.listaVuelos=new ArrayList<>();
    }


    public Usuario(int id, String nombre, String apellido, int dni, int edad, Cliente infoVuelo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.infoVuelo = infoVuelo;
    }
}

    public Usuario(String nombre, String apellido, int dni, int edad)
    {
        this.contadorUsuario++;
        this.id=contadorUsuario;
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.edad=edad;
        this.listaVuelos=new ArrayList<>();
    }

    public void agregarVuelo(UsuarioVuelo userFlight){
        this.listaVuelos.add(userFlight);
    }

    public int getId() {
        return id;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Usuario.Cliente getInfoVuelo() {
        return infoVuelo;
    }

    public void setInfoVuelo(Usuario.Cliente infoVuelo) {
        this.infoVuelo = infoVuelo;
    }

    public List<Usuario.UsuarioVuelo> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(List<Usuario.UsuarioVuelo> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    public static int getContadorUsuario() {
        return contadorUsuario;
    }

    public static void setContadorUsuario(int contadorUsuario) {
        Usuario.contadorUsuario = contadorUsuario;
    }
}
