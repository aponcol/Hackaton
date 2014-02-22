package models.loader;

import models.FileObjectLoader;
import models.evaluation.EvaluatedElement;
import models.evaluation.Step;

import java.io.IOException;
import java.util.List;

public class EvaluatedElementsLoader {

    private static FileObjectLoader.ObjectMapper<EvaluatedElement> loader = new FileObjectLoader.ObjectMapper<EvaluatedElement>() {
        @Override
        public EvaluatedElement createObject(String[] attributes) {
            return
                    new EvaluatedElement(Long.valueOf(attributes[0]),
                            Long.valueOf(attributes[1]),
                            Step.valueOf(attributes[2]));
        }
    };

    public static List<EvaluatedElement> loadEvaluations() throws IOException {
        return FileObjectLoader.loadFromFile("evaluation/evaluated_elements.txt", loader);
    }
}
