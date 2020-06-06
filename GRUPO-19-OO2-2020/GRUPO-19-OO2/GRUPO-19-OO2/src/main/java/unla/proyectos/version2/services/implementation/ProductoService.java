package unla.proyectos.version2.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import unla.proyectos.version2.converters.ProductoConverter;
import unla.proyectos.version2.entities.Producto;
import unla.proyectos.version2.models.ProductoModel;
import unla.proyectos.version2.repositories.IProductoRepository;
import unla.proyectos.version2.services.IProductoService;

import java.util.List;

@Service("productoService")
public class ProductoService implements IProductoService {

    @Autowired
    @Qualifier("productoRepository")
    private IProductoRepository productoRepository;

    @Autowired
    @Qualifier("productoConverter")
    private ProductoConverter productoConverter;

    @Override
    public List<Producto> getAll(){
        return productoRepository.findAll();
    }

    @Override
    public ProductoModel findById(long id){
        return productoConverter.entityToModel(productoRepository.findById(id));
    }
    
    @Override
    public ProductoModel findByNombre(String nombre){
        return productoConverter.entityToModel(productoRepository.findByNombre(nombre));
    }

    @Override
    public ProductoModel findByDescripcion(String descripcion){
        return productoConverter.entityToModel(productoRepository.findByDescripcion(descripcion));
    }

    @Override
    public ProductoModel insert(ProductoModel productoModel) {
    	
    	Producto producto =  productoRepository.save(productoConverter.modelToEntity(productoModel));
    	 
        return productoConverter.entityToModel(producto);
    }

    @Override
    public ProductoModel update(ProductoModel productoModel) {

        Producto producto = productoRepository.save(productoConverter.modelToEntity(productoModel));
        return productoConverter.entityToModel(producto);
    }

    @Override
    public boolean remove(long id){
        try{
            productoRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
