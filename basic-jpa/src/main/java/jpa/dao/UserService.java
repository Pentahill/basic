package jpa.dao;

import jpa.entity.User;

public class UserService {

    public static void main(String[] args) {
        EntityDao<User> dao = new EntityDao();

//        User user = dao.find(User.class, 1);
//        dao.refresh(user);
//        User user = new User(11, "liu");
//        dao.save(user);

        User user = dao.find(User.class, 11);

        EntityDao<User> dao1 = new EntityDao();
        User user1 = dao1.find(User.class, 11);

        System.out.println(user == user1);

        dao.close();

    }

}
