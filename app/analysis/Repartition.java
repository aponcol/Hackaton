package analysis;

public class Repartition {
    private final int numD;
    private final int numA;
    private final int numRC;
    private final int numE;

    public Repartition(int numD, int numA, int numRC, int numE) {
        this.numD = numD;
        this.numA = numA;
        this.numRC = numRC;
        this.numE = numE;
    }

    public int getNumD() {
        return numD;
    }

    public int getNumA() {
        return numA;
    }

    public int getNumRC() {
        return numRC;
    }

    public int getNumE() {
        return numE;
    }
}
