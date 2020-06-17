package Usuario;

public enum Provincia {

    BSAS ("Buenos Aires"),
    CORDOBA ("Cordoba"),
    SANTIAGO ("Santiago de Chile"),
    MONTEVIDEO ("Montevideo");

    private String nombre;

    private Provincia (String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
