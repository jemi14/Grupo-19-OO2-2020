package unla.proyectos.version2.services;

import java.util.List;

import unla.proyectos.version2.entities.Cliente;
import unla.proyectos.version2.models.ClienteModel;



public interface IClienteService {
	public List<Cliente> getAll();
    public ClienteModel findById(long id);
    public ClienteModel findByDni(long dni);
    public ClienteModel insert(ClienteModel clienteModel);
    public ClienteModel update(ClienteModel clienteModel);
    public boolean remove(long id);
}
