package controllers;

import com.google.common.collect.Lists;
import models.competency.Competency;
import models.competency.Element;
import models.competency.Indication;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class CompetencyController extends Controller {

    public static Result index() {
        return ok(Json.toJson(Lists.newArrayList(
                new Competency(1, "competency 1",
                        Lists.newArrayList(new Element(2, "element", Lists.<Indication>newArrayList()))),
                new Competency(1, "competency", Lists.<Element>newArrayList()))));
    }
}
