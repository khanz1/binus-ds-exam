public class Train extends Transportation {
    private final int numberOfCarriages;
    private final int capacityPerCarriage;

    public Train(String name, int numberOfCarriages, int capacityPerCarriage) {
        super(name);
        if (numberOfCarriages < 0 || capacityPerCarriage < 0) {
            throw new IllegalArgumentException("values must be non-negative");
        }
        this.numberOfCarriages = numberOfCarriages;
        this.capacityPerCarriage = capacityPerCarriage;
    }

    public int getNumberOfCarriages() {
        return numberOfCarriages;
    }

    public int getCapacityPerCarriage() {
        return capacityPerCarriage;
    }

    @Override
    public int getTotalCapacity() {
        return numberOfCarriages * capacityPerCarriage;
    }
}


