package cloud.javacoder.rawhibernate.dao;

import cloud.javacoder.rawhibernate.entity.Course;
import org.hibernate.SessionFactory;

public class CourseDao extends AbstractCrudDAO<Course> {
    public CourseDao(SessionFactory sessionFactory) {
        super(sessionFactory, Course.class, "Course");
    }
}
