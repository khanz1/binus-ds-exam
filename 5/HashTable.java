public class HashTable {
    private static final int TABLE_SIZE = 7;
    private final String[] table;
    private final boolean[] occupied;
    
    public HashTable() {
        table = new String[TABLE_SIZE];
        occupied = new boolean[TABLE_SIZE];
    }
    
    private int hash(String key) {
        return key.length() % TABLE_SIZE;
    }
    
    public void insert(String key) {
        int index = hash(key);
        int originalIndex = index;
        
        while (occupied[index]) {
            System.out.println("Collision at index " + index + " for key '" + key + "'");
            index = (index + 1) % TABLE_SIZE;
            
            if (index == originalIndex) {
                System.out.println("Hash table is full!");
                return;
            }
        }
        
        table[index] = key;
        occupied[index] = true;
        System.out.println("Inserted '" + key + "' at index " + index + 
                          " (hash value: " + hash(key) + ")");
    }
    
    public boolean search(String key) {
        int index = hash(key);
        int originalIndex = index;
        
        while (occupied[index]) {
            if (table[index].equals(key)) {
                return true;
            }
            index = (index + 1) % TABLE_SIZE;
            
            if (index == originalIndex) {
                break;
            }
        }
        return false;
    }
    
    public void display() {
        System.out.println("\nHash Table:");
        System.out.println("Index\tValue");
        System.out.println("-----\t-----");
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (occupied[i]) {
                System.out.println(i + "\t" + table[i]);
            } else {
                System.out.println(i + "\t[empty]");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        
        String[] vehicles = {"Motor", "Mobil", "Bus", "Truk", "Kereta", "Sepeda", "Kapal"};
        
        System.out.println("--- Hash Table ---");
        System.out.println("Table Size: " + TABLE_SIZE);
        System.out.println("Hash Function: key.length() % " + TABLE_SIZE);
        System.out.println();
        
        for (String vehicle : vehicles) {
            hashTable.insert(vehicle);
            hashTable.display();
        }
        
    }
}
