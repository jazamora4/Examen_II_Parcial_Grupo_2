package ec.edu.espe.distribuidas.examen.grupo2.transform;

import ec.edu.espe.distribuidas.examen.grupo2.dto.PersonaDireccionRS;
import ec.edu.espe.distribuidas.examen.grupo2.model.PersonaDireccion;

public class PersonaRSTransform {
    public static PersonaDireccionRS buildPersonaDireccionRS(PersonaDireccion personaDireccion) {

        return PersonaDireccionRS.builder().callePrincipal(personaDireccion.getCallePrincipal())
                .numeracion(personaDireccion.getNumeracion())
                .calleSecundaria(personaDireccion.getCalleSecundaria())
                .barrio(personaDireccion.getBarrio())
                .porOmision(personaDireccion.getPorOmision())
                .nombreTipoDireccion(personaDireccion.getTipoDireccion().getNombre())
                .observacionTipoDireccion(personaDireccion.getTipoDireccion().getObservacion())
                .estadoTipoDireccion(personaDireccion.getTipoDireccion().getEstado())
                .build();
    }
}
