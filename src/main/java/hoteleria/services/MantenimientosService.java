
package hoteleria.services;

import hoteleria.domain.Mantenimientos;
import java.util.List;


public interface MantenimientosService {
    public List<Mantenimientos> getMantenimientoss(boolean activo);

    public Mantenimientos getMantenimientos(Mantenimientos Mantenimientos);

    public void save(Mantenimientos Mantenimientos);

    public void delete(Mantenimientos Mantenimientos);
}
