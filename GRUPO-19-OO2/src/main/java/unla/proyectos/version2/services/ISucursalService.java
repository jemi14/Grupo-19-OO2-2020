package unla.proyectos.version2.services;



import java.util.List;

import unla.proyectos.version2.entities.Sucursal;
import unla.proyectos.version2.models.SucursalModel;

public interface ISucursalService {

    public List<Sucursal> getAll();

    public SucursalModel findById(long id);

    public SucursalModel insert(SucursalModel sucursalModelModel);

    public SucursalModel update(SucursalModel sucursalModel);

    public boolean remove(long id);
}
