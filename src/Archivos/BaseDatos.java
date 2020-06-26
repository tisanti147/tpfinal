package Archivos;
import com.company.Empresa;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class BaseDatos {

    private static final ObjectMapper mapper = new ObjectMapper();  //Create ObjectMapper object. It is a reusable object. provides functionality for reading and writing JSON

    public BaseDatos() {
    }

    public static Empresa levantarCompania() {
        String path = "Empresa.json";
        Empresa company = new Empresa("Aerolineas Coronarias");
        File archivo = new File(path);
        try {
            if(!archivo.exists()) {
                System.out.println("No existe base de datos previa de la compañía.");
            }
            else {
                //Creamos un ArrayList de cada objeto dentro de la compania para extraerlos de forma separada del archivo, al final
                //se insertan todos dentro de la empresa.
                Empresa empresa = mapper.readValue(new File("Empresa.json"),  new TypeReference<Empresa>(){});
                //company = empresa;
                company.setListaAviones(empresa.getListaAviones());
                company.setListaUsuario(empresa.getListaUsuario());
                company.setListaVuelos(empresa.getListaVuelos());

                System.out.println("Base de datos leida y cargada con exito.\n");
            }

        } catch (IOException e) {
            System.out.println("Error 505. No se pudo leer el archivo \n");
            e.printStackTrace();
        }
        return company;
    }

    public static void guardarCompania(Empresa company) {
        String path = "Empresa.json";
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