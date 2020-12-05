package ru.specialist.DAO;

import java.util.List;

public interface CourseService  {
    Course findById(int id);
    List<Course> findAll();
    Course save(Course course);
    void delete(int id);
}
