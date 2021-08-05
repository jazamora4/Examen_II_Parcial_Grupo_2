package ec.edu.espe.distribuidas.examen.grupo2.dto;

import lombok.Data;

@Data
public class PersonaDireccionRQ {
    private Integer codigoPersona;
    private Integer secPersonaDireccion;
    private String callePrincipal;
    private String numeracion;
    private String calleSecundaria;
    private String barrio;
    private String porOmision;
    private String codigoTipoDireccion;
}
