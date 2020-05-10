package unla.proyectos.version2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unla.proyectos.version2.entities.Pedido;

@Repository("pedidoRepository")
public interface IPedidoRepository extends JpaRepository<Pedido, Serializable>{
	
	public abstract Pedido findById(long id);
	public abstract Pedido findByCantidad(int cantidad);
	

	
}
