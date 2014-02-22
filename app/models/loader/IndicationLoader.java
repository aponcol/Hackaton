package models.loader;

import models.FileObjectLoader;
import models.competency.Indication;

import java.io.IOException;
import java.util.List;

public class IndicationLoader {

    private static FileObjectLoader.ObjectMapper<Indication> loader = new FileObjectLoader.ObjectMapper<Indication>() {
        @Override
        public Indication createObject(String[] attributes) {
            return new Indication(Long.valueOf(attributes[0]), attributes[1], attributes[2], Long.valueOf(attributes[3]));
        }
    };

    public static List<Indication> loadIndications() throws IOException {
        return FileObjectLoader.loadFromFile("input/indication.txt", loader);
    }
}
