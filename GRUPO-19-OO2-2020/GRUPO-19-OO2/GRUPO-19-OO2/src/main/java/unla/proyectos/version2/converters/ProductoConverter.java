package unla.proyectos.version2.converters;


import org.springframework.stereotype.Component;

import unla.proyectos.version2.entities.Producto;
import unla.proyectos.version2.models.ProductoModel;

@Component("productoConverter")
public class ProductoConverter {

    public ProductoModel entityToModel(Producto producto){
        return new ProductoModel(producto.getId(), producto.getDescripcion(), producto.getPrecioUnitario(), producto.getNombre());
    }

    public Producto modelToEntity(ProductoModel productoModel){
        return new Producto(productoModel.getId(), productoModel.getDescripcion(), productoModel.getPrecioUnitario(), productoModel.getNombre());
    }
}
