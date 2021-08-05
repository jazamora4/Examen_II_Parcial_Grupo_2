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
import lombok.Data;

@Data
@Entity
@Table(name = "per_persona", schema = "public", catalog = "examen_direcciones")
public class Persona {
    @Id
    @Column(name = "cod_persona")
    private Integer codigo;
    @Column(name = "cod_empresa")
    private String codigoEmpresa;
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "nombre1")
    private String nombre1;
    @Column(name = "nombre2")
    private String nombre2;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<PersonaDireccion> direcciones;
}
