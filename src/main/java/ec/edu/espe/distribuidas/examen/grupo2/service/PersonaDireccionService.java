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

    public List<PersonaDireccion> listarDireccionesPersona(Integer codPersona) {
        return this.personaDireccionRepo.findByPKcodigoPersonaOrderByCodigoTipoDireccionAsc(codPersona);
    }

    public void agregarDireccion(PersonaDireccion personaDireccion) {
        //List<PersonaDireccion> personaDireccion= this.personaDireccionRepo.findByPKCodPersonaAndCodTipoDireccion(personaDireccion.get, codTipo);

    }

}
