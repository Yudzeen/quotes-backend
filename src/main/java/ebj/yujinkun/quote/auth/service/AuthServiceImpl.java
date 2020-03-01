package ebj.yujinkun.quote.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebj.yujinkun.quote.auth.repository.AuthRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthRepository authRepository; 
	
	@Override
	public boolean isAuthorized(String apiKey) {
		return authRepository.exists(apiKey);
	}

}
