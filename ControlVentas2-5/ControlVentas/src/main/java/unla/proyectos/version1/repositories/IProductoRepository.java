package unla.proyectos.version1.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import unla.proyectos.version1.entities.Producto;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Serializable> {

	public abstract Producto findByNombre(String nombre);
	
	public abstract Producto findByPrecioUnitarioAndNombre(double precioUnitario, String nombre);
	
	public abstract List<Producto> findByPrecioUnitarioAndNombreOrderByPrecioUnitarioDesc(double precioUnitario, String nombre);
	
	

}
