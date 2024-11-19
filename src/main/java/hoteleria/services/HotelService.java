
package hoteleria.services;

import hoteleria.domain.Hotel;
import java.util.List;


public interface HotelService {
    public List<Hotel> getHoteles(boolean activo);

    public Hotel getHotel(Hotel hotel);

    public void save(Hotel hotel);

    public void delete(Hotel hotel);
}
