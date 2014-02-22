package controllers;

import models.evaluation.EvaluationStore;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by felix on 22/02/14.
 */
public class EvaluationController extends Controller {

    public static Result index() {
        return ok(Json.toJson(EvaluationStore.VALUES));
    }
}
