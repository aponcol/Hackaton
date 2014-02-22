package models.loader;

import com.google.common.collect.Lists;
import models.FileObjectLoader;
import models.competency.Competency;
import models.competency.Element;

import java.io.IOException;
import java.util.List;

public class CompetencyLoader {

    private static FileObjectLoader.ObjectMapper<Competency> loader = new FileObjectLoader.ObjectMapper<Competency>() {
        @Override
        public Competency createObject(String[] attributes) {
            return new Competency(Long.valueOf(attributes[0]), attributes[1], Lists.<Element>newArrayList());
        }
    };

    public static List<Competency> loadCompetencies() throws IOException {
        return FileObjectLoader.loadFromFile("input/competence.txt", loader);
    }
}
