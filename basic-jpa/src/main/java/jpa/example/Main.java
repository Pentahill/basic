package jpa.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.jpa");
        EntityManager manager = entityManagerFactory.createEntityManager();

        manager.getTransaction().begin();
        Customer customer = new Customer();
        manager.persist(customer);
        manager.getTransaction().commit();

        manager.close();
        entityManagerFactory.close();
    }
}
