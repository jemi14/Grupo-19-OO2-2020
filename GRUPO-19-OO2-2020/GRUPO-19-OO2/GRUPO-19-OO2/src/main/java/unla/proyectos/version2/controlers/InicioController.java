package unla.proyectos.version2.controlers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.view.RedirectView;

import unla.proyectos.version2.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/")
public class InicioController {
	
	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView(ViewRouteHelper.PRODUCTOS_ROOT);
	}
}
