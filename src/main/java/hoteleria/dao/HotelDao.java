package hoteleria.dao;

import hoteleria.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface HotelDao extends JpaRepository<Hotel, Long> {
        
}
