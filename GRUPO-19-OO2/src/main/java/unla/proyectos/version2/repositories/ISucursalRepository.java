package unla.proyectos.version2.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unla.proyectos.version2.entities.Sucursal;

import java.io.Serializable;

@Repository("sucursalRepository")
public interface ISucursalRepository extends JpaRepository<Sucursal, Serializable> {
	
    public abstract Sucursal findById(long id);
    
    

  
}
