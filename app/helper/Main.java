import models.Nurse;
import models.repository.Database;
import models.repository.NurseRepository;

import java.io.Console;
import java.sql.Connection;
import java.util.List;


/**
 * Created by Sylvain on 22/02/14.
 */
public class Main {

    public static void main(String[] args)
    {
        List<Nurse> nurses;
        try
        {
            Database.initialize();

            Connection conn = Database.getConnection("jdbc:sqlite:darce.db");
            NurseRepository nurseRepository = new NurseRepository(conn);

            nurses = nurseRepository.getNurses();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }




}
