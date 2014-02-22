package models.competency;

import java.util.List;

/**
 * Created by felix on 22/02/14.
 */
public class Element {
    private long id;
    private String desc;
    private long competenceId;
    private List<Indication> indications;

    public Element(long id, String desc, long competenceId, List<Indication> indications) {
        this.id = id;
        this.desc = desc;
        this.indications = indications;
        this.competenceId = competenceId;
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

    public List<Indication> getIndications() {

        return indications;
    }

    public void setIndications(List<Indication> indications) {
        this.indications = indications;
    }

    public long getCompetenceId() {
        return competenceId;
    }

    public void setCompetenceId(long competenceId) {
        this.competenceId = competenceId;
    }
}
