package controllers;

import models.Database;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result test() throws Exception {
//        Database.test();
        Database.setV(2);
        int res = Database.get();
        System.out.println(res);
        return ok(Integer.toString(res));
    }

}
