package Usuario;

import com.company.Avion;

public class UsuarioVuelo extends Vuelo {
    private static int usuarioVueloContador=0;
    private int usuarioVueloID;
    private int pasajerosAcompañantes;

    public void UserFlight(){
        this.usuarioVueloContador++;
        this.usuarioVueloID=this.usuarioVueloContador;
        this.pasajerosAcompañantes=0;
    }

    public UsuarioVuelo(String fecha, int cantPasajeros, Avion avion, double costoTotal) {
        super(fecha, cantPasajeros, avion, costoTotal);
    }

    public int getPasajerosAcompañantes() {
        return pasajerosAcompañantes;
    }

    public void setPasajerosAcompañantes(int pasajerosAcompañantes) {
        this.pasajerosAcompañantes = pasajerosAcompañantes;
    }
}
