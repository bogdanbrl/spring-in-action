package tacos.repository;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import tacos.domain.Taco;

@Registered
public interface TacoRepository extends JpaRepository<Taco, Long> {

}
