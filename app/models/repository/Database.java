package models.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

/**
 * Created by felix on 22/02/14.
 */
public class Database {

    public static void initialize() {
        try {
            Class.forName("org.sqlite.JDBC");
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(String connectionString) throws Exception
    {
        return DriverManager.getConnection(connectionString);
    }

    public static void setV(int i) throws Exception {
        System.out.println("set");

        Class.forName("org.sqlite.JDBC").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Sylvain\\Documents\\GitHub\\database_test\\darce.db");
        PreparedStatement st = conn.prepareStatement("INSERT INTO test (id) VALUES(3);");
        st.executeUpdate();
        conn.commit();
        conn.close();

    }

    public static long get() throws Exception {
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
