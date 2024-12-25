package ar.com.maxi.challengemonitoring.repository;

import ar.com.maxi.challengemonitoring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.roleName = :name")
    Role findByName(String name);

}
