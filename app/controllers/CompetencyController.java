package controllers;

import models.competency.CompetencyStore;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.IOException;

public class CompetencyController extends Controller {

    public static Result index() throws IOException {
        return ok(Json.toJson(CompetencyStore.COMPETENCES));
    }
}
