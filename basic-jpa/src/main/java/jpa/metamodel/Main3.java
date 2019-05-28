package jpa.metamodel;

import jpa.entity.Department_;
import jpa.entity.Employee;
import jpa.entity.Employee_;
import org.hibernate.query.QueryProducer;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Queue;

public class Main3 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.jpa");
        EntityManager manager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteria = manager.getCriteriaBuilder();

        CriteriaQuery<Tuple> query = criteria.createTupleQuery();

        Root<Employee> employee = query.from(Employee.class);
        query.where(criteria.equal(employee.get(Employee_.department).get(Department_.name), "dp"));
        query.multiselect(employee.get(Employee_.name), criteria.selectCase()
                            .when(criteria.equal(employee.get(Employee_.rating), 1), criteria.prod(employee.get(Employee_.salary), 1.0))
                            .otherwise(criteria.prod(employee.get(Employee_.salary), 1.0)));

        Query q = manager.createQuery(query);
        List<Tuple> tuples = q.getResultList();
        for(Tuple t : tuples) {
            t.getElements().stream().forEach(e -> {
                e.getJavaType();
            });
        }
    }
}
