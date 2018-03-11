package rtrk.pnrs.food;

public class Portion {

    private static final String EXCEPTION_TEXT = "Portion value can not be negative.";

    // food in kilograms
    private float food;

    public Portion() {
        this.food = 0;
    }

    public void setFood(float food) throws IllegalArgumentException {
        if (food < 0) {
            throw new IllegalArgumentException(EXCEPTION_TEXT);
        } else {
            this.food = food;
        }
    }

    public float getFood() {
        return food;
    }
}
