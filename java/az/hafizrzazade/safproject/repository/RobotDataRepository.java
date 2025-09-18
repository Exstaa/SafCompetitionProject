package az.hafizrzazade.safproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.hafizrzazade.safproject.model.RobotData;

@Repository
public interface RobotDataRepository extends JpaRepository<RobotData, Integer>{
	RobotData findTopByOrderBySentAtDesc();
}
