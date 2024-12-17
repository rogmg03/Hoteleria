package hoteleria.services.impl;

import hoteleria.dao.HotelDao;
import hoteleria.domain.Hotel;
import hoteleria.services.HotelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotelDao;

    @Override
    @Transactional(readOnly = true)
    public List<Hotel> getHoteles(boolean activo
    ) {
        var lista = hotelDao.findAll();
        if (activo) {
            //se debe eliminar los inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Hotel getHotel(Hotel hotel
    ) {
        return hotelDao.findById(hotel.getIdHotel()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Hotel hotel
    ) {
        hotelDao.save(hotel);
    }

    @Override
    @Transactional
    public void delete(Hotel hotel
    ) {
        hotelDao.delete(hotel);
    }

    @Override
    public Hotel findById(Long idHotel) {
        return hotelDao.findByIdHotel(idHotel); 
    }
}
