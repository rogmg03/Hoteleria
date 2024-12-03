package hoteleria.services.impl;

import hoteleria.dao.MantenimientosDao;
import hoteleria.domain.Mantenimientos;
import hoteleria.services.MantenimientosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MantenimientosServiceImpl implements MantenimientosService {

    @Autowired
    private MantenimientosDao mantenimientosDao;
    

    @Override
    @Transactional(readOnly = true)
    public List<Mantenimientos> getMantenimientoss(boolean activo
    ) {
        var lista = mantenimientosDao.findAll();
        if (activo) {
            //se debe eliminar los inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Mantenimientos getMantenimientos(Mantenimientos mantenimientos
    ) {
        return mantenimientosDao.findById(mantenimientos.getIdMantenimiento()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Mantenimientos mantenimientos
    ) {
        mantenimientosDao.save(mantenimientos);
    }

    @Override
    @Transactional
    public void delete(Mantenimientos mantenimientos
    ) {
        mantenimientosDao.delete(mantenimientos);
    }

}
