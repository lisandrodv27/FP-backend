package com.qa.service;

import java.util.List;
import java.util.Optional;

importpackage com.qa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.exceptions.TraineeNotFoundException;
import com.qa.rest.Trainee;
import com.qa.rest.TraineeRepository;

@Service
public class TraineeService {

	@Autowired
	private TraineeRepository repository;

	private TraineeService(TraineeRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Trainee> getTrainee() {
		return this.repository.findAll();
	}

	public Trainee createTrainee(Trainee trainee) {
		return this.repository.save(profile);
	}

//delete trainee
 // public boolean deleteTrainee(Long id) {
	//	this.repository.deleteById(id);
	//	return !this.repository.existsById(id);
	//}

// update trainee
//	public Trainee updateTrainee(Trainee trainee, Long id) {
//		Optional<Trainee> optTrainee = this.repository.findById(id);
//		Trainee oldTrainee = optTrainee.orElseThrow(() -> new TraineeNotFoundException());

	//	oldTrainee.setTraineeID(trainee.getTraineeID());
	//  oldTrainee.setFirstName(trainee.getFirstName());
  //	oldTrainee.setSecondName(trainee.getSecondName());
  //  oldTrainee.setCohort(trainee.getCohort());
  //  oldTrainee.setPassword(trainee.getPassword());
    
	//	Trainee updatedTrainee = this.repository.save(oldTrainee);
	//	return updatedTrainee;

	//}
} 
