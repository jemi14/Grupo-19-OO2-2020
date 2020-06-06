package unla.proyectos.version2.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unla.proyectos.version2.entities.Vendedor;

@Repository("vendedorRepository")
public interface IVendedorRepository extends JpaRepository<Vendedor, Serializable> {
	
	public abstract Vendedor findByIdPersona(long id);
    public abstract Vendedor findByDni(Long dni);
     
}
