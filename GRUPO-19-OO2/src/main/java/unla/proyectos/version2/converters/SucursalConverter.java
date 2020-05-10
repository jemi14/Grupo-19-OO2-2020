package unla.proyectos.version2.converters;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import unla.proyectos.version2.entities.Sucursal;
import unla.proyectos.version2.models.SucursalModel;

@Component("sucursalConverter")
public class SucursalConverter {
	
	@Autowired
	@Qualifier("gerenteConverter")
	private GerenteConverter gerenteConverter;

    public SucursalModel entityToModel(Sucursal sucursal){
        return new SucursalModel(sucursal.getId(), sucursal.getLocalidad(), sucursal.getCalle(), sucursal.getNumero(),sucursal.getTelefono(), sucursal.getLatitud(),sucursal.getLongitud(), gerenteConverter.entityToModel(sucursal.getGerente()));
    }                         

    public Sucursal modelToEntity(SucursalModel sucursalModel){
    	
        return new Sucursal(sucursalModel.getId(), sucursalModel.getLocalidad(), sucursalModel.getCalle(), sucursalModel.getNumero(),sucursalModel.getTelefono(), sucursalModel.getLatitud(),sucursalModel.getLongitud(),gerenteConverter.modelToEntity(sucursalModel.getGerente()));
    }
}
