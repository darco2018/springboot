package cloud.javacoder.rawhibernate;

import cloud.javacoder.rawhibernate.dao.CourseDao;
import cloud.javacoder.rawhibernate.dao.TeacherDao;
import cloud.javacoder.rawhibernate.entity.Course;

import cloud.javacoder.rawhibernate.entity.Teacher;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// if you remove @SpringBootApplication & SpringApplication.run(SpringdatajpaApplication.class, args),
// the app will run ok but terminate & you won't be able to view H2 console. What really keeps it up is springboot-web dep (with server)
@SpringBootApplication
public class RawHibernate{

	/* this program shows an abstract dao class with concrete methods, which are shared
	by both subclasses (TeacherDao & Course Dao*/

	// it as a RAW hibernate example. Note the use od hibernate.cfg.xml
	/* Hibernate:
	* - takes care of connection to db
	* - takes care of mapping
	* */

	public static void main(String[] args){

		SpringApplication.run(RawHibernate.class, args);
		// create ServiceRegistry
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		// create SessionFactory
		// try with resources will close SessionFactory & Sessions when not needed
		try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
			// create DAOs
			CourseDao courseDAO = new CourseDao(sessionFactory);
			TeacherDao teacherDAO = new TeacherDao(sessionFactory);

			// create Session. Using getCurrentSession() we will use the same session throughout the program
			try (Session session = sessionFactory.getCurrentSession()) {
				// start transaction
				Transaction tx = session.beginTransaction();
				// create teachers & persist them using Hibernate;s save()
				Teacher teacher1 = teacherDAO.save(new Teacher("Profesor Jirafales","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/245px-Ruben2017.jpg","jirafales@example.com"));
				Teacher teacher2 = teacherDAO.save(new Teacher("Professor X","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-nQ2uJOph4_t96KRvLSMjczAKnHLJYi1nqWXagvqWc4","director@xproject_.com"));
				// create courses & save them using Hibernate's save()
				courseDAO.save(new Course("Mathematics", 20, 10, teacher1));
				courseDAO.save(new Course("Spanish", 20, 10, teacher1));
				courseDAO.save(new Course("Dealing with unknown", 10, 100, teacher2));
				courseDAO.save(new Course("Handling your mental power", 50, 100, teacher2));
				courseDAO.save(new Course("Introduction to psychology", 90, 100, teacher2));
				tx.commit();
				// commit transaction
			}

			// again try with resources just to close Closable
			try (Session session = sessionFactory.getCurrentSession()) {
				// new transaction to retrieve the saved teachers & courses
				session.beginTransaction();

				System.out.println("Courses");
				courseDAO.list().forEach(course -> System.out.println(course.getName()));
				System.out.println("Teachers");
				teacherDAO.list().forEach(teacher -> System.out.println(teacher.getName()));
				// no need to commit transaction when find()
			}
		}
	}
	// ACID: Atomic Consisten Isolated Durable
	// atomic - not influenced by other operations
}
