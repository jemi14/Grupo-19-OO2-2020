package unla.proyectos.version2.controlers;



import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import unla.proyectos.version2.helpers.ViewRouteHelper;
import unla.proyectos.version2.models.ClienteModel;
import unla.proyectos.version2.models.GerenteModel;
import unla.proyectos.version2.models.LocalModel;
import unla.proyectos.version2.models.PedidoModel;
import unla.proyectos.version2.models.ProductoModel;
import unla.proyectos.version2.models.StockModel;
import unla.proyectos.version2.models.VendedorModel;
import unla.proyectos.version2.services.IClienteService;
import unla.proyectos.version2.services.ILocalService;
import unla.proyectos.version2.services.IPedidoService;
import unla.proyectos.version2.services.IPersonaService;
import unla.proyectos.version2.services.IProductoService;
import unla.proyectos.version2.services.IStockService;


@Controller
@RequestMapping("/compras")
public class ComprasController {

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
    @Qualifier("clienteService")
    private IClienteService clienteService;
    
    
    @Autowired
    @Qualifier("pedidoService")
    private IPedidoService pedidoService;
    
    
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.COMPRAS_INDEX);
        
        
        mAV.addObject("productos", productoService.getAll());
		mAV.addObject("productoModel", new ProductoModel());
		
		 mAV.addObject("stocks", stockService.getAll());
		 mAV.addObject("stockModel", new StockModel());
		 
		 
		
		 
	
	
		
        return mAV;
    }

    
    

    @GetMapping("/compra/{id}")
    public ModelAndView get(@PathVariable("id") long id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.COMPRAS_UPDATE);
        
        ProductoModel p = productoService.findById(id);
        
        //Mando a la web el producto que quiere comprar el usuario
        mAV.addObject("productoModel", p);
        
        int cantidad = stockService.totalPorProducto(p);
        
       //Mando a la web la cantidad total de lproducto, para usarla de limite
        mAV.addObject("cantidadTotal", cantidad);
        
 
        
        mAV.addObject("locales", localService.getAll());
        
        
        mAV.addObject("clientes", clienteService.getAll());
        
        
        PedidoModel pedidoModel = new PedidoModel();
        
        
        
        //mando un pedido vacio para completar los campos
        mAV.addObject("pedidoModel", pedidoModel);
        
        
       
        return mAV;
    }
    
    
    @PostMapping("/compra/update")
    public  ModelAndView update(@ModelAttribute("pedidoModel") PedidoModel pedidoModel) {
    
   
    	
    	pedidoModel.setProducto(productoService.findById(pedidoModel.getProducto().getId()));
    	
    	
    	pedidoModel.setLocal(localService.findById(pedidoModel.getLocal().getId()));
    	
    	pedidoModel.setCliente(clienteService.findByIdPersona(pedidoModel.getCliente().getId()));
    	
    	
    	pedidoModel.setFechaPedido(LocalDate.now());
    	
    	
    	pedidoModel = stockService.calculoDescripcionPedido(pedidoModel);
    	
    	
    
    	
    	
    	pedidoModel = pedidoService.insertOrUpdate(pedidoModel);
    	
         ModelAndView mAV = new ModelAndView(ViewRouteHelper.COMPRAS_PEDIDO);
    	  
      
		mAV.addObject("pedidoModel", pedidoModel);
		
		
		 
    	
        //productoService.update(productoModel);
        return mAV;
    }





    
   
    
    
    
    
}
