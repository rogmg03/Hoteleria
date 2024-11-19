package hoteleria.dao;

import hoteleria.domain.Mantenimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface MantenimientosDao extends JpaRepository<Mantenimientos, Long> {

}
