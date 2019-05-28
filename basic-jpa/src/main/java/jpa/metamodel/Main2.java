package jpa.metamodel;

import jpa.entity.*;
import jpa.entity.Order;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.math.BigDecimal;

public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.jpa");
        EntityManager manager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteria = manager.getCriteriaBuilder();

        CriteriaQuery<BigDecimal> query = criteria.createQuery(BigDecimal.class);

//        Root<Order> order = query.from(Order.class);
//        Join<Order, LineItem> item = order.join(Order_.lineItems);
//        Join<Order, Customer> cust = order.join(Order_.customer);
//        query.where(criteria.equal(cust.get(Customer_.lastName), "Smith"),
//                    criteria.equal(cust.get(Customer_.firstName), "John"));
//        query.select(criteria.sum(item.get(LineItem_.price)));
//
//        query.getSelection();

        Root<Order> order = query.from(Order.class);
        Join<Order, Customer> customer = order.join(Order_.customer);
        Join<Order, LineItem> item = order.join(Order_.lineItems);

        query.where(criteria.equal(customer.get(Customer_.firstName), "John"),
                    criteria.equal(customer.get(Customer_.lastName), "Smith"));
        query.select(criteria.sum(item.get(LineItem_.price)));

        TypedQuery<BigDecimal> tq = manager.createQuery(query);
        System.out.println(tq.getSingleResult());
    }
}
