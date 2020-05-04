package unla.proyectos.version1.converters;

import org.springframework.stereotype.Component;

import unla.proyectos.version1.entities.Producto;
import unla.proyectos.version1.models.ProductoModelo;



@Component("productoConverter")
public class ProductoConverter {

	
	//Tranformo base a modelo
	public ProductoModelo entityToModel(Producto producto) {
		return new ProductoModelo(producto.getIdProducto(), producto.getDescripcion(),producto.getPrecioUnitario(),producto.getNombre());
	}

	public Producto modelToEntity(ProductoModelo productoModelo) {
		return new Producto(productoModelo.getIdProducto(), productoModelo.getDescripcion(),productoModelo.getPrecioUnitario(),productoModelo.getNombre());
	}
}

