package ec.edu.espe.distribuidas.examen.grupo2.controller;

import ec.edu.espe.distribuidas.examen.grupo2.dto.PersonaDireccionRQ;
import ec.edu.espe.distribuidas.examen.grupo2.model.PersonaDireccion;
import ec.edu.espe.distribuidas.examen.grupo2.model.PersonaDireccionPK;
import ec.edu.espe.distribuidas.examen.grupo2.service.PersonaDireccionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/personaDireccion")
@Slf4j
public class PersonaDireccionController {
    private final PersonaDireccionService service;

    public PersonaDireccionController(PersonaDireccionService service) {
        this.service = service;
    }

    @GetMapping(value = "{codigoPersona}")
    @ApiOperation(value = "Lista las direcciones por cada persona", notes = "Lista las direcciones por cada persona")
    public ResponseEntity obtenerDireccionesDePersona(@PathVariable("codigoPersona") Integer codigoPersona) {
        log.info(this.service.listarDireccionesPersona(codigoPersona).toString());
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Crear una dirección",
            notes = "Crear una dirección")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. La dirección se ha insertado correctamente"),
            @ApiResponse(code = 400, message = "Bad Request. No se ha podido insertar la dirección"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    public ResponseEntity crearDireccion(@RequestBody PersonaDireccionRQ request) {
        PersonaDireccion personaDireccion = new PersonaDireccion();
        personaDireccion.setCodigoTipoDireccion(request.getCodigoTipoDireccion());
        personaDireccion.setCallePrincipal(request.getCallePrincipal());
        personaDireccion.setNumeracion(request.getNumeracion());
        personaDireccion.setCalleSecundaria(request.getCalleSecundaria());
        personaDireccion.setBarrio(request.getBarrio());
        personaDireccion.setPorOmision(request.getPorOmision());
        PersonaDireccionPK pk = new PersonaDireccionPK();
        pk.setCodigoPersona(request.getCodigoPersona());
        pk.setSecPersonaDireccion(request.getSecPersonaDireccion());
        personaDireccion.setPk(pk);
        this.service.agregarDireccion(personaDireccion);
        return ResponseEntity.ok().build();
    }
}
