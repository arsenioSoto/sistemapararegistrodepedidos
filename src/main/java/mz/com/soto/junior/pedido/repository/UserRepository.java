package mz.com.soto.junior.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.com.soto.junior.pedido.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, String>{

	User findByUsername(String username);

	
}
