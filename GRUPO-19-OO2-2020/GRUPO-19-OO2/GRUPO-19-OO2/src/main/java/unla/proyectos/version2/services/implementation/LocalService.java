package unla.proyectos.version2.services.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import unla.proyectos.version2.converters.GerenteConverter;
import unla.proyectos.version2.converters.LocalConverter;
import unla.proyectos.version2.entities.Local;
import unla.proyectos.version2.models.GerenteModel;
import unla.proyectos.version2.models.LocalModel;
import unla.proyectos.version2.repositories.ILocalRepository;
import unla.proyectos.version2.services.ILocalService;

import java.util.List;

@Service("localService")
public class LocalService implements ILocalService {

    @Autowired
    @Qualifier("localRepository")
    private ILocalRepository localRepository;

    @Autowired
    @Qualifier("localConverter")
    private LocalConverter localConverter;
    
    @Autowired
    @Qualifier("gerenteConverter")
    private GerenteConverter gerenteConverter;
    
	@Autowired
	@Qualifier("gerenteService")
	private GerenteService gerenteService;

    @Override
    public List<Local> getAll(){
        return localRepository.findAll();
    }

    @Override
    public LocalModel findById(long id){
        return localConverter.entityToModel(localRepository.findById(id));
    }

 

    @Override
    public LocalModel insertOrUpdate(LocalModel localModel) {

  
    	GerenteModel g = gerenteService.findByIdPersona(localModel.getGerente().getId());
    	
    	
    	
        Local local = localRepository.save(localConverter.modelToEntity(localModel));
        
        
        
        
  
        
        return localConverter.entityToModel(local);
    }

    @Override
    public LocalModel update(LocalModel localModel) {
    	
    	System.out.print("BUSCO A ESTE GERENTE: " +localModel.getGerente().getId());
    	GerenteModel g = gerenteService.findByIdPersona(localModel.getGerente().getId());
    	System.out.print("Este es el genrente: " +g.toString());
    	localModel.setGerente(g);

        Local local = localRepository.save(localConverter.modelToEntity(localModel));
        return localConverter.entityToModel(local);
    }

    @Override
    public boolean remove(long id){
        try{
            localRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    
    
    public LocalModel localMasCercano(LocalModel localModel) {
 	   
 	   
 	   LocalModel l = new LocalModel();
 	   
 	   double distancia = 100000000;
 	   
 	   
 	   for (Local local: getAll()) {
 		   
 		   
 		   if(local.getId()!=localModel.getId()) {
 		   
 		   if(localModel.calcularDistancia(local.getLatitud(), local.getLongitud())<distancia) {
 			   
 			   distancia = localModel.calcularDistancia(local.getLatitud(), local.getLongitud());
 			   l = localConverter.entityToModel(local);
 			   
 		   }
 		   
 		   }
 		   
 		   
 	   }
 	   
 	   
    	return l;
    }
    
    
    
}
