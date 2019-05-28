package jpa.metamodel;

import jpa.entity.Customer;
import jpa.entity.Customer_;
import jpa.entity.VideoStore;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

public class Main7 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.jpa");
        EntityManager manager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = manager.getCriteriaBuilder();

        CriteriaQuery<Customer> q = cb.createQuery(Customer.class);
        Root<Customer> customer = q.from(Customer.class);

        Subquery<Double> sq = q.subquery(Double.class);
        Root<Customer> subCustomer = sq.from(Customer.class);

        q.where(cb.lt(
                customer.get(Customer_.balanceOwed),
                sq.select(cb.avg(subCustomer.get(Customer_.balanceOwed)))
        ));
        q.select(customer);

        TypedQuery<Customer> tp = manager.createQuery(q);
        System.out.println(tp.getSingleResult().getName());
    }
}
