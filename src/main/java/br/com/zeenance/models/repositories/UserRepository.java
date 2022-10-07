package br.com.zeenance.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zeenance.models.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
