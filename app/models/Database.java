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
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/darce");
        PreparedStatement st = conn.prepareStatement("CREATE TABLE test (id int);");
        st.execute();
        conn.commit();
        conn.close();

    }

    public static void setV(int i) throws Exception {
        System.out.println("set");

        Class.forName("SQLite.JDBCDriver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/darce");
        PreparedStatement st = conn.prepareStatement("INSERT INTO test (id) VALUES(3);");
        st.executeUpdate();
        conn.commit();
        conn.close();

    }

    public static int get() throws Exception {
        System.out.println("get");

        Class.forName("SQLite.JDBCDriver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/darce");
        PreparedStatement st = conn.prepareStatement("SELECT id FROM test;");
        ResultSet set = st.executeQuery();
        set.next();
        int r = set.getInt(1);
        conn.commit();
        conn.close();
        return r;

    }
}
