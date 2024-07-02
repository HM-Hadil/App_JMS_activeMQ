package conding.spring.app_jms_activemq.reservation.repo;

import conding.spring.app_jms_activemq.reservation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<User,Long> {
}
