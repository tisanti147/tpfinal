package Usuario;

import com.company.Avion;
import com.company.Bronce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vuelo {

    private String fecha;
    private Avion avion;
    private int cantPasajeros;
    private double costoTotal;
    private Map<String, Integer> distanciaVuelo = new HashMap<>();

    public Vuelo (String fecha, int cantPasajeros, Avion avion, double costoTotal){
        this.fecha = fecha;
        this.cantPasajeros = cantPasajeros;
        this.avion = avion;
        this.costoTotal = costoTotal;

    }

    @Override
    public String toString(){
        return "Fecha del vuelo: " + getFecha() + "\nPasajeros que abordan: " + getCantPasajeros() + "\n\nINFORMACIÓN DEL AVIÓN:\n" + avion.toString() + "\n\nCosto total: " + getCostoTotal();
    }

    public String getFecha() {
        return fecha;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    private void setDistances(){
        this.distanciaVuelo.put("Buenos Aires Cordoba",695);
        this.distanciaVuelo.put("Buenos Aires Santiago de Chile",1400);
        this.distanciaVuelo.put("Buenos Aires Montevideo",950);
        this.distanciaVuelo.put("Cordoba Montevideo",1190);
        this.distanciaVuelo.put("Cordoba Santiago de Chile",1050);
        this.distanciaVuelo.put("Montevideo Santiago de Chile",2100);
    }

    private int getDistance(String origin, String destiny){
        int distance=((distanciaVuelo.containsKey(origin+" "+destiny))? distanciaVuelo.get(origin+" "+destiny) :
                (distanciaVuelo.containsKey(destiny+" "+origin))? distanciaVuelo.get(destiny+" "+origin) : 0);
        return distance;
    }

    //(Cantidad de kms * Costo del km) + (cantidad de pasajeros * 3500) + (Tarifa del tipo de avión)

    public int calcularCosto (Avion avion, int pasajeros, int distancia){
        return (distancia * avion.getCostoPorKM()) + (pasajeros * 3500) + avion.getTarifaAvion();
    }

    // cancelarVuelo
}





