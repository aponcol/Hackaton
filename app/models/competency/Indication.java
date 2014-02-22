package models.competency;

/**
 * Created by felix on 22/02/14.
 */
public class Indication {
    private long id;
    private String code;
    private String desc;
    private long elementId;

    public Indication(long id, String code, String desc, long elementId) {
        this.id = id;
        this.desc = desc;
        this.elementId = elementId;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getElementId() {
        return elementId;
    }

    public void setElementId(long elementId) {
        this.elementId = elementId;
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
}
