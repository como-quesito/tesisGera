package tesis;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by campitos on 29/07/15.
 */
@Repository
public class ServicioTarjeta {

    @Inject
    private MongoTemplate mongoTemplate;

    public void agregarTarjeta(Tarjeta tarjeta) {
        if (!mongoTemplate.collectionExists(Tarjeta.class)) {
            mongoTemplate.createCollection(Tarjeta.class);
        }

        mongoTemplate.insert(tarjeta);
    }


    public void actualizarTarjeta(Tarjeta Tarjeta) {
        //	 mongoTemplate.findOne(new Query(Criteria.where("titulo").is(titulo)), Promocion.class);
        //  mongoTemplate.updateFirst(query(where("hora").is(Tarjeta.getHora())), update("temperatura", Tarjeta.getTemperatura()), Tarjeta.class);
        // mongoTemplate.updateFirst(query(where("name").is(producto.getNombre())), update("direccion", promo.getDireccion()), Promocion.class);
    }

    public List<Tarjeta> todosTarjeta() {
        List<Tarjeta> Tarjeta = mongoTemplate.findAll(Tarjeta.class);

        return Tarjeta;
    }

    public Tarjeta TarjetaId(String id) {
        Tarjeta e = mongoTemplate.findById(id, Tarjeta.class);

        return e;
    }

    /*
        public Tarjeta TarjetaHora(int hora){
            // query to search user
            Query cueri = new Query(Criteria.where("hora").is(hora));
            Tarjeta e=    mongoTemplate.findOne(cueri, Tarjeta.class);

            return e;
        }
        */
    public String borrarTarjeta(String id) {

        mongoTemplate.remove(new Tarjeta(id));

        return "Tarjeta borrada";
    }
}

    