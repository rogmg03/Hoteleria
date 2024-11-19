
package hoteleria.services.impl;

import hoteleria.dao.LimpiezaHabitacionDao;
import hoteleria.domain.LimpiezaHabitacion;
import hoteleria.services.LimpiezaHabitacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LimpiezaHabitacionServiceImpl implements LimpiezaHabitacionService {

    @Autowired
    private LimpiezaHabitacionDao limpiezahabitacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<LimpiezaHabitacion> getLimpiezaHabitaciones(boolean activo
    ) {
        var lista = limpiezahabitacionDao.findAll();
        if (activo) {
            //se debe eliminar los inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public LimpiezaHabitacion getLimpiezaHabitacion(LimpiezaHabitacion limpiezahabitacion
    ) {
        return limpiezahabitacionDao.findById(limpiezahabitacion.getIdLimpieza()).orElse(null);
    }

    @Override
    @Transactional
    public void save(LimpiezaHabitacion limpiezahabitacion
    ) {
        limpiezahabitacionDao.save(limpiezahabitacion);
    }

    @Override
    @Transactional
    public void delete(LimpiezaHabitacion limpiezahabitacion
    ) {
        limpiezahabitacionDao.delete(limpiezahabitacion);
    }
}

