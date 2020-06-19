package unla.proyectos.version2.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import unla.proyectos.version2.converters.GerenteConverter;
import unla.proyectos.version2.entities.Gerente;
import unla.proyectos.version2.models.GerenteModel;
import unla.proyectos.version2.repositories.IGerenteRepository;
import unla.proyectos.version2.services.IGerenteService;



@Service("gerenteService")
public class GerenteService implements IGerenteService{
	
	@Autowired
	@Qualifier("gerenteRepository")
	private IGerenteRepository gerenteRepository;
	
	@Autowired
	@Qualifier("gerenteConverter")
	private GerenteConverter gerenteConverter;

	@Override
	public List<Gerente> getAll() {
		return gerenteRepository.findAll();
	}
	
	

	@Override
	public GerenteModel findByIdPersona(long idPersona) {
		return gerenteConverter.entityToModel(gerenteRepository.findByIdPersona(idPersona));
	}

	@Override
	public GerenteModel findByDni(long dni) {
		return gerenteConverter.entityToModel(gerenteRepository.findByDni(dni));
	}
	
	@Override
	public GerenteModel findByLegajo(long legajo) {
		return gerenteConverter.entityToModel(gerenteRepository.findByLegajo(legajo));
	}

	@Override
	public GerenteModel insertOrUpdate(GerenteModel gerenteModel) {
		Gerente  gerente = gerenteRepository.save(gerenteConverter.modelToEntity(gerenteModel));
   
		return gerenteConverter.entityToModel(gerente);
	}

	@Override
	public GerenteModel update(GerenteModel gerenteModel) {
		Gerente gerente = gerenteRepository.save(gerenteConverter.modelToEntity(gerenteModel));
		return gerenteConverter.entityToModel(gerente);
	}

	@Override
	public boolean remove(long id) {
		try{
            gerenteRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
	}
	
	
	public long maximoId() {
		
		long maximo = -1;
		
		for (Gerente g: getAll()) {
			if(g.getId()>maximo) {
				maximo = g.getId();
			}
		}
		
		return maximo;
	}
	

}
