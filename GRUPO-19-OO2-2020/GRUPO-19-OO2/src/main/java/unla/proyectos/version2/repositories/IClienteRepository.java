package unla.proyectos.version2.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unla.proyectos.version2.entities.Cliente;


@Repository("clienteRepository")
public interface IClienteRepository extends JpaRepository<Cliente, Serializable>{
	
	 public abstract Cliente findById(long id);
	public abstract Cliente findByDni(long dni);
	 
}
