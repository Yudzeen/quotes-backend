package ebj.yujinkun.auth.service;

import org.springframework.beans.factory.annotation.Autowired;

import ebj.yujinkun.auth.repository.AuthRepository;

public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthRepository authRepository; 
	
	@Override
	public boolean isAuthorized(String apikey) {
		return authRepository.exists(apikey);
	}

}
