public abstract class Transportation {
    private final String name;

    protected Transportation(String name) {
        this.name = name;
        System.out.println(name + " ditambahkan ke sistem");
    }

    public String getName() {
        return name;
    }

    public abstract int getTotalCapacity();

    public String getType() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "Nama Transportasi: " + name + ", Kapasitas: " + getTotalCapacity() + " penumpang";
    }
}


