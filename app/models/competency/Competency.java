package models.competency;

import java.util.List;

public class Competency {
    private long id;
    private String desc;
    private String shortDesc;
    private String code;
    private List<Element> elements;

    public Competency(long id, String code, String desc, String shortDesc, List<Element> elements) {
        this.id = id;
        this.code = code;
        this.desc = desc;
        this.shortDesc = shortDesc;
        this.elements = elements;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
