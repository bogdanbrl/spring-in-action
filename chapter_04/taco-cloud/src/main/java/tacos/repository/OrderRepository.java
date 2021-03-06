package tacos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tacos.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
