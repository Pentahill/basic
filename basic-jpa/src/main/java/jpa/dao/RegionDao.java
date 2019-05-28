package jpa.dao;

import jpa.domain.NameBean;
import jpa.entity.Region;

import javax.persistence.Tuple;
import java.util.List;

public class RegionDao extends EntityDao<Region>{

    public void findRegion() {
        List<Tuple> regions = manager.createQuery("SELECT r, VALUE(c) FROM Region r JOIN r.clusterMap c WHERE r.name = 'shanghai' AND KEY(c) like '%cluster%'").getResultList();
    }

    public List<Region> findAll() {
        return manager.createQuery("SELECT DISTINCT r FROM Region r, Cluster").getResultList();
    }

    public List<Region> findAllInnerJoin() {
        return manager.createQuery("SELECT DISTINCT r FROM Region r join Cluster c ON 1 = 1").getResultList();
    }

    public List getNameBean(Integer primaryKey) {
//        return (NameBean)manager.createQuery("SELECT NEW jpa.domain.NameBean(KEY(r.clusterMap)) FROM Region r LEFT JOIN r.clusterMap WHERE KEY(r.clusterMap) = 'cluster1' AND r.id =  :id")
//                .setParameter("id", primaryKey)
//                .getSingleResult();

        return manager.createQuery("SELECT r, VALUE(cm)  FROM Region r LEFT JOIN r.clusterMap cm WHERE KEY(cm) = 'cluster1' AND r.id =  1" ).getResultList();
    }

}
