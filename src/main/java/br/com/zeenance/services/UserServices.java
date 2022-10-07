package br.com.zeenance.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zeenance.exceptions.ResourceNotFoundException;

import br.com.zeenance.models.entities.User;
import br.com.zeenance.models.repositories.UserRepository;

@Service
public class UserServices {
		
	private Logger logger = Logger.getLogger(UserServices.class.getName());
	
	@Autowired
	UserRepository repository;
	
	public List<User> findAll() {
		logger.info("Finding all people!");
		return repository.findAll();
	}
	
	public User findById(Long id) {
		logger.info("Finding one person!");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public User create(User user) {
		logger.info("Creating a person");
		return repository.save(user);
	}
	
	public User update(User user) {
		logger.info("Updating a person");
		
		User entity = repository.findById(user.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		entity.setEmail(user.getEmail());
		entity.setPassword(user.getPassword());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deleting a person");
		
		User entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}
}
