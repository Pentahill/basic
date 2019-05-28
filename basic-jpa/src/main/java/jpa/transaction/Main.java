package jpa.transaction;

import jpa.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.jpa");
        EntityManager manager = entityManagerFactory.createEntityManager();

        EntityTransaction ts = manager.getTransaction();

        ts.begin();
        List<User> users = manager.createQuery("select u from User u").getResultList();
        manager.createQuery("update User u set u.name='liu' where u.id=1").executeUpdate();
//        if(true) throw new BusinessException();
//        ts.commit();
        ts.rollback();

        manager.close();
        entityManagerFactory.close();
    }

    public static class BusinessException extends RuntimeException{

    }
}
