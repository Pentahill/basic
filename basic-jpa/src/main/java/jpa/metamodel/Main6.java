package jpa.metamodel;

import jpa.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;

public class Main6 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.jpa");
        EntityManager manager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = manager.getCriteriaBuilder();

        CriteriaQuery<Tuple> q = cb.createTupleQuery();
        Root<VideoStore> v = q.from(VideoStore.class);
//        MapJoin<VideoStore, Movie, Integer> inv =
//                v.join(VideoStore_.videoInventory);
//        q.multiselect(v.get(VideoStore_.location).get(Address_.street),
//                inv.key().get(Movie_.title),
//                inv);
//        q.where(cb.equal(v.get(VideoStore_.location).get(Address_.zipcode),
//                "94301"),
//                cb.gt(inv, 0));
    }
}
