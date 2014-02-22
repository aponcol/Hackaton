package models.evaluation;

import java.util.List;

public class Evaluation {
    private long id;
    private long nurseId;
    private int evaluationYear;
    private List<EvaluatedElement> evaluatedElements;

    public Evaluation(long id, long nurseId, int evaluationYear, List<EvaluatedElement> evaluatedElements) {
        this.id = id;
        this.nurseId = nurseId;
        this.evaluationYear = evaluationYear;
        this.evaluatedElements = evaluatedElements;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNurseId() {
        return nurseId;
    }

    public void setNurseId(long nurseId) {
        this.nurseId = nurseId;
    }

    public int getEvaluationYear() {
        return evaluationYear;
    }

    public void setEvaluationYear(int evaluationYear) {
        this.evaluationYear = evaluationYear;
    }

    public List<EvaluatedElement> getEvaluatedElements() {
        return evaluatedElements;
    }

    public void setEvaluatedElements(List<EvaluatedElement> evaluatedElements) {
        this.evaluatedElements = evaluatedElements;
    }
}
