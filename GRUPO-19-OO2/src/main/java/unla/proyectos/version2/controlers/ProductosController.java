package unla.proyectos.version2.controlers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import unla.proyectos.version2.helpers.ViewRouteHelper;
import unla.proyectos.version2.models.GerenteModel;
import unla.proyectos.version2.models.ProductoModel;
import unla.proyectos.version2.models.StockModel;
import unla.proyectos.version2.models.SucursalModel;
import unla.proyectos.version2.services.IGerenteService;
import unla.proyectos.version2.services.IProductoService;
import unla.proyectos.version2.services.IStockService;
import unla.proyectos.version2.services.ISucursalService;

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
    @Qualifier("sucursalService")
    private ISucursalService sucursalService;
    
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
		 
		 
		 mAV.addObject("sucursales", sucursalService.getAll());
		 mAV.addObject("sucursalModel", new SucursalModel());
		 
		 mAV.addObject("gerentes", gerenteService.getAll());
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
    	
        stockService.insert(stockModel);
        return new RedirectView(ViewRouteHelper.PRODUCTOS_ROOT);
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    /////////////////////////////////////SUCURSAL//////////////////////////////////////////////
    @PostMapping("/agregarsucursalyvolveraindex")
    public RedirectView create(@ModelAttribute("sucursalModel") SucursalModel sucursalModel){
    	
    	sucursalModel.setGerente(gerenteService.findById(sucursalModel.getGerente().getId()));
        sucursalService.insert(sucursalModel);
        return new RedirectView(ViewRouteHelper.PRODUCTOS_ROOT);
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
}
