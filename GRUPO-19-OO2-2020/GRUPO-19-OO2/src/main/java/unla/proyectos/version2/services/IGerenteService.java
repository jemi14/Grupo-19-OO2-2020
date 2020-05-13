package unla.proyectos.version2.services;

import java.util.List;

import unla.proyectos.version2.entities.Gerente;
import unla.proyectos.version2.models.GerenteModel;




public interface IGerenteService {
	public List<Gerente> getAll();
   
    public GerenteModel findByDni(long dni);
    public GerenteModel findByLegajo(long legajo);
    public GerenteModel insert(GerenteModel gerenteModel);
    public GerenteModel update(GerenteModel gerenteModel);
    public boolean remove(long id);

	public GerenteModel findById(long id);

}