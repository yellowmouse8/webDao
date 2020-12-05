package ru.specialist.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CourseRepository extends CrudRepository<Course, Integer> {
}
