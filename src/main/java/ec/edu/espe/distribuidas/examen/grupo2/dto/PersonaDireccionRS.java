package ec.edu.espe.distribuidas.examen.grupo2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonaDireccionRS {

    private String callePrincipal;
    private String numeracion;
    private String calleSecundaria;
    private String barrio;
    private String porOmision;
    private String nombreTipoDireccion;
    private String observacionTipoDireccion;
    private String estadoTipoDireccion;
    private String codigoTipoDireccion;

}