package unla.proyectos.version2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unla.proyectos.version2.entities.Producto;
import java.io.Serializable;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Serializable> {

    public abstract Producto findById(long id);
    public abstract Producto findByDescripcion(String descripcion);
    public abstract Producto findByNombre(String nombre);
  
}
