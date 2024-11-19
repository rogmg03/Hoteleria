
package hoteleria.dao;

import hoteleria.domain.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ValoracionDao extends JpaRepository<Valoracion, Long> {
    
}
