import models.evaluation.Evaluation;
import models.evaluation.EvaluationStore;
import models.nurse.Nurse;
import models.nurse.NurseStore;
import models.repository.Database;
import models.repository.EvaluatedElementRepository;
import models.repository.EvaluationRepository;
import models.repository.NurseRepository;

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
            EvaluationRepository evaluationRepo = new EvaluationRepository(conn);
            EvaluatedElementRepository evaluatedElementRepo = new EvaluatedElementRepository(conn);

            //fillNurseTable(nurseRepository);
            //fillEvaluationTable(evaluationRepo, evaluatedElementRepo);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void fillNurseTable(NurseRepository repo)
    {
        for( Nurse nurse : NurseStore.MAP.values())
        {
            repo.add(nurse);
        }
    }

    public static void fillEvaluationTable(EvaluationRepository repo, EvaluatedElementRepository repoElements)
    {
        for ( Evaluation eval : EvaluationStore.VALUES)
        {
            repo.add(eval, repoElements);
        }
    }
}
