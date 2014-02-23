package analysis;

import models.evaluation.Step;

public class Repartition<T> {
    private StepRepartitionResult<T> D;
    private StepRepartitionResult<T> A;
    private StepRepartitionResult<T> RC;
    private StepRepartitionResult<T> E;

    public Repartition() {
        this(new StepRepartitionResult<T>(), new StepRepartitionResult<T>(), new StepRepartitionResult<T>(), new StepRepartitionResult<T>());
    }

    public Repartition(StepRepartitionResult<T> D,
                       StepRepartitionResult<T> A,
                       StepRepartitionResult<T> RC,
                       StepRepartitionResult<T> E) {
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

    public void addElementToRepartition(Step step,
                                        T element) {

        switch (step) {
            case D:
                this.D.addElement(element);
                break;
            case A:
                A.addElement(element);
                break;
            case RC:
                RC.addElement(element);
                break;
            case E:
                E.addElement(element);
                break;
            default:
                throw new IllegalArgumentException("Invalid step:" + step);

        }
    }
}
