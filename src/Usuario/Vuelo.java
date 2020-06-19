package Usuario;

import com.company.Avion;
import com.company.Bronce;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vuelo {

    private String fecha;
    private Avion avionCategoria;
    private int cantPasajeros;
    private double costoTotal;
    private Map<String, Integer> distanciaVuelo = new HashMap<>();

    public Vuelo() {

    }

    public Vuelo(String fecha, int cantPasajeros, Avion avionCategoria, double costoTotal) {
        this.fecha = fecha;
        this.cantPasajeros = cantPasajeros;
        this.avionCategoria = avionCategoria;
        this.costoTotal = costoTotal;

    }

    @Override
    public String toString() {
        return "Fecha del vuelo: " + getFecha() + "\nPasajeros que abordan: " + getCantPasajeros() + "\n\nINFORMACIÓN DEL AVIÓN:\n" + avionCategoria.toString() + "\n\nCosto total: " + getCostoTotal();
    }

    public String getFecha() {
        return fecha;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public Avion getAvionCategoria() { return avionCategoria; }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setDistances() {
        this.distanciaVuelo.put("Buenos Aires Cordoba", 695);
        this.distanciaVuelo.put("Buenos Aires Santiago de Chile", 1400);
        this.distanciaVuelo.put("Buenos Aires Montevideo", 950);
        this.distanciaVuelo.put("Cordoba Montevideo", 1190);
        this.distanciaVuelo.put("Cordoba Santiago de Chile", 1050);
        this.distanciaVuelo.put("Montevideo Santiago de Chile", 2100);
    }

    public int getDistancia(String origen, String destino) {
        int distancia = ((distanciaVuelo.containsKey(origen + " " + destino)) ? distanciaVuelo.get(origen + " " + destino) :
                (distanciaVuelo.containsKey(destino + " " + origen)) ? distanciaVuelo.get(destino + " " + origen) : 0);
        return distancia;
    }

    //(Cantidad de kms * Costo del km) + (cantidad de pasajeros * 3500) + (Tarifa del tipo de avión)

    public int calcularCosto(Avion avion, int pasajeros, int distancia) {
        return (distancia * avion.getCostoPorKM()) + (pasajeros * 3500) + avion.getTarifaAvion();
    }

    // cancelarVuelo

}