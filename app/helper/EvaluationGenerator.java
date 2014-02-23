package helper;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import models.WorkUnit;
import models.evaluation.EvaluatedElement;
import models.evaluation.Evaluation;
import models.evaluation.Step;
import models.nurse.Nurse;
import models.nurse.NurseStore;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Random;

public class EvaluationGenerator {
    public static final int NB_EVALUDATED_ELEMENTS = 8;
    private static Random r = new Random();

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        long nextEvaluationId = 1;
        Map<Long, Evaluation> evaluations = Maps.newHashMap();

        PrintWriter pwEval = new PrintWriter("evaluation.txt");
//        nextEvaluationId = generateEvaluationsForYear(NurseStore.NB_NURSE, nextEvaluationId, evaluations, pwEval, 2013);
        nextEvaluationId = generateEvaluationsForYear(NurseStore.NB_NURSE, nextEvaluationId, evaluations, pwEval, 2014);
        pwEval.close();

        PrintWriter pw = new PrintWriter("evaluated_elements.txt");
        int nbEvaluatedElements = 8;
        for (long evaluationId = 1; evaluationId <= (nextEvaluationId - 1); evaluationId++) {
            for (long j = 1; j <= nbEvaluatedElements; j++) {
                System.out.println(evaluationId + ":" + j);
                pw.println(evaluationId + ";" + j + ";" + getStepFor(NurseStore.MAP.get(evaluations.get(evaluationId).getNurseId())));
            }
        }
        pw.close();
    }

    private static long generateEvaluationsForYear(int nbNurse, long evalId, Map<Long, Evaluation> evaluations, PrintWriter pwEval, int year) {
        for (long nurseId = 1; nurseId <= nbNurse; nurseId++) {
            pwEval.println(evalId + ";" + nurseId + ";" + year);
            evaluations.put(evalId, new Evaluation(evalId, nurseId, year, Lists.<EvaluatedElement>newArrayList()));
            evalId++;
        }
        return evalId;
    }

    private static Step getStepFor(Nurse nurse) {
        if(nurse.getWorkUnit().equals(WorkUnit.HEMATO_ONCO)) {
            return getRandomStep(35, 35, 20, 10);
        } else {
            return getRandomStep(30, 30, 30, 10);
        }
    }

    private static Step getRandomStep(int weightD, int weightA, int weightRC, int weightE) {
        int random = r.nextInt(weightD + weightA + weightRC + weightE);
        if (random <= weightD) {
            return Step.D;
        } else if (random <= weightD + weightA) {
            return Step.A;
        } else if (random <= weightD + weightA + weightRC) {
            return Step.RC;
        } else {
            return Step.E;
        }
    }
}
