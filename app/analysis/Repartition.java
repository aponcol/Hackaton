package analysis;

import models.evaluation.Step;

public class Repartition {
    private int numD;
    private int numA;
    private int numRC;
    private int numE;

    public Repartition() {
    }

    public Repartition(int numD, int numA, int numRC, int numE) {
        this.numD = numD;
        this.numA = numA;
        this.numRC = numRC;
        this.numE = numE;
    }

    public int getNumD() {
        return numD;
    }

    public int getNumA() {
        return numA;
    }

    public int getNumRC() {
        return numRC;
    }

    public int getNumE() {
        return numE;
    }

    public void setNumD(int numD) {
        this.numD = numD;
    }

    public void setNumA(int numA) {
        this.numA = numA;
    }

    public void setNumRC(int numRC) {
        this.numRC = numRC;
    }

    public void setNumE(int numE) {
        this.numE = numE;
    }

    public void increment(Step step) {
        switch (step) {
            case D:
                numD += 1;
                break;
            case A:
                numA += 1;
                break;
            case RC:
                numRC += 1;
                break;
            case E:
                numE += 1;
                break;

        }
    }
}
