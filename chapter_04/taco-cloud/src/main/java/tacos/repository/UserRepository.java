package tacos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tacos.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     *  fix the LazyInitializationException:
     *  Initializing associations with a LEFT JOIN FETCH clause
     */

    @Query("select u from User u left join fetch u.roles where u.username=?1 ")
    User findByUsername(String username);
}
