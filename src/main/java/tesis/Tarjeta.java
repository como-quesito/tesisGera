package tesis;

import org.springframework.data.annotation.Id;

/**
 * Created by campitos on 29/07/15.
 */
public class Tarjeta {
    @Id
    String id;
    String nombre;
    Integer diaCorte;
    public Tarjeta() {
    }

    public Tarjeta(String id) {
        this.id = id;
    }

    public Tarjeta(String nombre, Integer diaCorte) {
        this.nombre = nombre;
        this.diaCorte = diaCorte;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDiaCorte() {
        return diaCorte;
    }

    public void setDiaCorte(Integer diaCorte) {
        this.diaCorte = diaCorte;
    }
}
