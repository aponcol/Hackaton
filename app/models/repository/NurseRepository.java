package models.repository;

import models.nurse.Nurse;
import models.WorkShift;
import models.WorkUnit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sylvain on 22/02/14.
 */
public class NurseRepository {

    Connection mConnection;

    public NurseRepository(Connection connection)
    {
        mConnection = connection;
    }

    public List<Nurse> getNurses() {

        List<Nurse> nurses = new ArrayList<Nurse>();
        try
        {
            Nurse nurse;

            PreparedStatement statement = mConnection.prepareStatement("SELECT * FROM nurse");
            ResultSet set = statement.executeQuery();
            while( set.next() )
            {
                long r = set.getLong("nurse_id");
                String name = set.getString("name");
                long workShift = set.getLong("workshift_id");
                long workUnit = set.getLong("workunit_id");

                nurses.add( new Nurse(r, name, WorkUnit.NEO_NATALOGY, WorkShift.DAY));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

         return nurses;
    }
}
