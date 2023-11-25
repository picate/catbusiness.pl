package pl.business.cat.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import pl.business.cat.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
	

}
