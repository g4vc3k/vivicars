package pl.wypozyczalnia.vivicars.repository;

import pl.wypozyczalnia.vivicars.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
//    List<User> findUsersByAuthorityId(Long authorityId);
    List<User> findByUsernameContaining(String username);
    List<User> findByEnabled(boolean enabled);
    User findByUsername(String username);
    void deleteById(long id);
}