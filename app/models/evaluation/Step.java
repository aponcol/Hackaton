package models.evaluation;

public enum Step {
    D(1), A(2), RC(3), E(4);

    private int value;

    Step(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Step fromValue(int value) {
        switch (value) {
            case 1: return D;
            case 2: return A;
            case 3: return RC;
            case 4: return E;
            default: throw new IllegalArgumentException("Wrong value for Step: " + value);
        }
    }
}
