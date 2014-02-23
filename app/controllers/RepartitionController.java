package controllers;

import analysis.Repartition;
import analysis.RepartitionAnalyser;
import models.WorkShift;
import models.WorkUnit;
import models.evaluation.Evaluation;
import models.evaluation.EvaluationStore;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class RepartitionController extends Controller {

    public static Result get(String workUnit, String workShift) {
        List<Evaluation> filtered = appliesNurseFilters(workUnit, workShift, EvaluationStore.VALUES);
        return ok(Json.toJson(RepartitionAnalyser.repartition(filtered)));
    }

    public static Result getByElementId( Long elementId, String workUnit, String workShift) {
        List<Evaluation> filtered = appliesNurseFilters(workUnit, workShift, EvaluationStore.VALUES);
        return ok(Json.toJson(RepartitionAnalyser.repartitionByElementId(filtered, elementId)));
    }

    public static Result getByCompetencyId(Long competencyId, String workUnit, String workShift) {
        List<Evaluation> filtered = appliesNurseFilters(workUnit, workShift, EvaluationStore.VALUES);
        return ok(Json.toJson(RepartitionAnalyser.repartitionByCompetenceId(filtered, competencyId)));
    }

    private static List<Evaluation> appliesNurseFilters(String workUnit, String workShift, List<Evaluation> evaluations) {
        if (workUnit != null) {
            evaluations = RepartitionAnalyser.filterByUnit(evaluations, WorkUnit.valueOf(workUnit.toUpperCase()));
        }
        if (workShift != null) {
            evaluations = RepartitionAnalyser.filterByShift(evaluations, WorkShift.valueOf(workShift.toUpperCase()));
        }
        return evaluations;
    }

}
