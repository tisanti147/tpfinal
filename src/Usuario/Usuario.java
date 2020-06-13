package Usuario;

public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private int age;
    private Cliente infoVuelo;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, int dni, int age, Cliente infoVuelo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.age = age;
        this.infoVuelo = infoVuelo;
    }
}
