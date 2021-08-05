package ec.edu.espe.distribuidas.examen.grupo2.service;

import ec.edu.espe.distribuidas.examen.grupo2.dao.PersonaDireccionRepository;
import ec.edu.espe.distribuidas.examen.grupo2.dao.PersonaRepository;
import ec.edu.espe.distribuidas.examen.grupo2.dao.TipoDireccionRepository;
import ec.edu.espe.distribuidas.examen.grupo2.model.Persona;
import ec.edu.espe.distribuidas.examen.grupo2.model.PersonaDireccion;
import ec.edu.espe.distribuidas.examen.grupo2.model.TipoDireccion;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonaDireccionService {

    private final PersonaDireccionRepository personaDireccionRepo;
    private final PersonaRepository personaRepository;
    private final TipoDireccionRepository tipoDireccionRepository;

    public PersonaDireccionService(PersonaDireccionRepository personaDireccionRepo,
                                   PersonaRepository personaRepository,
                                   TipoDireccionRepository tipoDireccionRepository) {
        this.personaDireccionRepo = personaDireccionRepo;
        this.personaRepository = personaRepository;
        this.tipoDireccionRepository = tipoDireccionRepository;
    }

    public List<PersonaDireccion> listarDireccionesPersona(Integer codigoPersona) {
        return this.personaDireccionRepo.findByPkCodigoPersonaOrderByCodigoTipoDireccionAsc(codigoPersona);
    }

    public void agregarDireccion(PersonaDireccion personaDireccion) {
        List<PersonaDireccion> direcciones = this.personaDireccionRepo
                .findByPkCodigoPersonaOrderByCodigoTipoDireccionAsc(personaDireccion.getPk().getCodigoPersona());
        Persona persona = this.personaRepository.getById(personaDireccion.getPk().getCodigoPersona());
        TipoDireccion tipoDireccion = this.tipoDireccionRepository.getById(personaDireccion.getCodigoTipoDireccion());

        for (PersonaDireccion direccion : direcciones) {
            persona = direccion.getPersona();
            if (!direccion.getCodigoTipoDireccion().equals(personaDireccion.getCodigoTipoDireccion())) {
                if ("S".equals(direccion.getPorOmision())) {
                    if ("S".equals(personaDireccion.getPorOmision())) {
                        throw new RuntimeException("La persona ya tiene un direccion de ese tipo S");
                    }
                }
            } else {
                throw new RuntimeException("La persona ya tiene un direccion de ese tipo");
            }
        }
        personaDireccion.setPersona(persona);
        personaDireccion.setTipoDireccion(tipoDireccion);
        this.personaDireccionRepo.save(personaDireccion);
    }

}
