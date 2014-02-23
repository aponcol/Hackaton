package controllers;

import models.evaluation.Evaluation;
import models.evaluation.EvaluationStore;
import models.nurse.Nurse;
import models.WorkShift;
import models.WorkUnit;
import models.nurse.NurseStore;
import play.mvc.Controller;
import play.mvc.Result;

import play.libs.Json;

public class NurseController extends Controller {

    public static Result index() {
        return ok(Json.toJson(NurseStore.MAP.values()));

    }

    public static Result get(long id) {
        return ok(Json.toJson(NurseStore.MAP.get(id)));
    }

    public static Result getEvaluation(long id) {
        return ok(Json.toJson(EvaluationStore.NURSE_ID_TO_EVALUATION.get(id)));
    }

    public static Result getEvaluationRepartition(long id, long eId) {
        Evaluation e = EvaluationStore.NURSE_ID_TO_EVALUATION.get(id);
        return ok(Json.toJson(e)); //todo
    }
}
