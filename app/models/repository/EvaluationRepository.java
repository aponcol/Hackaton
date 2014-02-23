package models.repository;

import models.evaluation.Evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Sylvain on 22/02/14.
 */
public class EvaluationRepository {

    private Connection mConnection;
    public EvaluationRepository( Connection connection)
    {
        mConnection = connection;
    }

    public void add(Evaluation evaluation, EvaluatedElementRepository evaluatedElementRepository)
    {
        String cmd = String.format
                ("INSERT INTO evaluation (nurse_id, year) VALUES(%d,'%s')",
                        evaluation.getNurseId(),
                        evaluation.getEvaluationYear());
        try
        {
            PreparedStatement statement = mConnection.prepareStatement(cmd);
            int i = statement.executeUpdate();

            evaluatedElementRepository.add(evaluation.getEvaluatedElements());

        }
        catch ( Exception e) { e.printStackTrace();}
    }
}
