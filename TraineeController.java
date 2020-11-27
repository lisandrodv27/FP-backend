import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.service.TraineeService;

@RestController
@CrossOrigin
public class TraineeController {

	private TraineeService service;

	private TraineeController(TraineeService service) {
		super();
		this.service = service;
	}

	//Create a trainee- signing up
	@PostMapping("/create")
	public ResponseEntity<Trainee> createTrainee(@RequestBody Trainee trainee) {
		return new ResponseEntity<Trainee>(this.service.createTrainee(trainee), HttpStatus.CREATED);
	}
	//Get trainee name when signing in
	@GetMapping("/get")
	public ResponseEntity<List<Trainee>> getTrainee() {
		return ResponseEntity.ok(this.service.getTrainee());
	}

	
	//@PutMapping("/update")
	//public ResponseEntity<Trainee> updateTicket(@RequestBody Trainee trainee, @PathParam("id") Long id) {
	//	return new ResponseEntity<Trainee>(this.service.updateTrainee(trainee, id), HttpStatus.ACCEPTED);
	//}

}
