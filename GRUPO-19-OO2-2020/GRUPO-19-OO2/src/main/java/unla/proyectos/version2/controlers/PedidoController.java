package unla.proyectos.version2.controlers;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;


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

import unla.proyectos.version2.entities.Pedido;
import unla.proyectos.version2.entities.Producto;
import unla.proyectos.version2.helpers.ViewRouteHelper;
import unla.proyectos.version2.models.FechaBusqueda;
import unla.proyectos.version2.models.PedidoModel;
import unla.proyectos.version2.models.ProductoModel;
import unla.proyectos.version2.models.VendedorModel;
import unla.proyectos.version2.services.ILocalService;
import unla.proyectos.version2.services.IPedidoService;
import unla.proyectos.version2.services.IProductoService;
import unla.proyectos.version2.services.IVendedorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 











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
    
    
    @PostMapping("/sueldo")
    public ModelAndView sueldo(@ModelAttribute("f") FechaBusqueda f){
    	
    	ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDOS_FECHAS_SUELDO);
    	
    	//ojo no anda en diciembre, despues lo veo :) 
    	LocalDate desde = LocalDate.of(2020, f.getMes(), 1);
    	LocalDate hasta = LocalDate.of(2020, f.getMes()+1, 1);
    	f.setFechaDesde(desde);
    	f.setFechaHasta(hasta);
    	
    
    	System.out.println("DESDE: " +f.getFechaDesde()) ;
    	System.out.println("HASTA: " +f.getFechaHasta()) ;
    	
    	f.setVendedor(vendedorService.findByIdPersona(f.getVendedor().getId()));
    
    	
    
    	
    	List<Pedido> pedidos = pedidoService.traerEntreFechasVendedor(f);
        List<Producto> productos = productoService.getAll();
    	
        System.out.println("MEEES" +f.getMes());
        System.out.println(pedidos);
        
    	String textoReciboSueldo = pedidoService.calcularSueldo(pedidos);
    	
    	//Agrego las estaditicas
         mAV = graficoPedidos(pedidos, productos, mAV);
    	
         mAV.addObject("locales", localService.getAll());
    	 mAV.addObject("f", f);
    	 mAV.addObject("pedidos", pedidos);
    	  mAV.addObject("vendedores", vendedorService.getAll());
    	  mAV.addObject("textoReciboSueldo", textoReciboSueldo);
    	
        
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
    
    
    
    
    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") long id) throws FileNotFoundException, DocumentException {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDOS_INDEX);
        
        
       PedidoModel p = pedidoService.findById(id);
       
       System.out.println(p.toString());
       
       
       
       // Se crea el documento
       Document documento = new Document();
       
       String nombreArchivo = "factura-"+p.getId();

       // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
       FileOutputStream ficheroPdf = new FileOutputStream(nombreArchivo+".pdf");

       // Se asocia el documento al OutputStream y se indica que el espaciado entre
       // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
       PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

       // Se abre el documento.
       documento.open();
       
       String espacio = "                                                                                      ";
       documento.add(new Paragraph(espacio +"Sucursal: " +p.getLocal().getLocalidad()));
       documento.add(new Paragraph(espacio +"Direccion: " +p.getLocal().getCalle()));
       documento.add(new Paragraph(espacio +"Numero: " +p.getLocal().getNumero()));
       documento.add(new Paragraph(espacio +"TEL: " +p.getLocal().getTelefono()));
       documento.add(new Paragraph(espacio +"Factura Nro: " +10000000+p.getId()));
       documento.add(new Paragraph("-------------------------------------------------------------------------------------------------------------"));
       documento.add(new Paragraph("COMPRADOR"));
       documento.add(new Paragraph("Nombre y apellido:                " +p.getCliente().getNombre() +"  ,  " +p.getCliente().getApellido()));
       documento.add(new Paragraph("DNI y contacto:                " +p.getCliente().getDni() +"    //    " +p.getCliente().getMail()));
       documento.add(new Paragraph("-------------------------------------------------------------------------------------------------------------"));
       documento.add(new Paragraph("VENDEDOR"));
       documento.add(new Paragraph("Nombre y apellido:                " +p.getVendedor().getNombre() +"  ,  " +p.getVendedor().getApellido()));
       documento.add(new Paragraph("DNI:                " +p.getVendedor().getDni() ));
       documento.add(new Paragraph("Pedido realizado el:                " +p.getFechaPedido()));
       documento.add(new Paragraph("Entrega estimada:                " +p.getFechaEntrega()));
       documento.add(new Paragraph("-------------------------------------------------------------------------------------------------------------"));
       documento.add(new Paragraph("-------------------------------------------------------------------------------------------------------------"));
       documento.add(new Paragraph("PRODUCTO                  CANTIDAD                 PRECIO                     TOTAL"));
       documento.add(new Paragraph("-------------------------------------------------------------------------------------------------------------"));
       documento.add(new Paragraph(p.getProducto().getNombre() +"                           " +p.getCantidad() +"                           $ " +
    		   p.getProducto().getPrecioUnitario() +"                           $ "+(p.getCantidad()*p.getProducto().getPrecioUnitario()) ));
       
       //Dejo renglones
       for(int i =0; i<15; i++) {
    	   documento.add(new Paragraph(" "));
       }
    
       documento.add(new Paragraph("---------------------------------------------------------------------------------------> $" +
    		   +(p.getCantidad()*p.getProducto().getPrecioUnitario())));
       
       documento.add(new Paragraph("Descripcion------------------------------------------------------------------------------------------------"));
       documento.add(new Paragraph(p.getDescripcion()));
       
       
       
       documento.close();
        
     
        
        
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
    
    
    
}



