package ec.edu.espe.distribuidas.examen.grupo2.dao;

import ec.edu.espe.distribuidas.examen.grupo2.model.PersonaDireccion;
import ec.edu.espe.distribuidas.examen.grupo2.model.PersonaDireccionPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDireccionRepository extends JpaRepository<PersonaDireccion, PersonaDireccionPK> {

    List<PersonaDireccion> findByPKcodigoPersonaOrderByCodigoTipoDireccionAsc(Integer codPaciente);

    List<PersonaDireccion> findByPKcodigoPersonaAndCodigoTipoDireccion(Integer codPaciente, String codTipo);

}
