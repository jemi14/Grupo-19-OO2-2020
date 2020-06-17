package unla.proyectos.version2.controlers;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import unla.proyectos.version2.helpers.ViewRouteHelper;



import org.springframework.security.core.userdetails.User;







@Controller
@RequestMapping("/")
public class InicioController {
	
	
	
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX);
        
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mAV.addObject("username", user.getUsername());
       
		 
	
		
        return mAV;
    }
}
