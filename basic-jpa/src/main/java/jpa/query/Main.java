package jpa.query;

import jpa.entity.User;

import javax.persistence.*;

public class Main {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.jpa");
    EntityManager manager = entityManagerFactory.createEntityManager();

    {
        manager.createQuery("SELECT u FROM User u WHERE u.name LIKE :custName").setParameter("custName", "liu").setMaxResults(10).getResultList();

        manager.createNamedQuery("findAllUsersWithName").setParameter("custName", "smith").getResultList();

        manager.createNativeQuery("SELECT u.id, u.name FROM User u WHERE u.id = 1", User.class);

        manager.createNativeQuery("SELECT u.id, u.name FROM User u WHERE u.id = 1", "UserResults");

        manager.createNativeQuery("SELECT u.id, u.name, a.id, FROM User u, Age a WHERE u.id = 1", "UserAgeResults");

        String a = "select distinct o from Order as o Join o.lineItem as l where l.shipped = false";

        String b = "select distinct o from Order o Join o.lineItem l JOIN l.product p where p.productType = 'office_supplies'";

        String c = "select distinct o1 from Order o1, Order o2 where o1.quantity > o2.quantity and o2.customer.lastname = 'smith' and o2.customer.firstname = 'John'";

        String d = "select distinct emp from Employee emp where exists(select spouseEmp from Employee spouseEmp where spouseEmp = emp.spouse)";

        String e = "select emp from Employee emp where emp.salary > all(select m.salary from Manager m where m.department = emp.department)";

        String f = "select e.name, case type(e) when Exempt then 'Exempt' when Contractor then 'Contractor' else 'NonExempt' end from Employee e where e.dept.name = 'Engineering'";

        String g = "select c.status avg(c.filledOrderCount) from Customer c group by c.status having c.status in (1, 2)";
    }

    public static void main(String[] args) {

    }

}
