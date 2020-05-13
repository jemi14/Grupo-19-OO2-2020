package unla.proyectos.version2.converters;

import org.springframework.stereotype.Component;

import unla.proyectos.version2.entities.Gerente;
import unla.proyectos.version2.models.GerenteModel;


@Component("gerenteConverter")
public class GerenteConverter {
	public GerenteModel entityToModel(Gerente gerente){
        return new GerenteModel(gerente.getId(), gerente.getNombre(), gerente.getApellido(), gerente.getFechaDeNacimiento(), gerente.getDni(), gerente.getLegajo(), gerente.getSueldoBasico());
    }

    public Gerente modelToEntity(GerenteModel gerenteModel){
        return new Gerente(gerenteModel.getNombre(), gerenteModel.getApellido(), gerenteModel.getFechaDeNacimiento(), gerenteModel.getDni(), gerenteModel.getLegajo(), gerenteModel.getSueldoBasico());
    }
}
