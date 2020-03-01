package ebj.yujinkun.auth.service;

import org.springframework.stereotype.Service;

@Service
public interface AuthService {
	
	boolean isAuthorized(String apikey);

}
