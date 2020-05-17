package unla.proyectos.version2.converters;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import unla.proyectos.version2.entities.Local;
import unla.proyectos.version2.models.LocalModel;

@Component("localConverter")
public class LocalConverter {
	
	@Autowired
	@Qualifier("gerenteConverter")
	private GerenteConverter gerenteConverter;

    public LocalModel entityToModel(Local Local){
        return new LocalModel(Local.getId(), Local.getLocalidad(), Local.getCalle(), Local.getNumero(),Local.getTelefono(), Local.getLatitud(),Local.getLongitud(), gerenteConverter.entityToModel(Local.getGerente()));
    }                         

    public Local modelToEntity(LocalModel LocalModel){
    	
        return new Local(LocalModel.getId(), LocalModel.getLocalidad(), LocalModel.getCalle(), LocalModel.getNumero(),LocalModel.getTelefono(), LocalModel.getLatitud(),LocalModel.getLongitud(),gerenteConverter.modelToEntity(LocalModel.getGerente()));
    }
}
