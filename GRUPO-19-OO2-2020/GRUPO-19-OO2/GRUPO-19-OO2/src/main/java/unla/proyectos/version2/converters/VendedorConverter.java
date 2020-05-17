package unla.proyectos.version2.converters;

import org.springframework.stereotype.Component;

import unla.proyectos.version2.entities.Vendedor;
import unla.proyectos.version2.models.VendedorModel;



@Component("vendedorConverter")
public class VendedorConverter {

	public VendedorModel entityToModel(Vendedor vendedor){
        return new VendedorModel(vendedor.getId(), vendedor.getNombre(), vendedor.getApellido(), vendedor.getFechaDeNacimiento(), vendedor.getDni(),vendedor.getExtra(), vendedor.getHorasPorJornada(), vendedor.getSueldoBasico());
    }

    public Vendedor modelToEntity(VendedorModel vendedorModel){
        return new Vendedor(vendedorModel.getNombre(), vendedorModel.getApellido(), vendedorModel.getFechaDeNacimiento(), vendedorModel.getDni(), vendedorModel.getExtra(), vendedorModel.getHorasPorJornada(), vendedorModel.getSueldoBasico());
    }
    
}
