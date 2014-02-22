package models.competency;

/**
 * Created by felix on 22/02/14.
 */
public class Indication {
    private long id;
    private String desc;

    public Indication(long id, String desc) {
        this.id = id;
        this.desc = desc;
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
