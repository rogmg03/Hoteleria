
package hoteleria.services;

import hoteleria.domain.LimpiezaHabitacion;
import java.util.List;


public interface LimpiezaHabitacionService {
    public List<LimpiezaHabitacion> getLimpiezaHabitaciones(boolean activo);

    public LimpiezaHabitacion getLimpiezaHabitacion(LimpiezaHabitacion limpiezahabitacion);

    public void save(LimpiezaHabitacion limpiezahabitacion);

    public void delete(LimpiezaHabitacion limpiezahabitacion);
}
