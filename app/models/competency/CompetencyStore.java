package models.competency;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import models.loader.CompetencyLoader;
import models.loader.ElementLoader;
import models.loader.IndicationLoader;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CompetencyStore {

    public static List<Competency> COMPETENCIES = null;
    public static Map<Long, Set<Long>> COMPETENCE_ID_TO_ELEMENT_ID_MAP = Maps.newHashMap();

    static {
        try {
            COMPETENCIES = CompetencyLoader.loadCompetencies();
            List<Element> elements = ElementLoader.loadElements();
            List<Indication> indications = IndicationLoader.loadIndications();

            for (Element e : elements) {
                for (Indication i : indications) {
                    if (e.getId() == i.getElementId()) {
                        e.getIndications().add(i);
                    }
                }
            }

            for(Competency c: COMPETENCIES) {
                for(Element e : elements) {
                    if(c.getId() == e.getCompetenceId()) {
                        c.getElements().add(e);
                        Set<Long> currentIdSet = COMPETENCE_ID_TO_ELEMENT_ID_MAP.get(c.getId());
                        if(currentIdSet == null) {
                            currentIdSet = Sets.newHashSet(e.getId());
                        }
                        currentIdSet.add(e.getId());
                        COMPETENCE_ID_TO_ELEMENT_ID_MAP.put(c.getId(), currentIdSet);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
