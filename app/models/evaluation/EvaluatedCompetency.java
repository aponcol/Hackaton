package models.evaluation;

import java.util.List;

public class EvaluatedCompetency {
    private long evaluationId;
    private long competencyId;
    private Step evaluation;
    private List<EvaluatedElement> evaluatedElements;

    public EvaluatedCompetency(long evaluationId, long competencyId, Step evaluation, List<EvaluatedElement> evaluatedElements) {
        this.evaluationId = evaluationId;
        this.competencyId = competencyId;
        this.evaluation = evaluation;
        this.evaluatedElements = evaluatedElements;
    }

    public long getEvaluationId() {
        return evaluationId;
    }

    public long getCompetencyId() {
        return competencyId;
    }

    public Step getEvaluation() {
        return evaluation;
    }

    public List<EvaluatedElement> getEvaluatedElements() {
        return evaluatedElements;
    }
}

