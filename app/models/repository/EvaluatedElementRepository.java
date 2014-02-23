package models.repository;

import models.evaluation.EvaluatedElement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by Sylvain on 22/02/14.
 */
public class EvaluatedElementRepository {

    private Connection mConnection;
    public EvaluatedElementRepository(Connection connection)
    {
        mConnection = connection;
    }

    public void add(List<EvaluatedElement> evaluatedElement) {
        try
        {

        for ( EvaluatedElement elem : evaluatedElement) {
            String cmd = String.format
                    ("INSERT INTO evaluated_element (evaluation_id, element_id, evaluation ) VALUES(%d, %d, '%s')",
                            elem.getEvaluationId(),
                            elem.getElementId(),
                            elem.getEvaluation().name());
                PreparedStatement statement = mConnection.prepareStatement(cmd);
                int i = statement.executeUpdate();

            }
        }
        catch ( Exception e) { e.printStackTrace();}

    }
}
