package unla.proyectos.version2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unla.proyectos.version2.entities.Persona;

@Repository("personaRepository")
public interface IPersonaRepository extends JpaRepository<Persona, Serializable>{
	 public abstract Persona findByIdPersona(long id);
	public abstract Persona findByDni(long dni);
	
}
