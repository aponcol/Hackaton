package analysis;

import com.google.common.collect.Lists;
import models.nurse.Nurse;

import java.util.List;

public class StepRepartitionResult {

    private int count;
    private List<Nurse> nurses;

    public StepRepartitionResult() {
        this(0, Lists.<Nurse>newArrayList());
    }

    public StepRepartitionResult(int count, List<Nurse> nurses) {
        this.count = count;
        this.nurses = nurses;
    }

    public int getCount() {
        return count;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void addNurse(Nurse nurseSummary) {
        count += 1;
        nurses.add(nurseSummary);
    }
}
