package ebj.yujinkun.quote.auth.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import models.Authorization;
import utils.TextUtils;

@Repository
public class AuthRepositoryImpl implements AuthRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public boolean exists(String apiKey) {
		Query query = new Query(Criteria.where("key").is(apiKey));
		Authorization auth = mongoTemplate.findOne(query, Authorization.class);
		return auth != null && !TextUtils.isEmpty(auth.getKey());
	}

}
