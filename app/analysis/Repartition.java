package analysis;

import models.evaluation.Evaluation;
import models.evaluation.Step;
import models.nurse.Nurse;
import models.nurse.NurseStore;

public class Repartition {
    private StepRepartitionResult D;
    private StepRepartitionResult A;
    private StepRepartitionResult RC;
    private StepRepartitionResult E;

    public Repartition() {
        this(new StepRepartitionResult(), new StepRepartitionResult(), new StepRepartitionResult(), new StepRepartitionResult());
    }

    public Repartition(StepRepartitionResult D,
                       StepRepartitionResult A,
                       StepRepartitionResult RC,
                       StepRepartitionResult E) {
        this.D = D;
        this.A = A;
        this.RC = RC;
        this.E = E;
    }

    public StepRepartitionResult getD() {
        return D;
    }

    public void setD(StepRepartitionResult d) {
        D = d;
    }

    public StepRepartitionResult getA() {
        return A;
    }

    public void setA(StepRepartitionResult a) {
        A = a;
    }

    public StepRepartitionResult getRC() {
        return RC;
    }

    public void setRC(StepRepartitionResult RC) {
        this.RC = RC;
    }

    public StepRepartitionResult getE() {
        return E;
    }

    public void setE(StepRepartitionResult e) {
        E = e;
    }

    public void addStepToRepartition(Step step,
                                     Nurse nurse) {

        switch (step) {
            case D:
                this.D.addNurse(nurse);
                break;
            case A:
                A.addNurse(nurse);
                break;
            case RC:
                RC.addNurse(nurse);
                break;
            case E:
                E.addNurse(nurse);
                break;
            default:
                throw new IllegalArgumentException("Invalid step:" + step);

        }
    }
}
