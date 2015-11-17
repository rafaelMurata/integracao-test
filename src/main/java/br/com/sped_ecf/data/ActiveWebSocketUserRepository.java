package br.com.sped_ecf.data;

import java.util.List;

import br.com.sped_ecf.data.ActiveWebSocketUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ActiveWebSocketUserRepository extends CrudRepository<ActiveWebSocketUser,String> {

	@Query("select DISTINCT(u.username) from ActiveWebSocketUser u where u.username != ?#{principal?.username}")
	List<String> findAllActiveUsers();
}
