package Archivos;
import com.company.Compañia;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class BaseDatos {

    private static final ObjectMapper mapper = new ObjectMapper();  //Create ObjectMapper object. It is a reusable object. provides functionality for reading and writing JSON

    public BaseDatos() {
    }

    public static Compañia levantarCompania() {
        String path = "Compañia.json";
        Compañia company = new Compañia("Aerolineas Coronarias");
        File archivo = new File(path);
        try {
            if(!archivo.exists()) {
                System.out.println("No existe base de datos previa de la compañía.");
            }
            else {
                //Creamos un ArrayList de cada objeto dentro de la compania para extraerlos de forma separada del archivo, al final
                //se insertan todos dentro de la compañia.
                Compañia compañia= mapper.readValue(new File("Compañia.json"),  Compañia.class );
                company = compañia;

                System.out.println("Base de datos leida y cargada con exito.\n");
            }

        } catch (IOException e) {
            System.out.println("Error 505. No se pudo leer el archivo \n");
            e.printStackTrace();
        }
        return company;
    }

    public static void guardarCompania(Compañia company) {
        String path = "Compañia.json";
        File archivoviejo = new File(path);
        archivoviejo.delete();
        File archivodb = new File(path);
        try {
            mapper.writeValue(archivodb, company);
            System.out.println("Datos de la compañia actualizados y guardados \n");
        } catch (IOException e) {
            System.out.println("No se pudo leer la base de datos");
            e.printStackTrace();
        }
    }

}