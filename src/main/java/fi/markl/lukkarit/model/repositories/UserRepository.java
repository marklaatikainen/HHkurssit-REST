package fi.markl.lukkarit.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fi.markl.lukkarit.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

	List<User> findAll();

	@Modifying
	@Transactional
	@Query(value = "update app_user set username = :username, first_name = :firstname, last_name = :lastname, user_group = :usergroup, password = :password where id = :userid", nativeQuery = true)
	void update(@Param("username") String username, @Param("firstname") String firstname,
			@Param("lastname") String lastname, @Param("usergroup") String usergroup,
			@Param("password") String password, @Param("userid") long userid);
}