package unla.proyectos.version2.services.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import unla.proyectos.version2.converters.SucursalConverter;
import unla.proyectos.version2.entities.Sucursal;
import unla.proyectos.version2.models.SucursalModel;
import unla.proyectos.version2.repositories.ISucursalRepository;
import unla.proyectos.version2.services.ISucursalService;

import java.util.List;

@Service("sucursalService")
public class SucursalService implements ISucursalService {

    @Autowired
    @Qualifier("sucursalRepository")
    private ISucursalRepository sucursalRepository;

    @Autowired
    @Qualifier("sucursalConverter")
    private SucursalConverter sucursalConverter;
    
	@Autowired
	@Qualifier("gerenteService")
	private GerenteService gerenteService;

    @Override
    public List<Sucursal> getAll(){
        return sucursalRepository.findAll();
    }

    @Override
    public SucursalModel findById(long id){
        return sucursalConverter.entityToModel(sucursalRepository.findById(id));
    }

 

    @Override
    public SucursalModel insert(SucursalModel sucursalModel) {

  
    	
        Sucursal sucursal = sucursalRepository.save(sucursalConverter.modelToEntity(sucursalModel));
        
        
        return sucursalConverter.entityToModel(sucursal);
    }

    @Override
    public SucursalModel update(SucursalModel sucursalModel) {
    	sucursalModel.setGerente(gerenteService.findById(sucursalModel.getGerente().getId()));

        Sucursal sucursal = sucursalRepository.save(sucursalConverter.modelToEntity(sucursalModel));
        return sucursalConverter.entityToModel(sucursal);
    }

    @Override
    public boolean remove(long id){
        try{
            sucursalRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
