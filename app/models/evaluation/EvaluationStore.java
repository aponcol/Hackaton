package models.evaluation;

import com.google.common.collect.Maps;
import models.loader.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EvaluationStore {

    public static List<Evaluation> VALUES = null;
    public static Map<Long, Evaluation> NURSE_ID_TO_EVALUATION = Maps.newHashMap();

    static {
        try {
            VALUES = EvaluationLoader.loadEvaluations();
            List<EvaluatedElement> evaluatedElements = EvaluatedElementsLoader.loadEvaluatedElements();

            for (Evaluation e : VALUES) {
                for (EvaluatedElement ee : evaluatedElements) {
                    if (e.getId() == ee.getEvaluationId()) {
                        e.getEvaluatedElements().add(ee);
                    }
                }
                NURSE_ID_TO_EVALUATION.put(e.getNurseId(), e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
