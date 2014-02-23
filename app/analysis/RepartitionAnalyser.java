package analysis;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import models.WorkShift;
import models.WorkUnit;
import models.competency.CompetencyStore;
import models.evaluation.EvaluatedElement;
import models.evaluation.Evaluation;
import models.evaluation.Step;
import models.nurse.NurseStore;

import java.util.List;
import java.util.Set;

// TODO clean up to use interface!!!
public class RepartitionAnalyser {

    public static List<Evaluation> filterByUnit(List<Evaluation> evaluations, WorkUnit workUnit) {
        List<Evaluation> filtered = Lists.newArrayList();
        for (Evaluation e : evaluations) {
            if (NurseStore.MAP.get(e.getNurseId()).getWorkUnit().equals(workUnit)) {
                filtered.add(e);
            }
        }
        return filtered;
    }

    public static List<Evaluation> filterByShift(List<Evaluation> evaluations, WorkShift workShift) {
        List<Evaluation> filtered = Lists.newArrayList();
        for (Evaluation e : evaluations) {
            if (NurseStore.MAP.get(e.getNurseId()).getWorkShift().equals(workShift)) {
                filtered.add(e);
            }
        }
        return filtered;
    }

    public static Repartition repartition(List<Evaluation> evaluations) {
        Repartition repartition = new Repartition();
        for (Evaluation e : evaluations) {
            repartition.increment(computeEvaluationOverallStep(e.getEvaluatedElements()));
        }
        return repartition;
    }

    public static Repartition repartitionByElementId(List<Evaluation> evaluations, Long elementId) {
        Repartition repartition = new Repartition();
        for (Evaluation e : evaluations) {
            repartition.increment(computeEvaluationOverallStep(
                    filterEvaluatedElementsByElementId(e.getEvaluatedElements(),
                            Sets.newHashSet(elementId))));
        }
        return repartition;
    }

    public static Repartition repartitionByCompetenceId(List<Evaluation> evaluations, Long competenceId) {
        Repartition repartition = new Repartition();
        Set<Long> filter = CompetencyStore.COMPETENCE_ID_TO_ELEMENT_ID_MAP.get(competenceId);
        for (Evaluation e : evaluations) {
            repartition.increment(computeEvaluationOverallStep(filterEvaluatedElementsByElementId(e.getEvaluatedElements(), filter)));
        }
        return repartition;
    }

    public static List<EvaluatedElement> filterEvaluatedElementsByElementId(List<EvaluatedElement> evaluatedElements,
                                                                            Set<Long> elementIds) {
        List<EvaluatedElement> filtered = Lists.newArrayList();
        for (EvaluatedElement e : evaluatedElements) {
            if (elementIds.contains(e.getElementId())) {
                filtered.add(e);
            }
        }
        return filtered;
    }

    public static Step computeEvaluationOverallStep(List<EvaluatedElement> evaluatedElements) {
        int sum = 0;
        for (EvaluatedElement ee : evaluatedElements) {
            sum += ee.getEvaluation().getValue();
        }
        float avg = (float) sum / (float) evaluatedElements.size();
        return Step.fromValue(Math.round(avg));
    }

}
