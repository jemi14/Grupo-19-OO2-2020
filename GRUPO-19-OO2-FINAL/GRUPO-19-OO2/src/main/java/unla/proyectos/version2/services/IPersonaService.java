package unla.proyectos.version2.services;

import java.util.List;

import unla.proyectos.version2.entities.Persona;
import unla.proyectos.version2.entities.Persona;
import unla.proyectos.version2.models.PersonaModel;




public interface IPersonaService {
	public List<Persona> getAll();
   
    public PersonaModel findByDni(long dni);

    public PersonaModel insertOrUpdate(PersonaModel personaModel);
    public PersonaModel update(PersonaModel personaModel);
    public boolean remove(long id);

	public PersonaModel findByIdPersona(long id);

}