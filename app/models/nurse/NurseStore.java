package models.nurse;

import models.WorkShift;
import models.WorkUnit;

import java.util.HashMap;
import java.util.Map;

public class NurseStore {
    public static int NB_NURSE = 200;
    public static Map<Long, Nurse> MAP = null;
    private static String[] firstNames = {"Josée", "Lysianne", "Annie", "Josée-Lina", "Sylvaine", "Félicia", "Philippa", "Simon", "Naderia"};
    private static String[] lastNames = {"Darce", "Bouchard", "Oliviera", "Ray", "Ace", "Tremblay", "Dufo"};
    private static WorkShift[] workShifts = {WorkShift.DAY, WorkShift.EVENING, WorkShift.NIGHT};
    private static WorkUnit[] workUnits = { WorkUnit.EMERGENCY, WorkUnit.INTENSIVE_CARE, WorkUnit.HEMATO_ONCO,WorkUnit.OBSTETRIC,
            WorkUnit.UNIT_MOTHER_CHILD, WorkUnit.NEO_NATALOGY, WorkUnit.SURGERY, WorkUnit.OP_BLOCK, WorkUnit.INFECTIONS_DISEASE};

    static {
        BoundValueProvider<String> firstNameProvider = new BoundValueProvider<>(firstNames);
        BoundValueProvider<String> lastNameProvider = new BoundValueProvider<>(lastNames);
        BoundValueProvider<WorkUnit> workUnitProvider = new BoundValueProvider<>(workUnits);
        BoundValueProvider<WorkShift> workShiftProvider = new BoundValueProvider<>(workShifts);

        MAP = new HashMap<>();

        for(long id = 1; id <= NB_NURSE; id++) {
            MAP.put(id, new Nurse(id, firstNameProvider.getNext() + " " + lastNameProvider.getNext(),
                    workUnitProvider.getNext(), workShiftProvider.getNext()));
        }
    }

    private static class BoundValueProvider<T> {
        private int index = 0;
        private final T[] values;

        private BoundValueProvider(T[] values) {
            this.values = values;
        }

        public T getNext() {
            T next = values[index];
            index = (index + 1) % values.length;
            return next;
        }
    }


}
