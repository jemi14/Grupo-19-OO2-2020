package unla.proyectos.version2.services;

import java.util.List;

import unla.proyectos.version2.entities.Producto;
import unla.proyectos.version2.models.ProductoModel;

public interface IProductoService {

    public List<Producto> getAll();
    public ProductoModel findById(long id);
    public ProductoModel findByDescripcion(String descripcion);
    public ProductoModel findByNombre(String nombre);
    public ProductoModel insert(ProductoModel productoModel);
    public ProductoModel update(ProductoModel productoModel);
    public boolean remove(long id);
    
}
