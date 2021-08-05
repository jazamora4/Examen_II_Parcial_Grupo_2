package ec.edu.espe.distribuidas.examen.grupo2.service;

import ec.edu.espe.distribuidas.examen.grupo2.dao.PersonaDireccionRepository;
import ec.edu.espe.distribuidas.examen.grupo2.model.PersonaDireccion;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonaDireccionService {

    private final PersonaDireccionRepository personaDireccionRepo;

    public PersonaDireccionService(PersonaDireccionRepository personaDireccionRepo) {
        this.personaDireccionRepo = personaDireccionRepo;
    }

    public List<PersonaDireccion> listarDireccionesPersona(Integer codigoPersona) {
        return this.personaDireccionRepo.findByPkCodigoPersonaOrderByCodigoTipoDireccionAsc(codigoPersona);
    }

    public void agregarDireccion(PersonaDireccion personaDireccion) {
        List<PersonaDireccion> direcciones = this.personaDireccionRepo
                .findByPkCodigoPersonaOrderByCodigoTipoDireccionAsc(personaDireccion.getPk().getCodigoPersona());
        direcciones.forEach(direccion -> {
            if (!direccion.getCodigoTipoDireccion().equals(personaDireccion.getCodigoTipoDireccion())) {
                if ("S".equals(direccion.getPorOmision())) {
                    if ("S".equals(personaDireccion.getPorOmision())) {
                        throw new RuntimeException("La persona ya tiene un direccion de ese tipo S");
                    }
                }
            } else {
                throw new RuntimeException("La persona ya tiene un direccion de ese tipo");
            }
        });
        this.personaDireccionRepo.save(personaDireccion);
    }

}
