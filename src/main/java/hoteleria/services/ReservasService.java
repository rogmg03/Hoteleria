
package hoteleria.services;

import hoteleria.domain.Reservas;
import java.util.List;


public interface ReservasService {
    public List<Reservas> getReservaciones(boolean activo);

    public Reservas getReservas(Reservas reservas);

    public void save(Reservas reservas);

    public void delete(Reservas reservas);
}
