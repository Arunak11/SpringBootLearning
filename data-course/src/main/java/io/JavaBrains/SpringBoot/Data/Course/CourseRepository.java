package io.JavaBrains.SpringBoot.Data.Course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
    public List<Course> findByTopic(String topicId);
}
