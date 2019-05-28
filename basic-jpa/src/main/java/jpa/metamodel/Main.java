package jpa.metamodel;

import jpa.entity.*;
import jpa.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.jpa");
        EntityManager manager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteria = manager.getCriteriaBuilder();

        CriteriaQuery<String> query = criteria.createQuery(String.class);

        Root<Customer> customer = query.from(Customer.class);
        Join<Customer, Order> orders = customer.join(Customer_.ORDERS);
        Join<Order, LineItem> items = orders.join(Order_.LINE_ITEMS);

        Predicate predicate = criteria.equal(items.get(LineItem_.product).get(Product_.productType), "printer");

        query.select(customer.get(Customer_.name))
                .where(predicate);
    }
}
