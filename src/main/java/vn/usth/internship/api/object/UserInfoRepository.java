package vn.usth.internship.api.object;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInfoRepository extends MongoRepository<UserInfo,String> {
}
