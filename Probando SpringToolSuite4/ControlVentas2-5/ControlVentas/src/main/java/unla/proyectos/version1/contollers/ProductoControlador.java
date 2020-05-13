package unla.proyectos.version1.contollers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import unla.proyectos.version1.helpers.ViewRouteHelper;
import unla.proyectos.version1.models.ProductoModelo;
import unla.proyectos.version1.services.IProductoService;



@Controller
@RequestMapping("/productos")
//entrando a /productos se ejecuta este controlador
public class ProductoControlador {

	
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	
	//si se agrega un / se llega a este metodo que te lleva al index, mandando como parametro productos y producto
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_INDEX);
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("productoModelo", new ProductoModelo());
		return mAV;
	}
	
	
	//dentro de  /, tenemos el metodo post, llamado "/", que recibe un producto  y lo inserta, esto nos manda a root otra vez, root es /productos
	@PostMapping("/agregarproductoyvolveraindex")
	public RedirectView create(@ModelAttribute("productoModelo") ProductoModelo productoModelo) {
		productoService.insertOrUpdate(productoModelo);
		return new RedirectView(ViewRouteHelper.PRODUCTO_ROOT);
	}
	
	
	/*
	//agregando productos/form, se ejecuta este metodo,  que envia un producto al root
	@GetMapping("/form")
	public String producto(Model model) {
		model.addAttribute("producto", new ProductoModelo());
		return ViewRouteHelper.PRODUCTO_FORM;
	}
	
	
	//post llamado "/new" 
	@PostMapping("/new")
	public ModelAndView newproducto(@Valid @ModelAttribute("producto") ProductoModelo producto, BindingResult bindingResult) {
		ModelAndView mV = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mV.setViewName(ViewRouteHelper.PRODUCTO_FORM);
		} else {
			mV.setViewName(ViewRouteHelper.PRODUCTO_NEW);
			mV.addObject("producto", producto);
		}
		return mV;
	}
	*/
}


