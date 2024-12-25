package ar.com.maxi.challengemonitoring.repository;

import ar.com.maxi.challengemonitoring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("SELECT e FROM User e WHERE e.email= :email")
    Optional<User> findByEmail(String email);

}
