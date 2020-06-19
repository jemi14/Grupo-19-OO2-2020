package unla.proyectos.version2.converters;

import org.springframework.stereotype.Component;

import unla.proyectos.version2.entities.Persona;
import unla.proyectos.version2.models.PersonaModel;


@Component("personaConverter")
public class PersonaConverter {
	public PersonaModel entityToModel(Persona persona){
        return new PersonaModel(persona.getId(), persona.getNombre(), persona.getApellido(), persona.getFechaDeNacimiento(), persona.getDni());
    }

    public Persona modelToEntity(PersonaModel personaModel){
        return new Persona(personaModel.getId(),personaModel.getNombre(), personaModel.getApellido(), personaModel.getFechaDeNacimiento(), personaModel.getDni());
    }
}
