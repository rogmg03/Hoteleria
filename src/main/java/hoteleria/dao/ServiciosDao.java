
package hoteleria.dao;

import hoteleria.domain.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ServiciosDao extends JpaRepository<Servicios, Long>{
    
}
