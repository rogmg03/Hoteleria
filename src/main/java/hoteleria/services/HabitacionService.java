package hoteleria.services;

import hoteleria.domain.Habitacion;
import java.util.List;

public interface HabitacionService {

    public List<Habitacion> getHabitaciones(boolean activo);

    public Habitacion getHabitacion(Habitacion habitacion);

    public void save(Habitacion habitacion);

    public void delete(Habitacion habitacion);
    
    public List<Habitacion> findByIdHotel(Long idHotel);

}
