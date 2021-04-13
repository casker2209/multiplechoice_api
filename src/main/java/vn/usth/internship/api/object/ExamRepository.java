package vn.usth.internship.api.object;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ExamRepository extends MongoRepository<Exam, String> {

    Optional<Exam> findByName(String name);

    List<Exam> findByNameContaining(String name);

}
