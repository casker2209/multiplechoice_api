package vn.usth.internship.api.security;

import org.springframework.data.mongodb.repository.MongoRepository;
import vn.usth.internship.api.object.ExamHistory;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);


    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
