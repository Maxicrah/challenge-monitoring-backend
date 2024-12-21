package ar.com.maxi.challengemonitoring.repository;

import ar.com.maxi.challengemonitoring.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPlantRepository extends JpaRepository<Plant, Long> {

}
