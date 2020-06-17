package unla.proyectos.version2.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import unla.proyectos.version2.helpers.ViewRouteHelper;

    @Controller
    @RequestMapping("/")
    public class InicioController {

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX);
       
        return mAV;
    }
}
