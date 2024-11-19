
package hoteleria.services.impl;

import hoteleria.dao.ValoracionDao;
import hoteleria.domain.Valoracion;
import hoteleria.services.ValoracionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ValoracionServiceImpl implements ValoracionService {

    @Autowired
    private ValoracionDao valoracionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Valoracion> getValoraciones(boolean activo
    ) {
        var lista = valoracionDao.findAll();
        if (activo) {
            //se debe eliminar los inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Valoracion getValoracion(Valoracion valoracion
    ) {
        return valoracionDao.findById(valoracion.getIdValoracion()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Valoracion valoracion
    ) {
        valoracionDao.save(valoracion);
    }

    @Override
    @Transactional
    public void delete(Valoracion valoracion
    ) {
        valoracionDao.delete(valoracion);
    }
}
