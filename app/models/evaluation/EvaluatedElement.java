package models.evaluation;

public class EvaluatedElement {
    private long evaluationId;
    private long elementId;
    private Step evaluation;

    public EvaluatedElement(long evaluationId, long elementId, Step evaluation) {
        this.evaluationId = evaluationId;
        this.elementId = elementId;
        this.evaluation = evaluation;
    }

    public long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(long evaluationId) {
        this.evaluationId = evaluationId;
    }

    public long getElementId() {
        return elementId;
    }

    public void setElementId(long elementId) {
        this.elementId = elementId;
    }

    public Step getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Step evaluation) {
        this.evaluation = evaluation;
    }
}
