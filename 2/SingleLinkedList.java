public class SingleLinkedList {
    
    private class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    
    public SingleLinkedList() {
        this.head = null;
    }
    
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    public boolean insertAfter(int targetValue, int newValue) {
        Node current = head;
        
        while (current != null) {
            if (current.data == targetValue) {
                Node newNode = new Node(newValue);
                newNode.next = current.next;
                current.next = newNode;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public boolean delete(int value) {
        if (head == null) {
            return false;
        }
        
        if (head.data == value) {
            head = head.next;
            return true;
        }
        
        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public static void main(String[] args) {
        SingleLinkedList deret = new SingleLinkedList();
        
        int[] numbers = {43, 5, 9, 42, 6, 40, 36, 16, 35, 14, 30, 25, 11, 41, 7, 13, 100, 12, 70, 24};
        
        System.out.println("--- Single Linked List ---\n");
        
        System.out.println("a. Insert semua angka tersebut ke Single Linked List dan tampilkan");
        for (int number : numbers) {
            deret.insertAtEnd(number);
        }
        deret.display();
        System.out.println("Total elements: " + deret.size() + "\n");
        
        
        System.out.println("b. Lakukan proses insert angka 66 setelah angka 16:");
        deret.insertAfter(16, 66);
        deret.display();
        System.out.println("Total elements: " + deret.size() + "\n");
        
        System.out.println("c. Lakukan proses delete angka 100:");
        deret.delete(100);
        deret.display();
        System.out.println("Total elements: " + deret.size());
    }
}
