package hoteleria.services.impl;

import hoteleria.dao.HabitacionDao;
import hoteleria.domain.Habitacion;
import hoteleria.services.HabitacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitacionServiceImpl implements HabitacionService {

    @Autowired
    private HabitacionDao habitacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Habitacion> getHabitaciones(boolean activo
    ) {
        var lista = habitacionDao.findAll();
        if (activo) {
            //se debe eliminar los inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Habitacion getHabitacion(Habitacion habitacion
    ) {
        return habitacionDao.findById(habitacion.getIdHabitacion()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Habitacion habitacion
    ) {
        habitacionDao.save(habitacion);
    }

    @Override
    @Transactional
    public void delete(Habitacion habitacion
    ) {
        habitacionDao.delete(habitacion);
    }

    @Override
    public List<Habitacion> findByIdHotel(Long idHotel) {
        return habitacionDao.findByHotel_IdHotel(idHotel);
    }
    
    @Override
    public Habitacion getHabitacionById(Long id) {
    return habitacionDao.findById(id).orElse(null);
}


}
