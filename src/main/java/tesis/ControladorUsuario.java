package tesis;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by campitos on 30/07/15.
 */
@RestController
@RequestMapping("/")
public class ControladorUsuario {
    @Inject
    ServicioUsuario servicioUsuario;

    @RequestMapping(value = "/usuario", method = RequestMethod.POST, headers = {"Accept=application/json"})
    @ResponseBody
    String guardar(@RequestBody String json) throws Exception {
        String mensaje="nada :'(";




        Map<String, String> map = getMap(json);

        String nombre=map.get("nombre");
        Integer edad=Integer.parseInt(map.get("edad"));
        Float sueldo=Float.parseFloat(map.get("sueldo"));
        Usuario u=new Usuario();
        u.setEdad(edad);
        u.setNombre(nombre);
        u.setSueldo(sueldo);
      //   servicioUsuario.agregarUsuario(u);
         mensaje="Ha llegado el json y se guardo con nombre "+nombre+" , edad "+edad+" ,sueldo "+sueldo;

        System.out.println(mensaje);

        return json;
    }
    @CrossOrigin
    @RequestMapping(value="/usuario", method = RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody ArrayList<Usuario> obtenerTodos()throws Exception{

        ArrayList<Usuario> usuarios= (ArrayList<Usuario>) servicioUsuario.getTodos();
        return usuarios;
    }
    //GET POR ID
    @CrossOrigin
    @RequestMapping(value="/usuario/{id}", method = RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody Usuario buscarPorId(@PathVariable Integer id)throws Exception{

        Usuario  usuario= servicioUsuario.getPorId(id);
        System.out.println(usuario.getNombre());
        return usuario;
    }
//UPDATE
    @CrossOrigin
    @RequestMapping(value="/usuario", method = RequestMethod.PUT, headers = {"Accept=application/json"})
    @ResponseBody String actualizar(@RequestBody String json)throws Exception{
         String mensaje="nada";
      System.out.println("SE ha actualziado");
        Map<String, String> map = getMap(json);

        String nombre=map.get("nombre");
        Integer edad=Integer.parseInt(map.get("edad"));
        Float sueldo=Float.parseFloat(map.get("sueldo"));
        mensaje="Ha llegado el json y se guardo con nombre "+nombre+" , edad "+edad+" ,sueldo "+sueldo;
        System.out.println(mensaje);
        return json;
    }

    @CrossOrigin
    @RequestMapping(value="/usuario/{id}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    @ResponseBody String borrar(@PathVariable Integer id)throws Exception{
        String mensaje="nada";

        mensaje="Ha llegado el json y se va a borrar con datos "+id;
        System.out.println(mensaje);
        return mensaje;
    }

    private Map<String, String> getMap(String json) throws java.io.IOException {
        Map<String,String> map = new HashMap<String,String>();
        ObjectMapper mapper = new ObjectMapper();
        //convert JSON string to Map
        map = mapper.readValue(json,
                new TypeReference<HashMap<String,String>>(){});
        return map;
    }



}
