package Usuario;

import com.company.Avion;
import com.company.Bronce;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {

    private String fecha;
    private Avion avion;
    private int cantPasajeros;
    private double costoTotal;
    //HashSet <Provincia> origen;
    //HashSet <Provincia> destino;

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

    //(Cantidad de kms * Costo del km) + (cantidad de pasajeros * 3500) + (Tarifa del tipo de avión)

    public int calcularCosto (Avion avion, int pasajeros, int distancia){
        return (distancia * avion.getCostoPorKM()) + (pasajeros * 3500) + avion.getTarifaAvion();
    }

    // cancelarVuelo
}





