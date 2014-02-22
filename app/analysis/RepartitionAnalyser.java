package analysis;

import com.google.common.collect.Lists;
import models.WorkUnit;
import models.evaluation.Evaluation;
import models.nurse.NurseStore;

import java.util.List;

public class RepartitionAnalyser {

    public static List<Evaluation> filterByUnit(List<Evaluation> evaluations, WorkUnit workUnit) {
        List<Evaluation> filtered = Lists.newArrayList();
        for(Evaluation e : evaluations) {
            if(NurseStore.MAP.get(e.getNurseId()).getWorkUnit().equals(workUnit)) {
                filtered.add(e);
            }
        }
        return filtered;
    }

}
