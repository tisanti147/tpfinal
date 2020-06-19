package Usuario;

import com.company.Avion;
import com.company.VueloCompañia;

public class ValidacionServicio {

    //Validaciones de disponibilidad o capacidad de aviones

    public boolean validacionCiudad(String origen, String destino){  return (origen.equals(destino))? false : true; }

    public boolean capacidadVuelo(int acompañantes, VueloCompañia vuelo){
        return ((vuelo.getPasajerosVuelo()+acompañantes)<=vuelo.getAvionCategoria().getCapacidadMaxPasajeros())? true : false;
    }

    public boolean tipoDeVuelo(VueloCompañia flight, Avion avion){

        return (flight.getAvionCategoria().equals(avion));

    }

}
