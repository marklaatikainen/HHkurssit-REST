package fi.markl.lukkarit.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fi.markl.lukkarit.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
	List<User> findAll();
}