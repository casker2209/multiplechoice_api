package vn.usth.internship.api.object;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExamContentRepository extends MongoRepository<ExamContent,String> {
}
