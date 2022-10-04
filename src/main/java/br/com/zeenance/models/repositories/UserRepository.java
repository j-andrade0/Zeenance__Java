package br.com.zeenance.models.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.zeenance.models.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
