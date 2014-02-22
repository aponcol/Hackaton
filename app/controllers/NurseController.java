package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Nurse;
import models.WorkShift;
import models.WorkUnit;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;

public class NurseController extends Controller {

    public static Result get() {
        return ok(Json.toJson(new Nurse(7, "Josée Boudreaul", WorkUnit.PEDIATRIC, WorkShift.DAY)));
    }
}
