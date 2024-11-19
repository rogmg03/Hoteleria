
package hoteleria.dao;

import hoteleria.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface RolDao  extends JpaRepository<Rol, Long> {
    
}
