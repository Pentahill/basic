package jpa.metamodel;

import jpa.entity.Cluster;
import jpa.entity.Region;
import jpa.entity.Region_;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;

public class Main1 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.jpa");
        EntityManager manager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteria = manager.getCriteriaBuilder();

        CriteriaQuery<Tuple> query = criteria.createTupleQuery();

        Root<Region> region = query.from(Region.class);
        MapJoin<Region, String, Cluster> cluster = region.join(Region_.clusterMap);
        query.multiselect(region.get(Region_.name), cluster)
            .where(criteria.like(cluster.key(), "cluster"));

    }
}
