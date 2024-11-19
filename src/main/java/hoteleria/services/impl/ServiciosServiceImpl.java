package hoteleria.services.impl;

import hoteleria.dao.ServiciosDao;
import hoteleria.domain.Servicios;
import hoteleria.services.ServiciosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiciosServiceImpl implements ServiciosService {

    @Autowired
    private ServiciosDao serviciosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Servicios> getServicioss(boolean activo
    ) {
        var lista = serviciosDao.findAll();
        if (activo) {
            //se debe eliminar los inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Servicios getServicios(Servicios servicios
    ) {
        return serviciosDao.findById(servicios.getIdServicio()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Servicios servicios
    ) {
        serviciosDao.save(servicios);
    }

    @Override
    @Transactional
    public void delete(Servicios servicios
    ) {
        serviciosDao.delete(servicios);
    }
}
