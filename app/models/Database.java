package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by felix on 22/02/14.
 */
public class Database {

    public static void test() throws Exception {

        Class.forName("SQLite.JDBCDriver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:data/darce.db");
        PreparedStatement st = conn.prepareStatement("CREATE TABLE test (id int);");
        st.execute();
        conn.commit();
        conn.close();

    }

    public static void setV(int i) throws Exception {
        System.out.println("set");

        Class.forName("SQLite.JDBCDriver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:data/darce.db");
        PreparedStatement st = conn.prepareStatement("INSERT INTO test (id) VALUES(3);");
        st.executeUpdate();
        conn.commit();
        conn.close();

    }

    public static long get() throws Exception {
        System.out.println("get");

        Class.forName("SQLite.JDBCDriver");
        Connection c = DriverManager.getConnection("jdbc:sqlite:data/darce.db");
        c.setAutoCommit(false);
        PreparedStatement st = c.prepareStatement("SELECT * FROM nurse;");
        ResultSet set = st.executeQuery();
        set.next();
        long r = set.getLong("id");
        c.commit();
        c.close();
        return r;

    }
}
