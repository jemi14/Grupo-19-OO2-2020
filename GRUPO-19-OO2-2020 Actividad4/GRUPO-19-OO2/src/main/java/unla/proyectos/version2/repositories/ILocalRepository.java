package unla.proyectos.version2.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unla.proyectos.version2.entities.Local;

import java.io.Serializable;

@Repository("localRepository")
public interface ILocalRepository extends JpaRepository<Local, Serializable> {
	
    public abstract Local findById(long id);
    
    

  
}
