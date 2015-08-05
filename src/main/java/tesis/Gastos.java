package tesis;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

/**
 * Created by campitos on 29/07/15.
 */
public class Gastos {
    @Id
    String id;
    String concepto;
    DateTime fecha;
    Float cantidad;
    Tarjeta tarjeta;

}
