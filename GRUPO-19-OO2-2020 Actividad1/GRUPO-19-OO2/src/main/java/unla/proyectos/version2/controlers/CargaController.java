package unla.proyectos.version2.controlers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.view.RedirectView;

import unla.proyectos.version2.helpers.ViewRouteHelper;
import unla.proyectos.version2.models.ClienteModel;
import unla.proyectos.version2.models.GerenteModel;
import unla.proyectos.version2.models.LocalModel;
import unla.proyectos.version2.models.ProductoModel;
import unla.proyectos.version2.models.StockModel;
import unla.proyectos.version2.models.VendedorModel;
import unla.proyectos.version2.services.IClienteService;
import unla.proyectos.version2.services.IGerenteService;
import unla.proyectos.version2.services.ILocalService;
import unla.proyectos.version2.services.IProductoService;
import unla.proyectos.version2.services.IStockService;
import unla.proyectos.version2.services.IVendedorService;






@Controller
@RequestMapping("/cargar")
public class CargaController {
	
	@Autowired
	@Qualifier("gerenteService")
	private IGerenteService gerenteService;
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	
	@Autowired
	@Qualifier("stockService")
	private IStockService stockService;
	

	;
	
	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		
		
		
		GerenteModel g1 = new GerenteModel("Griselda", "Benitez", null, 1111111,  120000 );
		GerenteModel g2 = new GerenteModel("Leandro", "Haugg", null, 1222222,  220000 );
		GerenteModel g3 = new GerenteModel("Ramiro", "Benitez", null, 133333, 320000 );
		
		VendedorModel v1 = new VendedorModel("Jorge", "Garcia", null, 2111111,12000, null,0 );
		VendedorModel v2 = new VendedorModel("Raul", "Baldi", null,  2222222,13330, null,11 );
		VendedorModel v3 = new VendedorModel("Raul", "Jaramillo", null, 233333,15000, null,23 );
				
		
		ClienteModel c1 = new ClienteModel("Raul", "Ortiz", null, 3111111, "r@mail");
		ClienteModel c2 = new ClienteModel("Lara", "Muniz", null, 3222222, "l@mail");
		ClienteModel c3 = new ClienteModel("Lucas", "Perez", null, 3233333, "ul@mail");
		
		
		ProductoModel p1 = new ProductoModel( "EL mas rico", 123.5f,"Chocolate");
		ProductoModel p2 = new ProductoModel( "Baratito", 13.5f,"Kinder");
		ProductoModel p3 = new ProductoModel( "Duro pero rico", 11f,"Caramelo");
		
		
		vendedorService.insert(v1);vendedorService.insert(v2);vendedorService.insert(v3);
		clienteService.insert(c1);clienteService.insert(c2);clienteService.insert(c3);
		gerenteService.insertOrUpdate(g1);gerenteService.insertOrUpdate(g2);gerenteService.insertOrUpdate(g3);
		
		productoService.insert(p1);productoService.insert(p2);productoService.insert(p3);
		
		
		
		
		LocalModel local1 = new LocalModel("Banfield", "Rodriguez", 1111,1234l,-34.42f,-58.23f,gerenteService.findByIdPersona(7));
		LocalModel local2 = new LocalModel("Lanus", "Alfonsin", 22222,12224l,-34.45f,-58.22f,gerenteService.findByIdPersona(8));
		LocalModel local3 = new LocalModel("Resistencia", "Chaco", 333,12224l,-27.45f,-58.98f,gerenteService.findByIdPersona(9));
		
		localService.insertOrUpdate(local1);
		localService.insertOrUpdate(local2);
		localService.insertOrUpdate(local3);

		
		
		StockModel s1 = new StockModel(productoService.findById(1),localService.findById(1),12,null);
		StockModel s2 = new StockModel(productoService.findById(1),localService.findById(2),11,null);
		StockModel s3 = new StockModel(productoService.findById(2),localService.findById(2),4,null);
		StockModel s4 = new StockModel(productoService.findById(2),localService.findById(3),120,null);
		StockModel s5 = new StockModel(productoService.findById(2),localService.findById(3),101,null);
		StockModel s6 = new StockModel(productoService.findById(3),localService.findById(1),2,null);
		
		
	
		
		
		stockService.insert(s1);stockService.insert(s2);stockService.insert(s3);
		stockService.insert(s4);stockService.insert(s5);stockService.insert(s6);
				
				
		

				
		
		
		
		
		
		
		
		return new RedirectView(ViewRouteHelper.PRODUCTOS_ROOT);
	}
}
