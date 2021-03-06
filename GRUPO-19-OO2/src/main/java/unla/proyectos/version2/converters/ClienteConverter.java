package unla.proyectos.version2.converters;

import org.springframework.stereotype.Component;

import unla.proyectos.version2.entities.Cliente;
import unla.proyectos.version2.models.ClienteModel;



@Component("clienteConverter")
public class ClienteConverter {
	
	 public ClienteModel entityToModel(Cliente cliente){
	        return new ClienteModel(cliente.getId(), cliente.getNombre(), cliente.getApellido(), cliente.getFechaDeNacimiento(), cliente.getDni(), cliente.getMail());
	    }

	    public Cliente modelToEntity(ClienteModel clienteModel){
	        return new Cliente(clienteModel.getId(),clienteModel.getNombre(), clienteModel.getApellido(), clienteModel.getFechaDeNacimiento(), clienteModel.getDni(), clienteModel.getMail());
	    }
}
