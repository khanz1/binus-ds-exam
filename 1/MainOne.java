import java.util.ArrayList;
import java.util.List;

public class MainOne {
    public static void main(String[] args) {
        List<Transportation> list = new ArrayList<>();
        list.add(new Bus("Bus Ekonomi", 40));
        list.add(new Train("Kereta Cepat", 10, 50));
        list.add(new Bus("Bus VIP", 30));

        System.out.println("\nDaftar Transportasi:");
        for (Transportation t : list) {
            System.out.println(t.toString());
        }

        int total = list.stream().mapToInt(Transportation::getTotalCapacity).sum();
        System.out.println("\nTotal kapasitas semua transportasi: " + total + " penumpang");
    }
}


