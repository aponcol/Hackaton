package controllers;

import models.WorkShift;
import models.WorkUnit;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class UiController extends Controller {

    public static Result getWorkUnits() {
        return ok(Json.toJson(WorkUnit.values()));
    }

    public static Result getWorkShifts() {
        return ok(Json.toJson(WorkShift.values()));
    }
}
