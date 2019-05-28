package jpa.query;

import jpa.dao.RegionDao;
import jpa.domain.NameBean;
import jpa.entity.Region;

import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        RegionDao dao = new RegionDao();
       dao.getNameBean(1);
    }
}
