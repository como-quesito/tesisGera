package tesis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by campitos on 15/07/15.
 */
@RestController
@RequestMapping("/")

public class ControladorInicial {
    @CrossOrigin
    @RequestMapping(value="/", method= RequestMethod.GET, headers={"Accept=text/html"})
    @ResponseBody String inicio(){
        return "Bienvenido a la tesis";
    }

    @CrossOrigin
    @RequestMapping(value="/inicio", method= RequestMethod.GET, headers={"Accept=text/html"})
    @ResponseBody String inicio2(){
        return "Bienvenido a la tesis";
    }


    @RequestMapping(value = "/usuario", method = RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody
    ArrayList<Usuario> obtenerTodos()throws Exception{
        Usuario u1=new Usuario(1,"juan",42,4566);
        Usuario u2=new Usuario(2,"Ana",23,4555);
        Usuario u3=new Usuario(3,"Pedro",34,56888);
        ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        return  usuarios;

    }

}
