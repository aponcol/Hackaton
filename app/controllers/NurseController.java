package controllers;

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
}
