package unla.proyectos.version2.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import unla.proyectos.version2.helpers.ViewRouteHelper;
import unla.proyectos.version2.models.ClienteModel;
import unla.proyectos.version2.models.GerenteModel;
import unla.proyectos.version2.models.VendedorModel;
import unla.proyectos.version2.services.IClienteService;
import unla.proyectos.version2.services.IGerenteService;
import unla.proyectos.version2.services.IVendedorService;



@Controller
@RequestMapping("/personas")
public class PersonasController {
	
	@Autowired
	@Qualifier("gerenteService")
	private IGerenteService gerenteService;
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;
	

	
	
	////////////////////////INDEX QUE ADMINISTRA GER, EMPLE, CLIENTE y EMPLEADOS//////////////
	@GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSONAS_INDEX);
        mAV.addObject("gerentes", gerenteService.getAll());
    	mAV.addObject("gerenteModel", new GerenteModel());
    	
    	mAV.addObject("clientes", clienteService.getAll());
    	mAV.addObject("clienteModel", new ClienteModel());
    	
     	mAV.addObject("vendedores", vendedorService.getAll());
    	mAV.addObject("vendedorModel", new VendedorModel());
    	
      	
        return mAV;
    }
	/////////////////////////////////////////////////////////////////////////////////////
 

	
	/////////////////////////////////////ABM GENRENTES////////////////////////////////////////////////
    @PostMapping("/agregargerenteyvolveraindex")
    public RedirectView create(@ModelAttribute("gerenteModel") GerenteModel gerenteModel){
        gerenteService.insert(gerenteModel);
        return new RedirectView(ViewRouteHelper.PERSONAS_ROOT);
    }

    @GetMapping("/gerente/{id}")
    public ModelAndView getGerente(@PathVariable("id") long id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.GERENTE_UPDATE);
        mAV.addObject("gerenteModel", gerenteService.findById(id));
        return mAV;
    }

    @PostMapping("/updategerente")
    public RedirectView update(@ModelAttribute("gerenteModel") GerenteModel gerenteModel) {
    	
        gerenteService.update(gerenteModel);
      
        return new RedirectView(ViewRouteHelper.PERSONAS_ROOT);
    }

    @PostMapping("/deletegerente/{id}")
    public RedirectView deleteGerente(@PathVariable("id") int id) {
        clienteService.remove(id);
        return new RedirectView(ViewRouteHelper.PERSONAS_ROOT);
    }
	/////////////////////////////////////FIN ABM GERENTES////////////////////////////////////////////////
    
    
    
	/////////////////////////////////////ABM CLIENTES////////////////////////////////////////////////
    @PostMapping("/agregarclienteyvolveraindex")
    public RedirectView create(@ModelAttribute("clienteModel") ClienteModel clienteModel){
        clienteService.insert(clienteModel);
        return new RedirectView(ViewRouteHelper.PERSONAS_ROOT);
    }

    @GetMapping("/cliente/{id}")
    public ModelAndView getCliente(@PathVariable("id") long id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_UPDATE);
        mAV.addObject("clienteModel", clienteService.findById(id));
        return mAV;
    }

    @PostMapping("/updatecliente")
    public RedirectView update(@ModelAttribute("clienteModel") ClienteModel clienteModel) {
    	
        clienteService.update(clienteModel);
      
        return new RedirectView(ViewRouteHelper.PERSONAS_ROOT);
    }

    @PostMapping("/deletecliente/{id}")
    public RedirectView deleteCliente(@PathVariable("id") int id) {
        clienteService.remove(id);
        return new RedirectView(ViewRouteHelper.PERSONAS_ROOT);
    }
	/////////////////////////////////////FIN ABM CLIENTES////////////////////////////////////////////////
    
    
    
   	/////////////////////////////////////ABM Vendedores////////////////////////////////////////////////
       @PostMapping("/agregarvendedoryvolveraindex")
       public RedirectView create(@ModelAttribute("vendedorModel") VendedorModel vendedorModel){
           vendedorService.insert(vendedorModel);
           return new RedirectView(ViewRouteHelper.PERSONAS_ROOT);
       }

       @GetMapping("/vendedor/{id}")
       public ModelAndView getVendedor(@PathVariable("id") long id) {
           ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENDEDOR_UPDATE);
           mAV.addObject("vendedorModel", vendedorService.findById(id));
           return mAV;
       }

       @PostMapping("/updatevendedor")
       public RedirectView update(@ModelAttribute("vendedorModel") VendedorModel vendedorModel) {
       	
           vendedorService.update(vendedorModel);
         
           return new RedirectView(ViewRouteHelper.PERSONAS_ROOT);
       }

       @PostMapping("/deletevendedor/{id}")
       public RedirectView deleteVendedor(@PathVariable("id") int id) {
           vendedorService.remove(id);
           return new RedirectView(ViewRouteHelper.PERSONAS_ROOT);
       }
   	/////////////////////////////////////FIN ABM Vendedores////////////////////////////////////////////////
       
       
       
    	
    
    
    
    
}
