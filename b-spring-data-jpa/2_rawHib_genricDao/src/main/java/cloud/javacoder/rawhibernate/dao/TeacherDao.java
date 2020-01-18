package cloud.javacoder.rawhibernate.dao;

import cloud.javacoder.rawhibernate.entity.Teacher;
import org.hibernate.SessionFactory;

public class TeacherDao extends AbstractCrudDAO<Teacher> {
    public TeacherDao(SessionFactory sessionFactory) {
        super(sessionFactory, Teacher.class, "Teacher");
    }
}
