package tesis;

import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by campitos on 29/07/15.
 */
@RestController
@RequestMapping("/")
public class ControladorTarjeta {
    @Inject
    ServicioTarjeta servicioTarjeta;
    @CrossOrigin
    @RequestMapping(value="/tarjeta/{nombre}/{diaCorte}", method= RequestMethod.POST, headers={"Accept=text/html"})
    @ResponseBody
    String inicio(@PathVariable String nombre, @PathVariable Integer diaCorte) throws Exception{
       Tarjeta t=new Tarjeta(nombre, diaCorte);
        servicioTarjeta.agregarTarjeta(t);

        return "Tarjeta guardada con exito";
    }

    @CrossOrigin
    @RequestMapping(value="/tarjeta", method = RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody
    ArrayList<Tarjeta> obtenerTodas()throws Exception{

        ArrayList<Tarjeta> tarjetas= (ArrayList<Tarjeta>) servicioTarjeta.todosTarjeta();
        return tarjetas;
    }


}
