package analysis;

import com.google.common.collect.Lists;
import models.nurse.Nurse;

import java.util.List;

public class StepRepartitionResult<T> {

    private int count;
    private List<T> details;

    public StepRepartitionResult() {
        this(0, Lists.<T>newArrayList());
    }

    public StepRepartitionResult(int count, List<T> details) {
        this.count = count;
        this.details = details;
    }

    public int getCount() {
        return count;
    }

    public List<T> getDetails() {
        return details;
    }

    public void addElement(T element) {
        count += 1;
        details.add(element);
    }
}
