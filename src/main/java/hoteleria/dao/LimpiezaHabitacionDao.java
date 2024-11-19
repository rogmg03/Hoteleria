package hoteleria.dao;

import hoteleria.domain.LimpiezaHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface LimpiezaHabitacionDao extends JpaRepository<LimpiezaHabitacion, Long> {

}
