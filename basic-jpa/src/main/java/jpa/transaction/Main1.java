package jpa.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {
    public static void main(String[] args) throws ClassNotFoundException {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/school?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowMultiQueries=true&serverTimezone=UTC";
        String user = "root";
        String password = "root";

        Class.forName(driverName);
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);
            try {
                Statement statement = conn.createStatement();
                statement.executeUpdate("insert into user(id, name) values(113, 'aa')");
//                statement.executeUpdate("insert into user(id, name) values(112, 'aa')");

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
