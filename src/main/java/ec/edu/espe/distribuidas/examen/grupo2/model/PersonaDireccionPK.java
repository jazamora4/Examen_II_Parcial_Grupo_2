package ec.edu.espe.distribuidas.examen.grupo2.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import lombok.Data;

@Data
@Embeddable
public class PersonaDireccionPK implements Serializable {
    @Column(name = "cod_persona")
    private Integer codigoPersona;
    @Column(name = "sec_persona_direccion")
    private Integer secPersonaDireccion;
}
