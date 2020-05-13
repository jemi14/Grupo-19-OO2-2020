package unla.proyectos.version1.services;
import java.util.List;

import unla.proyectos.version1.entities.Producto;
import unla.proyectos.version1.models.ProductoModelo;


public interface IProductoService {

	public List<Producto> getAll();
	
	public ProductoModelo insertOrUpdate(ProductoModelo productoModelo);
	
	public boolean remove(int id);
}

