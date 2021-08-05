package ec.edu.espe.distribuidas.examen.grupo2.model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "per_persona", schema = "public", catalog = "examen_direcciones")
public class Persona {
    @Id
    @Column(name = "cod_persona",
            nullable = false)
    private Integer codigo;
    @Column(name = "cod_empresa",
            nullable = false,
            length = 8)
    private String codigoEmpresa;
    @Column(name = "fecha_ingreso",
            nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "nombres",
            nullable = false,
            length = 250)
    private String nombres;
    @Column(name = "nombre1",
            nullable = false,
            length = 50)
    private String nombre1;
    @Column(name = "nombre2",
            nullable = false,
            length = 50)
    private String nombre2;
    @Column(name = "apellido1",
            nullable = false,
            length = 50)
    private String apellido1;
    @Column(name = "apellido2",
            nullable = false,
            length = 50)
    private String apellido2;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<PersonaDireccion> direcciones;
}
