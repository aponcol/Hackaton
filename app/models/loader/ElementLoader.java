package models.loader;

import com.google.common.collect.Lists;
import models.FileObjectLoader;
import models.competency.Element;
import models.competency.Indication;

import java.io.IOException;
import java.util.List;

public class ElementLoader {

    private static FileObjectLoader.ObjectMapper<Element> loader = new FileObjectLoader.ObjectMapper<Element>() {
        @Override
        public Element createObject(String[] attributes) {
            return new Element(Long.valueOf(attributes[0]), attributes[1], attributes[2], Long.valueOf(attributes[3]), Lists.<Indication>newArrayList());
        }
    };

    public static List<Element> loadElements() throws IOException {
        return FileObjectLoader.loadFromFile("input/element.txt", loader);
    }
}
