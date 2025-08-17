public class Bus extends Transportation {
    private final int seatCapacity;

    public Bus(String name, int seatCapacity) {
        super(name);
        if (seatCapacity < 0) {
            throw new IllegalArgumentException("seatCapacity must be non-negative");
        }
        this.seatCapacity = seatCapacity;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    @Override
    public int getTotalCapacity() {
        return seatCapacity;
    }
}


