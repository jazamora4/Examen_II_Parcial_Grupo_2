package ec.edu.espe.distribuidas.examen.grupo2.model;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "per_tipo_direccion", schema = "public", catalog = "examen_direcciones")
public class TipoDireccion {
    @Id
    @Column(name = "cod_tipo_direccion")
    private String codTipoDireccion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "estado")
    private String estado;
}
