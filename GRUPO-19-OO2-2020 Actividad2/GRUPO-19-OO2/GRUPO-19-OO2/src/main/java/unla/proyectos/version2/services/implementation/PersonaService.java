package unla.proyectos.version2.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import unla.proyectos.version2.converters.PersonaConverter;
import unla.proyectos.version2.entities.Persona;
import unla.proyectos.version2.models.PersonaModel;
import unla.proyectos.version2.repositories.IPersonaRepository;
import unla.proyectos.version2.services.IPersonaService;



@Service("personaService")
public class PersonaService implements IPersonaService{
	
	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository personaRepository;
	
	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;

	@Override
	public List<Persona> getAll() {
		return personaRepository.findAll();
	}
	
	

	@Override
	public PersonaModel findByIdPersona(long idPersona) {
		return personaConverter.entityToModel(personaRepository.findByIdPersona(idPersona));
	}

	@Override
	public PersonaModel findByDni(long dni) {
		return personaConverter.entityToModel(personaRepository.findByDni(dni));
	}
	
	

	@Override
	public PersonaModel insertOrUpdate(PersonaModel personaModel) {
		Persona  persona = personaRepository.save(personaConverter.modelToEntity(personaModel));
   
		return personaConverter.entityToModel(persona);
	}

	@Override
	public PersonaModel update(PersonaModel personaModel) {
		Persona persona = personaRepository.save(personaConverter.modelToEntity(personaModel));
		return personaConverter.entityToModel(persona);
	}

	@Override
	public boolean remove(long id) {
		try{
            personaRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
	}

}
