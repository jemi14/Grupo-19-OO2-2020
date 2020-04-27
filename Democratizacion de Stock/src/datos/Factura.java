package datos;
import datos.ItemFactura;
import java.util.List;
import java.util.ArrayList;

public class Factura {
	
	private long idFactura;
	private List<ItemFactura>lstItemFacturas;
	private Empleado empleado;
	private Locales local;
	private float total;
	
	public Factura(long idFactura, Empleado empleado, Locales local, float total) {
		this.idFactura=idFactura;
		this.empleado=empleado;
		this.local=local;
		this.total=total;
		this.lstItemFacturas= new ArrayList<ItemFactura>();		
	}

	public long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}

	public List<ItemFactura> getLstItemFacturas() {
		return lstItemFacturas;
	}

	public void setLstItemFacturas(List<ItemFactura> lstItemFacturas) {
		this.lstItemFacturas = lstItemFacturas;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Locales getLocal() {
		return local;
	}

	public void setLocal(Locales local) {
		this.local = local;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", lstItemFacturas=" + lstItemFacturas + ", empleado=" + empleado
				+ ", local=" + local + ", total=" + total + "]";
	}
	

}
