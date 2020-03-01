package ebj.yujinkun.auth.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import models.Authorization;
import utils.TextUtils;

public class AuthRepositoryImpl implements AuthRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public boolean exists(String apikey) {
		Query query = new Query(Criteria.where("key").is(apikey));
		Authorization auth = mongoTemplate.findOne(query, Authorization.class);
		return auth != null && !TextUtils.isEmpty(auth.getKey());
	}

}
