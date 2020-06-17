package unla.proyectos.version2.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import unla.proyectos.version2.entities.Pedido;
import unla.proyectos.version2.entities.Producto;
import unla.proyectos.version2.helpers.ViewRouteHelper;
import unla.proyectos.version2.models.FechaBusqueda;
import unla.proyectos.version2.services.ILocalService;
import unla.proyectos.version2.services.IPedidoService;
import unla.proyectos.version2.services.IProductoService;
import unla.proyectos.version2.services.IVendedorService;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
 
@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;
	
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDOS_INDEX);
       
        //Clase Model sin persistencia
        FechaBusqueda f = new FechaBusqueda();
            
        //mAV.addObject("chartData", graphData);
    
       List<Pedido> pedidosAceptados =  pedidoService.traerAceptados();
       List<Pedido> pedidosCancelados = pedidoService.traerCancelados();
       List<Producto> productos = productoService.getAll();
       
       //Agrego las estaditicas
        mAV = graficoPedidos(pedidosAceptados, productos, mAV);
        
        mAV.addObject("pedidos", pedidosAceptados);
        mAV.addObject("pedidosC", pedidosCancelados);
        mAV.addObject("f", f);
        mAV.addObject("locales", localService.getAll());
        mAV.addObject("vendedores", vendedorService.getAll());
        
        return mAV;
    }
    
    @PostMapping("/entrefechas")
    public ModelAndView entreFechas(@ModelAttribute("f") FechaBusqueda f){
    	
    	ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDOS_FECHAS);
    	
        List<Pedido> pedidos = pedidoService.traerEntreFechas(f);
        List<Producto> productos = productoService.getAll();
    	
    	//Agrego las estaditicas
         mAV = graficoPedidos(pedidos, productos, mAV);
    	
         mAV.addObject("locales", localService.getAll());
    	 mAV.addObject("f", f);
    	 mAV.addObject("pedidos", pedidos);
    	 mAV.addObject("vendedores", vendedorService.getAll());
    	
        return mAV;
    }
    
    @PostMapping("/entrefechaslocal")
    public ModelAndView entreFechasLocal(@ModelAttribute("f") FechaBusqueda f){
    	
    	ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDOS_FECHAS);
    	
    	f.setLocal(localService.findById(f.getLocal().getId()));
    
    	List<Pedido> pedidos = pedidoService.traerEntreFechasLocal(f);
        List<Producto> productos = productoService.getAll();
    	
    	//Agrego las estaditicas
         mAV = graficoPedidos(pedidos, productos, mAV);
    	
         mAV.addObject("locales", localService.getAll());
    	 mAV.addObject("f", f);
    	 mAV.addObject("pedidos", pedidos);
    	 mAV.addObject("vendedores", vendedorService.getAll());
    	
        return mAV;
    }
    
    @PostMapping("/porvendedor")
    public ModelAndView porVendedor(@ModelAttribute("f") FechaBusqueda f){
    	
    	ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDOS_FECHAS);
    	
    	f.setVendedor(vendedorService.findByIdPersona(f.getVendedor().getId()));
    
    	List<Pedido> pedidos = pedidoService.traerEntreFechasVendedor(f);
        List<Producto> productos = productoService.getAll();
    	
    	//Agrego las estaditicas
         mAV = graficoPedidos(pedidos, productos, mAV);
    	
         mAV.addObject("locales", localService.getAll());
    	 mAV.addObject("f", f);
    	 mAV.addObject("pedidos", pedidos);
    	 mAV.addObject("vendedores", vendedorService.getAll());
    	
        return mAV;
    }
    

    public ModelAndView graficoPedidos(List<Pedido> pedidos, List<Producto> productos, ModelAndView mAV) {
    	ModelAndView modelAndView = mAV;
        Map<String, Integer> graphData = new TreeMap<>();
    	
    	 for(Producto pro: productos) {
         	int contadorProducto = 0;
         
         for(Pedido p: pedidos) {
         	if(p.getProducto().getNombre()==pro.getNombre()) {
         		contadorProducto = contadorProducto + p.getCantidad();
         	}
         }
         graphData.put(pro.getNombre(), contadorProducto);
         }
    	 modelAndView.addObject("chartData", graphData);
    	 
    	return modelAndView;
    }
}



