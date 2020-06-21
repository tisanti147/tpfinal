package Usuario;

import com.company.Avion;
import com.company.Bronce;
import Usuario.Provincia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vuelo {
    private int idVuelo;
    private static int contador = 0;
    private String fecha;
    private Avion avion;
    private int cantPasajeros;
    private double costoTotal;
    private Provincia origen;
    private Provincia destino;
    private Map<String, Integer> distanciaVuelo = new HashMap<>();

    public Vuelo(){
        contador++;
        this.idVuelo = contador;
    }

    public Vuelo (String fecha, int cantPasajeros, Avion avion, double costoTotal, Provincia origen, Provincia destino){
        contador++;
        this.idVuelo = contador;
        this.fecha = fecha;
        this.cantPasajeros = cantPasajeros;
        this.avion = avion;
        this.costoTotal = costoTotal;
        this.origen = origen;
        this.destino = destino;
    }

    public void setAvion(Avion avion){
        this.avion = avion;
    }

    public Avion getAvion(){
        return this.avion;
    }

    @Override
    public String toString(){
        return "\nID del vuelo: " + getIdVuelo() + "\nFecha del vuelo: " + getFecha() + "\nPasajeros que abordan: " + getCantPasajeros() + "\nLugar de origen: " + getOrigen().getNombre() + "\nLugar de destino: " + getDestino().getNombre() + "\n\nINFORMACIÓN DEL AVIÓN:\n" + avion.toString() + "\n\nCosto total: " + getCostoTotal();
    }

    public void setDistances(){
        this.distanciaVuelo.put("Buenos Aires Cordoba",695);
        this.distanciaVuelo.put("Buenos Aires Santiago de Chile",1400);
        this.distanciaVuelo.put("Buenos Aires Montevideo",950);
        this.distanciaVuelo.put("Cordoba Montevideo",1190);
        this.distanciaVuelo.put("Cordoba Santiago de Chile",1050);
        this.distanciaVuelo.put("Montevideo Santiago de Chile",2100);
    }

    public int getDistance(String origin, String destiny){
        int distance=((distanciaVuelo.containsKey(origin+" "+destiny))? distanciaVuelo.get(origin+" "+destiny) :
                (distanciaVuelo.containsKey(destiny+" "+origin))? distanciaVuelo.get(destiny+" "+origin) : 0);
        return distance;
    }

    //(Cantidad de kms * Costo del km) + (cantidad de pasajeros * 3500) + (Tarifa del tipo de avión)

    public int calcularCosto (Avion avion, int pasajeros, int distancia){
        return (distancia * avion.getCostoPorKM()) + (pasajeros * 3500) + avion.getTarifaAvion();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Provincia getOrigen() {
        return origen;
    }

    public void setOrigen(Provincia origen) {
        this.origen = origen;
    }

    public Provincia getDestino() {
        return destino;
    }

    public void setDestino(Provincia destino) {
        this.destino = destino;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    // cancelarVuelo
}





