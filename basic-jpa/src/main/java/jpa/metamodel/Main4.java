package jpa.metamodel;

import jpa.entity.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.jpa");
        EntityManager manager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = manager.getCriteriaBuilder();

        CriteriaQuery<String> q = cb.createQuery(String.class);
        Root<Employee> emp = q.from(Employee.class);
        Join<Employee, FrequentFlierPlan> fp =
                emp.join(Employee_.frequentFlierPlans);
        q.select(cb.<String>selectCase()
                .when(cb.gt(fp.get(FrequentFlierPlan_.annualMiles),
                        50000),
                        cb.literal("Platinum"))
                .when(cb.gt(fp.get(FrequentFlierPlan_.annualMiles),
                        25000),
                        cb.literal("Silver"))
                .otherwise(cb.nullLiteral(String.class)));
    }
}
