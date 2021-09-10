package ee.ttu.algoritmid.dancers;

public class DancingCoupleImpl implements DancingCouple {

    private Dancer male;
    private Dancer female;

    public DancingCoupleImpl(Dancer male, Dancer female) {
        this.male = male;
        this.female = female;
    }

    @Override
    public Dancer getMaleDancer() {
        return male;
    }

    @Override
    public Dancer getFemaleDancer() {
        return female;
    }

    @Override
    public String toString() {
        return "DancingCoupleImpl{" +
                "male=" + male +
                ", female=" + female +
                '}';
    }
}
