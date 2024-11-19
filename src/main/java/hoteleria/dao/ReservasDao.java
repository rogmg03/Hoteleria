package hoteleria.dao;

import hoteleria.domain.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ReservasDao extends JpaRepository<Reservas, Long> {

}
