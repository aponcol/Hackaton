package models.competency;

import java.util.List;

/**
 * Created by felix on 22/02/14.
 */
public class Competency {
    private long id;
    private String desc;

    private List<Element> elements;
    public Competency(long id, String desc, List<Element> elements) {
        this.id = id;
        this.desc = desc;
        this.elements = elements;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}
