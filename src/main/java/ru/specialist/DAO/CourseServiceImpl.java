package ru.specialist.DAO;

import com.google.common.collect.Lists;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("courseService")
@Transactional(isolation = Isolation.READ_COMMITTED)
@Repository
public class CourseServiceImpl implements CourseService {

    private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

    private CourseRepository courseRepository;
    @Autowired
    public void setCourseRepository(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return courseRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return Lists.newArrayList(courseRepository.findAll());
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void delete(int id) {
    courseRepository.delete(id);
    }
}
