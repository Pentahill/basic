package jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityDao<T> {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.jpa");
    EntityManager manager = entityManagerFactory.createEntityManager();

    public void close() {
        entityManagerFactory.close();
        manager.close();
    }

    public void save(T entity) {
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
    }

    public T find(Class<T> clazz, Integer primaryKey) {
        return manager.find(clazz, primaryKey);
    }

    public void remove(T entity) {
        manager.getTransaction().begin();
        manager.remove(entity);
        manager.getTransaction().commit();
    }

    public void refresh(T entity) {
        manager.refresh(entity);
    }

}
