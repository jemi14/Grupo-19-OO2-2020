package unla.proyectos.version2.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unla.proyectos.version2.entities.Gerente;



@Repository("gerenteRepository")
public interface IGerenteRepository extends JpaRepository<Gerente, Serializable>{
	 public abstract Gerente findById(long id);
	public abstract Gerente findByDni(long dni);
	 public abstract Gerente findByLegajo(long legajo);

	 
	
	 
	
}
