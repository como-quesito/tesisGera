package tesis;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by campitos on 29/07/15.
 */

@Repository
public class ServicioUsuario {
    @Inject
    MongoTemplate mongoTemplate;

    public void agregarUsuario(Usuario u){
        if(!mongoTemplate.collectionExists(Usuario.class)){
            mongoTemplate.createCollection(Usuario.class);
        }
        mongoTemplate.insert(u);
    }

    public void borrarColeccion(){
        mongoTemplate.dropCollection(Usuario.class);
    }

    public List<Usuario> getTodos(){
        List<Usuario> registros=new ArrayList<Usuario>();
        registros=mongoTemplate.findAll(Usuario.class);
        return registros;
    }

    public Usuario getPorId(Integer id){
        Usuario usuario =mongoTemplate.findById(id, Usuario.class);
        return usuario;
    }
}
