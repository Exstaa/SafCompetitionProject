package az.hafizrzazade.safproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import az.hafizrzazade.safproject.model.RobotData;
import az.hafizrzazade.safproject.repository.RobotDataRepository;

@RestController
@CrossOrigin
public class RobotController {

	@Autowired
	private RobotDataRepository robotRepo;

	@GetMapping("/getLatest")
	public ResponseEntity<RobotData> getLatestRobotData() {
		RobotData resultData = robotRepo.findTopByOrderBySentAtDesc();
		return new ResponseEntity<RobotData>(resultData, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<RobotData>> getAllRobotDatas() {
		List<RobotData> datas = robotRepo.findAll();
		return new ResponseEntity<List<RobotData>>(datas, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteRobotData(@PathVariable Integer id) {
		robotRepo.deleteById(id);
		return "data with id " + id + " is deleted";
	}

	@PutMapping("/update")
	public ResponseEntity<RobotData> updateRobotData(@RequestBody RobotData r) {
		RobotData resultData = robotRepo.save(r);
		return new ResponseEntity<RobotData>(resultData, HttpStatus.ACCEPTED);
	}
}
