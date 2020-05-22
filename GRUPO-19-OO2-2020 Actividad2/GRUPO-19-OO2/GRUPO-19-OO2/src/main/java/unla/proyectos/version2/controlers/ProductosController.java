package unla.proyectos.version2.controlers;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import unla.proyectos.version2.entities.Local;
import unla.proyectos.version2.helpers.ViewRouteHelper;
import unla.proyectos.version2.models.GerenteModel;
import unla.proyectos.version2.models.ProductoModel;
import unla.proyectos.version2.models.StockModel;
import unla.proyectos.version2.models.LocalModel;
import unla.proyectos.version2.services.IGerenteService;
import unla.proyectos.version2.services.IProductoService;
import unla.proyectos.version2.services.IStockService;
import unla.proyectos.version2.services.ILocalService;

@Controller
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    @Qualifier("productoService")
    private IProductoService productoService;
    
    @Autowired
    @Qualifier("stockService")
    private IStockService stockService;
    
    
    @Autowired
    @Qualifier("localService")
    private ILocalService localService;
    
    @Autowired
    @Qualifier("gerenteService")
    private IGerenteService gerenteService;

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTOS_INDEX);
        
        
        mAV.addObject("productos", productoService.getAll());
		mAV.addObject("productoModel", new ProductoModel());
		
		 mAV.addObject("stocks", stockService.getAll());
		 mAV.addObject("stockModel", new StockModel());
		 
		 
		 mAV.addObject("locales", localService.getAll());
		 mAV.addObject("localModel", new LocalModel());
		 
		
		 
		 mAV.addObject("gerentes", gerenteService.getAll());
		 mAV.addObject("gerenteModel", new GerenteModel());
		 
		 
		 mAV.addObject("gerenteModel", new GerenteModel());
		
        return mAV;
    }



    
    ///////////////////////PRODUCTO//////////////////////////////////////////////////////////////////////////
    @PostMapping("/agregarproductoyvolveraindex")
    public RedirectView create(@ModelAttribute("productoModel") ProductoModel productoModel){
        productoService.insert(productoModel);
        return new RedirectView(ViewRouteHelper.PRODUCTOS_ROOT);
    }
    
   

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") long id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTOS_UPDATE);
        mAV.addObject("productoModel", productoService.findById(id));
        return mAV;
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("productoModel") ProductoModel productoModel) {
        productoService.update(productoModel);
        return new RedirectView(ViewRouteHelper.PRODUCTOS_ROOT);
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") int id) {
        productoService.remove(id);
        return new RedirectView(ViewRouteHelper.PRODUCTOS_ROOT);
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
    
    
    /////////////////////////////////////STOCK//////////////////////////////////////////////
    @PostMapping("/agregarstockyvolveraindex")
    public RedirectView create(@ModelAttribute("stockModel") StockModel stockModel){
    	
    	long idP = stockModel.getProducto().getId();
    	long idL = stockModel.getLocal().getId();
    	
    	ProductoModel p = productoService.findById(idP);
    	LocalModel l = localService.findById(idL);
    	
    	long idG =  l.getGerente().getId();
    	GerenteModel g = gerenteService.findByIdPersona(idG);
    	
    	stockModel.setProducto(p);
    	stockModel.setLocal(l);
    	stockModel.getLocal().setGerente(g);
    	
    	
    	System.out.print("-----STOCK NUEVOOOO-------");
    	System.out.print(stockModel.toString());
        stockService.insert(stockModel);
        return new RedirectView(ViewRouteHelper.PRODUCTOS_ROOT);
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    /////////////////////////////////////Local//////////////////////////////////////////////
    @PostMapping("/agregarlocalyvolveraindex")
    public RedirectView create(@ModelAttribute("localModel") LocalModel localModel){
    	
    	long idGerente = localModel.getGerente().getId();
    	System.out.println("ID DEL GERENTE DEL NUEVO LOCAL" +idGerente);
    	
    	GerenteModel g = 	gerenteService.findByIdPersona(idGerente);
    	System.out.println("Este es el generente" +g.toString());
    		
    	g.setId(idGerente);
    	
    	localModel.setGerente(g);
    	
    	System.out.println("Este es Local" +localModel.toString());
        localService.insertOrUpdate(localModel);
        return new RedirectView(ViewRouteHelper.PRODUCTOS_ROOT);
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    /////////////////////////////////////Local//////////////////////////////////////////////
    @PostMapping("/distancias")
    public ModelAndView distancias(@ModelAttribute("localModel") LocalModel localModel){
    	
    	//System.out.println(localModel.toString());
    	LocalModel l = localService.findById( localModel.getId());
    	
    	ArrayList <String>  distanciasDeSucursales= new ArrayList <String>();
    	
    	String texto = "El local de " +l.getLocalidad();
    	distanciasDeSucursales.add(texto);
    	
    	for(Local locales: localService.getAll()) {
    		
    		if(locales.getId()!=localModel.getId()) {
    		texto = "Dista del local de " +locales.getLocalidad() +"    "+String.valueOf(l.calcularDistancia(locales.getLatitud(), locales.getLongitud())) +"Km";
    		distanciasDeSucursales.add(texto);
    		}
    		System.out.print(texto);
    		
    	}
    	
    
    	System.out.println(l.toString());
    	//localModel.setGerente(gerenteService.findById(localModel.getGerente().getId()));
        //localService.insert(localModel);
    	ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISTANCIA_INDEX);
    	mAV.addObject("distanciasDeSucursales", distanciasDeSucursales);
        return mAV;
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
}
