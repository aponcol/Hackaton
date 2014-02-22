package models.competency;

import models.loader.CompetencyLoader;
import models.loader.ElementLoader;
import models.loader.IndicationLoader;

import java.io.IOException;
import java.util.List;

/**
 * Created by felix on 22/02/14.
 */
public class CompetencyStore {

    public static List<Competency> VALUES = null;

    static {
        try {
            VALUES = CompetencyLoader.loadCompetencies();
            List<Element> elements = ElementLoader.loadElements();
            List<Indication> indications = IndicationLoader.loadIndications();

            for (Element e : elements) {
                for (Indication i : indications) {
                    if (e.getId() == i.getElementId()) {
                        e.getIndications().add(i);
                    }
                }
            }

            for(Competency c: VALUES) {
                for(Element e : elements) {
                    if(c.getId() == e.getCompetenceId()) {
                        c.getElements().add(e);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
