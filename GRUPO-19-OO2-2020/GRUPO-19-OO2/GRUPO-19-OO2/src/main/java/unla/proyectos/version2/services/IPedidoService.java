package unla.proyectos.version2.services;

import java.util.List;


import unla.proyectos.version2.entities.Cliente;
import unla.proyectos.version2.entities.Pedido;

import unla.proyectos.version2.models.PedidoModel;



public interface IPedidoService {

	public List<Pedido> getAll();
	
	public PedidoModel findById(long id);
	
	//public PedidoModel findByCliente(Cliente cliente);
	
	public PedidoModel insertOrUpdate(PedidoModel pedidoModel);
	
	public PedidoModel Update(PedidoModel pedidoModel);
	
	public boolean remove(long id);
	

	
}