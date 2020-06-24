package Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Provincia {

    BSAS ("Buenos Aires", 1),
    CORDOBA ("Cordoba", 2),
    SANTIAGO ("Santiago de Chile", 3),
    MONTEVIDEO ("Montevideo", 4);

    private String nombre;
    private int num;

    private static Map map = new HashMap<>();

    private Provincia (String nombre, int num){
        this.nombre = nombre;
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    // Asigna un valor numerico a cada provincia para facilitar el menu.
    // Por eso hay una variable de num en la clase

    static {
        for (Provincia prov : Provincia.values()) {
            map.put(prov.num, prov);
        }
    }

    public static Provincia valueOf(int num) {
        return (Provincia) map.get(num);
    }
}
