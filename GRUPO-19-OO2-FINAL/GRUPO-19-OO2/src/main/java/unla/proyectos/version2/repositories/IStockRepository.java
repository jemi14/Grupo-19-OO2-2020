package unla.proyectos.version2.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unla.proyectos.version2.entities.Producto;
import unla.proyectos.version2.entities.Stock;



@Repository("stockRepository")
public interface IStockRepository extends JpaRepository<Stock, Serializable> {
	
	public abstract Stock findById(long id);
	
	public abstract Stock findByProducto(Producto producto);

	
}