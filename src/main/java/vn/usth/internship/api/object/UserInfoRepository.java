package vn.usth.internship.api.object;

import org.springframework.data.mongodb.repository.MongoRepository;
import vn.usth.internship.api.security.User;
import vn.usth.internship.api.security.UserDetailsImpl;

import java.util.Optional;

public interface UserInfoRepository extends MongoRepository<UserInfo,String> {
    @Override
    Optional<UserInfo> findById(String s);
    Optional<UserInfo> findByUser(User user);
    Optional<UserInfo> findByUserId(String id);
}
