package cloud.javacoder.rawhibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

// abstract class which has common methods for Course and Teacher
public abstract class AbstractCrudDAO<T> {
    private final SessionFactory sessionFactory;
    private final Class<T> entityClass; // hibernate's find() will need it
    private final String entityName;

    protected AbstractCrudDAO(SessionFactory sessionFactory, Class<T> entityClass, String entityName) {
        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
        this.entityName = entityName;
    }

    public T save(T entity){
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    public void delete(T entity){
        sessionFactory.getCurrentSession().delete(entity);
    }

    public T find(long id){
        return sessionFactory.getCurrentSession().find(entityClass, id);
    }

    public List<T> list(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<T> query = session.getCriteriaBuilder().createQuery(entityClass);
        query.select(query.from(entityClass)); // HQL - we're quering objects,not tables. Hibernate's engine will convert it to SQL
        return session.createQuery(query).getResultList();
    }

}
