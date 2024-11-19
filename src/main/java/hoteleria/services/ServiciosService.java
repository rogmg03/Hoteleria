
package hoteleria.services;

import hoteleria.domain.Servicios;
import java.util.List;


public interface ServiciosService {
    public List<Servicios> getServicioss(boolean activo);

    public Servicios getServicios(Servicios servicios);

    public void save(Servicios servicios);

    public void delete(Servicios servicios);
}
