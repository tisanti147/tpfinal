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
import java.util.HashSet;
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

    // No es necesario buscar un usuario por DNI

    /*public Usuario buscarUsuario(int dni) throws IOException {
        List<User> userList =readListUserFile();
        User newUser = new User(document);
        newUser=checkExistence(userList,newUser);
        return newUser
        List<Usuario> listaUsuario = readListUserFile();
        nuevoUsuario=existeUsuario(listaUsuario, nuevoUsuario);
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

    //UsuarioVuelo y VueloCompañia no son necesarios por ahora

/* //Traigo objeto de tipo Vuelo, si es UsuarioVuelo, llama al método de escritura de Usuarios
    //Si es de tipo VueloCompañia, llama al método de escritura de datos en Compañia

    public void guardarDatosVuelo(Usuario usuario, Vuelo vuelo) throws IOException {
        if (vuelo instanceof UsuarioVuelo)
        {
            agregarVueloAUsuario(usuario, (UsuarioVuelo)vuelo);
        }
        if (vuelo instanceof VueloCompañia)
        {
            escribirArchivoCompañia(vuelo);
        }
    }

*/

    public Compañia leerArchivoCompañia() throws JsonParseException, JsonMappingException, IOException {
        Compañia compania = mapper.readValue(FileCompany, Compañia.class);
        compania.getListaUsuario();
        compania.getListaAviones();
        compania.getListaVuelos();
        //System.out.println(compania.toString());
        return compania;
    }

    //Metodos de DATOS DE COMPAÑIA, recibe un Object que busca en la base de datos de Compañia.
    //Se ve el tipo de objeto que es y se agrega a la lista correspondiente de la Compañia
  /*  public void escribirArchivoCompañia(Object obj) throws JsonGenerationException, JsonMappingException, IOException {

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
        mapper.writeValue(FileCompany,compania);
    }

*/
    private void escribirArchivoCompañia2(Object obj) throws JsonGenerationException, JsonMappingException, IOException{
        Compañia compania = leerArchivoCompañia();
        if(obj instanceof VueloCompañia){
            compania.addVueloCompañia((VueloCompañia) obj);
        }
        if(obj instanceof Usuario){
            compania.addUsuario((Usuario) obj);
        }
        if(obj instanceof Avion){
            compania.addAvion((Avion) obj);
        }
        mapper.writeValue(FileCompany,compania);
    }







    //USUARIOVUELO, escritura y lectura
/*
    private void escribirArchivoUsuarioVuelo(Vuelo vuelo) throws JsonGenerationException, JsonMappingException, IOException{
        mapper.writeValue(FileUserflight,vuelo);
    }

    private Vuelo leerArchivoUsuarioVuelo() throws JsonParseException, JsonMappingException, IOException {
        Vuelo vuelo = mapper.readValue(FileUserflight, Vuelo.class);
        System.out.println(vuelo.toString());
        return vuelo;
    }
*/

    //trae al nuevo usuario, lo agrega a la lista de usuarios de la compañia, lo agrega en el archivo de usuarios
    public void guardarNuevoUsuario(Usuario nuevoUsuario) throws IOException {

        escribirArchivoCompañia2(nuevoUsuario);
        //escribirArchivoUsuario(nuevoUsuario);
        List<Usuario> listaUsuario = leerArchivoListadeUsuarios();
        listaUsuario.add(nuevoUsuario);
        escribirArchivoListadeUsuarios(listaUsuario);
    }

    //metodo para agregar un vuelo a la lista de vuelos de un usuario
 /*   public void agregarVueloAUsuario(UsuarioVuelo vuelo) throws IOException {
        Usuario usuario = leerArchivoUsuario();
        usuario.addVuelo(vuelo);
        escribirArchivoUsuario(usuario);

    }
*/
    public void agregarVueloAlUsuario2(Usuario usuario, UsuarioVuelo vuelo) throws IOException {
        List<Usuario> listaUsuario = leerArchivoListadeUsuarios();
        for (Usuario usuarioAgregar : listaUsuario) {
            if(usuarioAgregar.getDni()==usuario.getDni())
            {
                usuarioAgregar.addVuelo(vuelo);
            }
        }
        escribirArchivoUsuario(listaUsuario);
    }


    // Aca cambie el tipo de dato q devuelve, este metodo tiene q devolver la lista de usuarios
    private Usuario leerArchivoUsuario() throws JsonParseException, JsonMappingException, IOException {
        Usuario usuario = mapper.readValue(fileUser, Usuario.class);
        System.out.println(usuario.toString());
        return usuario;
    }


    private void escribirArchivoUsuario(List<Usuario> listaUsuario) throws JsonGenerationException, JsonMappingException, IOException {
        mapper.writeValue(fileUser,listaUsuario);
    }

//ARCHIVO LISTA DE USUARIOS

    //guarda la lista de usuarios
    private void escribirArchivoListadeUsuarios(List<Usuario> listaUsuarios ) throws JsonGenerationException, JsonMappingException, IOException {
        mapper.writeValue(fileUser,listaUsuarios);
    }

    //lee lista en json y la devuelve, cuando la devuelve se puede buscar un usuario en esa lista que devuelve
    private List<Usuario> leerArchivoListadeUsuarios() throws JsonParseException, JsonMappingException, IOException {
        List<Usuario> usuarios =mapper.readValue(fileUser, List.class);
        System.out.println(usuarios.toString());
        return usuarios;
    }

/*    //ARCHIVO VUELO
    // se le pasa el Hastset de Plane y crea el archivo json de plane , escribe el hastset de plane en json
    private void escribirArchivoVuelo(HashSet<Avion> avionHashSet) throws JsonGenerationException, JsonMappingException, IOException{
        mapper.writeValue(filePlane,avionHashSet);
    }

    private HashSet<Vuelo> leerArchivoVuelo() throws JsonParseException, JsonMappingException, IOException {
        HashSet<Vuelo> vueloHashSet = mapper.readValue(filePlane, HashSet.class);
        System.out.println();//hay que pasarle el tostring
        return vueloHashSet;
    }
*/

}
