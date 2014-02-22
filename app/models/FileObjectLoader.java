package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileObjectLoader {

    public static <T> List<T> loadFromFile(String filename, ObjectMapper<T> mapper) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(filename));
        String line;
        List<T> objects = new ArrayList<T>();
        while ((line = r.readLine()) != null) {
            if (!line.startsWith("#") && !line.isEmpty()) {
                String[] values = line.split(";");
                for(int i = 0;i<values.length;i++) {
                    System.out.println(values[i]);
                }
                objects.add(mapper.createObject(values));
            }
        }
        return objects;
    }

    public static interface ObjectMapper<T> {
        public T createObject(String[] attributes);
    }
}
