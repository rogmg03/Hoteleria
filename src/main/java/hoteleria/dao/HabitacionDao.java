package hoteleria.dao;

import hoteleria.domain.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface HabitacionDao extends JpaRepository<Habitacion, Long> {

}
