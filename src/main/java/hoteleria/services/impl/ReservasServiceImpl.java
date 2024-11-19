package hoteleria.services.impl;

import hoteleria.dao.ReservasDao;
import hoteleria.domain.Reservas;
import hoteleria.services.ReservasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservasServiceImpl implements ReservasService {

    @Autowired
    private ReservasDao reservasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reservas> getReservaciones(boolean activo
    ) {
        var lista = reservasDao.findAll();
        if (activo) {
            //se debe eliminar los inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Reservas getReservas(Reservas reservas
    ) {
        return reservasDao.findById(reservas.getIdReserva()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reservas reservas
    ) {
        reservasDao.save(reservas);
    }

    @Override
    @Transactional
    public void delete(Reservas reservas
    ) {
        reservasDao.delete(reservas);
    }


}
