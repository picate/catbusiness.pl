package pl.business.cat.login.user;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u where u.username=?1")
	public User findByuserName(String name);
	
	@Query("Select u FROM User where u.email=?1")
	public Optional<User> findByEmail(String email);
}
