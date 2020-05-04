package unla.proyectos.version1.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import unla.proyectos.version1.converters.ProductoConverter;
import unla.proyectos.version1.entities.Producto;
import unla.proyectos.version1.models.ProductoModelo;
import unla.proyectos.version1.repositories.IProductoRepository;
import unla.proyectos.version1.services.IProductoService;


@Service("productoService")
public class ProductoService implements IProductoService {

	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository productoRepository;
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	
	
	@Override
	public List<Producto> getAll() {
		return productoRepository.findAll();
	}

	@Override
	public ProductoModelo insertOrUpdate(ProductoModelo productoModelo){
		Producto producto= productoRepository.save(productoConverter.modelToEntity(productoModelo));
		return productoConverter.entityToModel(producto);
	}

	@Override
	public boolean remove(int id) {
		try {
			productoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}


}
