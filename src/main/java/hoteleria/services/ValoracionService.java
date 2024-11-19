package hoteleria.services;

import hoteleria.domain.Valoracion;
import java.util.List;

public interface ValoracionService {

    public List<Valoracion> getValoraciones(boolean activo);

    public Valoracion getValoracion(Valoracion valoracion);

    public void save(Valoracion valoracion);

    public void delete(Valoracion valoracion);
}
