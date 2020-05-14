package unla.proyectos.version2.services;



import java.util.List;

import unla.proyectos.version2.entities.Local;
import unla.proyectos.version2.models.LocalModel;

public interface ILocalService {

    public List<Local> getAll();

    public LocalModel findById(long id);

    public LocalModel insert(LocalModel localModelModel);

    public LocalModel update(LocalModel localModel);

    public boolean remove(long id);
}
