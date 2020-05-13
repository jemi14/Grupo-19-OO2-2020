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
import unla.proyectos.version2.models.ProductoModel;
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
	

	;
	
	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		
		
		
		GerenteModel g1 = new GerenteModel("Griselda", "Benitez", null, 1111111, 130, 120000 );
		GerenteModel g2 = new GerenteModel("Leandro", "Haugg", null, 1222222, 1231, 220000 );
		GerenteModel g3 = new GerenteModel("Ramiro", "Benitez", null, 133333, 123321, 320000 );
		
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
		gerenteService.insert(g1);gerenteService.insert(g2);gerenteService.insert(g3);
		
		productoService.insert(p1);productoService.insert(p2);productoService.insert(p3);
		

		
		
		/*
		StockModel s1 = new StockModel(p1,12,null);
		StockModel s2 = new StockModel(p1,11,null);
		StockModel s3 = new StockModel(p1,4,null);
		StockModel s4 = new StockModel(p2,120,null);
		StockModel s5 = new StockModel(p2,101,null);
		StockModel s6 = new StockModel(p3,2,null);
		
		SucursalModel sucu1 = new SucursalModel("Banfield", "Rodriguez", 1111,1234l,34.33f,66.23f,g1);
		SucursalModel sucu2 = new SucursalModel("Banfiel", "Araoz", 211,22222l,34.885f,66.83f,g2);
		SucursalModel sucu3 = new SucursalModel("Lomas", "Av.Siempre", 211 ,2222l,31.885f,661.83f,g3);
		
		
		stockService.insert(s1);stockService.insert(s2);stockService.insert(s3);
		stockService.insert(s4);stockService.insert(s5);stockService.insert(s6);
				
				*/
		

				
		
		
		
		
		
		
		
		return new RedirectView(ViewRouteHelper.PRODUCTOS_ROOT);
	}
}
