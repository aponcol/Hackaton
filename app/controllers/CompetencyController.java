package controllers;

import com.google.common.collect.Lists;
import models.competency.Competency;
import models.competency.CompetencyStore;
import models.competency.Element;
import models.competency.Indication;
import models.loader.CompetencyLoader;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.IOException;

public class CompetencyController extends Controller {

    public static Result index() throws IOException {
        return ok(Json.toJson(CompetencyStore.VALUES));
    }
}
