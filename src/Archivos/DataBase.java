package Archivos;
import Usuario.*;
import com.company.Avion;
import com.company.Compañia;
import com.company.VueloCompañia;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class DataBase {

    private static ObjectMapper mapper = new ObjectMapper();
    private File fileUser = new File("Usuario.json");
    private File filePlane = new File("Avion.json");
    private File FileUserflight = new File("UsuarioVuelo.json");
    private File FileCompanyflight = new File("CompaniaVuelo.json");
    private File FileCompany = new File("Compania.json");


    public DataBase(){};

    //METODOS DE BUSQUEDA, EXISTENCIA Y GUARDADO

    //trae Lista de Usuarios, compara por DNI los usuarios de la lista. Si encuentra coincidencia, devuelve el usuario con sus datos
    //sino devuelve el Objetoc on el DNI asignado para crear un NUEVO USUARIO

    /*public Usuario buscarUsuario(int dni){
        List<Usuario> listaUsuario = null;
        try {
            listaUsuario = leerArchivoUsuario(); //CAMBIAR
        } catch (IOException e) {
            e.printStackTrace();
        }
        Usuario nuevoUsuario = new Usuario(dni);
        nuevoUsuario = existeUsuario(listaUsuario,nuevoUsuario);
        return nuevoUsuario;
    }*/

    //Compara Usuarios por DNI
    private Usuario existeUsuario(List<Usuario> listaUsuario, Usuario nuevoUsuario){
        for (Usuario usuarioGuardado : listaUsuario) {
            if(nuevoUsuario.getDni()==usuarioGuardado.getDni()){
                nuevoUsuario=usuarioGuardado;
            }
        }
        return nuevoUsuario;
    }

 //Traigo objeto de tipo Vuelo, si es UsuarioVuelo, llama al método de escritura de Usuarios
    //Si es de tipo VueloCompañia, llama al método de escritura de datos en Compañia
    /*
    public void guardarDatosVuelo(Vuelo vuelo) throws IOException {
        if (vuelo instanceof Vuelo)
        {
            escribirArchivoUsuarioVuelo(vuelo);
            agregarVueloAUsuario((Usuario)vuelo);
        }
        if (vuelo instanceof Vuelo)
        {
            escribirArchivoCompañia(vuelo);
        }
    }
*/

     //Metodos de DATOS DE COMPAÑIA, recibe un Object que busca en la base de datos de Compañia.
    //Se ve el tipo de objeto que es y se agrega a la lista correspondiente de la Compañia
    private void escribirArchivoCompañia(Object obj) throws JsonGenerationException, JsonMappingException, IOException {

        Compañia compania = leerArchivoCompañia();

        if(obj instanceof Vuelo){
            compania.addVuelo((Vuelo) obj);
        }
        if(obj instanceof Usuario){
            compania.addUsuario((Usuario) obj);
        }
        if(obj instanceof Avion){
            compania.addAvion((Avion) obj);
        }
        mapper.writerWithDefaultPrettyPrinter().writeValue(FileCompany,compania);
    }


    private Compañia leerArchivoCompañia() throws JsonParseException, JsonMappingException, IOException {
        Compañia compania = mapper.readValue(FileCompany, Compañia.class);
        System.out.println(compania.toString());
        return compania;
    }


    //USUARIOVUELO, escritura y lectura

    private void escribirArchivoUsuarioVuelo(Vuelo vuelo) throws JsonGenerationException, JsonMappingException, IOException{
        mapper.writerWithDefaultPrettyPrinter().writeValue(FileUserflight,vuelo);
    }

    private Vuelo leerArchivoUsuarioVuelo() throws JsonParseException, JsonMappingException, IOException {
        Vuelo vuelo = mapper.readValue(FileUserflight, Vuelo.class);
        System.out.println(vuelo.toString());
        return vuelo;
    }


   //trae al nuevo usuario, lo agrega a la lista de usuarios de la compañia, lo agrega en el archivo de usuarios
    public void guardarNuevoUsuario(Usuario nuevoUsuario) throws IOException {

        escribirArchivoCompañia(nuevoUsuario);
        escribirArchivoUsuario(nuevoUsuario);
    }

      //metodo para agregar un vuelo a la lista de vuelos de un usuario
    public void agregarVueloAUsuario(UsuarioVuelo vuelo) throws IOException {
        Usuario usuario = leerArchivoUsuario();
        usuario.addVuelo(vuelo);
        escribirArchivoUsuario(usuario);

    }


    // Aca cambie el tipo de dato q devuelve, este metodo tiene q devolver la lista de usuarios
    private Usuario leerArchivoUsuario() throws JsonParseException, JsonMappingException, IOException {
        Usuario usuario = mapper.readValue(fileUser, Usuario.class);
        System.out.println(usuario.toString());
        return usuario;
    }

    private void escribirArchivoUsuario(Usuario usuario) throws JsonGenerationException, JsonMappingException, IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(fileUser,usuario);
    }

//ARCHIVO LISTA DE USUARIOS
    private void escribirArchivoListadeUsuarios(List<Usuario> listaUsuarios ) throws JsonGenerationException, JsonMappingException, IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(fileUser,listaUsuarios);
    }

    private List<Usuario> leerArchivoListadeUsuarios() throws JsonParseException, JsonMappingException, IOException {
        List<Usuario> usuarios =mapper.readValue(fileUser, List.class);
        return usuarios;
    }

    private void writePlaneFile(Avion avion) throws JsonGenerationException, JsonMappingException, IOException{
        mapper.writerWithDefaultPrettyPrinter().writeValue(filePlane,avion);
    }

    private Vuelo readPlaneFile() throws JsonParseException, JsonMappingException, IOException {
        Vuelo vuelo = mapper.readValue(filePlane, Vuelo.class);
        System.out.println(vuelo.toString());
        return vuelo;
    }


}
