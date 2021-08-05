package ec.edu.espe.distribuidas.examen.grupo2.model;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "per_persona_direccion", schema = "public", catalog = "examen_direcciones")
public class PersonaDireccion {

    @EmbeddedId
    private PersonaDireccionPK pk;
    @Column(name = "calle_principal", nullable = false, length = 100)
    private String callePrincipal;
    @Column(name = "numeracion", nullable = false, length = 15)
    private String numeracion;
    @Column(name = "calle_secundaria", nullable = false, length = 100)
    private String calleSecundaria;
    @Column(name = "barrio", nullable = false, length = 100)
    private String barrio;
    @Column(name = "por_omision", nullable = false, length = 1)
    private String porOmision;
    @Column(name = "cod_tipo_direccion")
    private String codigoTipoDireccion;

    @MapsId("codigoPersona")
    @JoinColumn(name = "cod_persona",
            referencedColumnName = "cod_persona",
            nullable = false,
            insertable = false,
            updatable = false)
    @ManyToOne(optional = false)
    @ToString.Exclude
    Persona persona;

    @JoinColumn(name = "cod_tipo_direccion",
            referencedColumnName = "cod_tipo_direccion",
            nullable = false,
            insertable = false,
            updatable = false)
    @ManyToOne(optional = false)
    @ToString.Exclude
    TipoDireccion tipoDireccion;
}
