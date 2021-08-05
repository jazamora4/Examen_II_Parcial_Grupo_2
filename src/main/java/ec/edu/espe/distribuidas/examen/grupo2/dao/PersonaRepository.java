package ec.edu.espe.distribuidas.examen.grupo2.dao;

import ec.edu.espe.distribuidas.examen.grupo2.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    
}
