package jpa.metamodel;

import jpa.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

public class Main5 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.jpa");
        EntityManager manager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = manager.getCriteriaBuilder();

        CriteriaQuery<Customer> q = cb.createQuery(Customer.class);
        Root<Customer> customer = q.from(Customer.class);
        ParameterExpression<Integer> param = cb.parameter(Integer.class, "stat");
        q.select(customer).where(cb.equal(customer.get(Customer_.status), param));
    }
}
