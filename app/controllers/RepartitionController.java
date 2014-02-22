package controllers;

import analysis.Repartition;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by felix on 22/02/14.
 */
public class RepartitionController extends Controller {

    public static Result get() {
        return ok(Json.toJson(new Repartition(2, 3, 4, 5)));
    }

}
