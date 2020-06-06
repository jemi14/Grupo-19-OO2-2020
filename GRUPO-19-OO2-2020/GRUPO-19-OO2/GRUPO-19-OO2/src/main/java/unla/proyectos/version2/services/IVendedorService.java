package unla.proyectos.version2.services;

import java.util.List;

import unla.proyectos.version2.entities.Vendedor;
import unla.proyectos.version2.models.VendedorModel;

public interface IVendedorService {
	
	public List<Vendedor> getAll();
    public VendedorModel findByIdPersona(long id);
    public VendedorModel findByDni(Long dni);
    public VendedorModel insert(VendedorModel vendedorModel);
    public VendedorModel update(VendedorModel vendedorModel);
    public boolean remove(long id);
    
}
