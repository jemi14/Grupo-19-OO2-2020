package unla.proyectos.version2.controlers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import unla.proyectos.version2.helpers.ViewRouteHelper;
import unla.proyectos.version2.models.ClienteModel;
import unla.proyectos.version2.models.GerenteModel;
import unla.proyectos.version2.models.LocalModel;
import unla.proyectos.version2.models.ProductoModel;
import unla.proyectos.version2.models.StockModel;
import unla.proyectos.version2.models.VendedorModel;







@Controller
@RequestMapping("/")
public class InicioController {
	
	
	
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX);
        
        
       
		 
	
		
        return mAV;
    }
}
