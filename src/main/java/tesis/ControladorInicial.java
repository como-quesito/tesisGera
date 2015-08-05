package tesis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by campitos on 15/07/15.
 */
@RestController
@RequestMapping("/")

public class ControladorInicial {
    @Inject
    ServicioUsuario servicioUsuario;
    @CrossOrigin
    @RequestMapping(value="/", method= RequestMethod.GET, headers={"Accept=text/html"})
    @ResponseBody String inicio(){

        return "Bienvenido a la tesis usuario guardado";
    }

    @CrossOrigin
    @RequestMapping(value="/inicio", method= RequestMethod.GET, headers={"Accept=text/html"})
    @ResponseBody String inicio2(){
        return "Bienvenido a la tesis";
    }

    @CrossOrigin
    @RequestMapping(value = "/usuariosote", method = RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody
    ArrayList<Usuario> obtenerTodos()throws Exception{
     ArrayList<Usuario> usuarios= (ArrayList<Usuario>) servicioUsuario.getTodos();
        return  usuarios;

    }

}
