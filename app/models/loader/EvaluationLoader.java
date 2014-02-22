package models.loader;

import com.google.common.collect.Lists;
import models.FileObjectLoader;
import models.evaluation.EvaluatedElement;
import models.evaluation.Evaluation;

import java.io.IOException;
import java.util.List;

public class EvaluationLoader {
    private static FileObjectLoader.ObjectMapper<Evaluation> loader = new FileObjectLoader.ObjectMapper<Evaluation>() {
        @Override
        public Evaluation createObject(String[] attributes) {
            return
                    new Evaluation(Long.valueOf(attributes[0]),
                            Long.valueOf(attributes[1]),
                            Integer.valueOf(attributes[2]),
                            Lists.<EvaluatedElement>newArrayList());
        }
    };

    public static List<Evaluation> loadEvaluations() throws IOException {
        return FileObjectLoader.loadFromFile("evaluation/evaluation.txt", loader);
    }
}
