package ec.edu.espe.distribuidas.examen.grupo2.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonaRS {
    private Integer codigo;
    private String nombres;
    private List<PersonaDireccionRS> direcciones;
}
