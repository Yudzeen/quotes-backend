package ebj.yujinkun.auth.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository {
	
	boolean exists(String apikey);

}
