package helper;

import models.evaluation.Step;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * Created by felix on 22/02/14.
 */
public class EvaluationGenerator {
    private static Random r = new Random();
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        int nbNurse = 20;
        int year = 2014;

        int evalId = 1;

        PrintWriter pwEval = new PrintWriter("evaluation.txt");
        for (int nurseId = 1; nurseId <= nbNurse; nurseId++) {
            pwEval.println(evalId + ";" + nurseId + ";" + year);
            evalId++;
        }
        pwEval.close();

        PrintWriter pw = new PrintWriter("evaluated_elements.txt");
        int nbElements = 6;
        for (int i = 1; i <= evalId; i++) {
            for (int j = 1; j <= nbElements; j++) {
                pw.println(i + ";" + j + ";" + getRandomStep());
            }
        }
        pw.close();
    }

    private static Step getRandomStep() {
        int rInt = r.nextInt(4);
        switch (rInt) {
            case 0: return Step.D;
            case 1: return Step.A;
            case 2: return Step.RC;
            case 3: return Step.E;
            default: throw new RuntimeException("Can't happen!");
        }

    }
}
