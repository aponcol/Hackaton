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

/**
 * Created by felix on 22/02/14.
 */
public class NurseApplication extends Controller {

    public static Result index() {
        Nurse n = new Nurse(7, "jane", WorkUnit.PEDIATRIC, WorkShift.DAY);

        return ok(n.toJson());
    }
}
