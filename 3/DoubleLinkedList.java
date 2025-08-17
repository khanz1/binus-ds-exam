public class DoubleLinkedList {
    
    private class Node {
        int data;
        Node prev;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;
    
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    
    public boolean insertAfter(int targetValue, int newValue) {
        Node current = head;
        
        while (current != null) {
            if (current.data == targetValue) {
                Node newNode = new Node(newValue);
                
                newNode.next = current.next;
                newNode.prev = current;
                
                if (current.next != null) {
                    current.next.prev = newNode;
                } else {
                    tail = newNode;
                }
                
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
        
        Node current = head;
        
        while (current != null) {
            if (current.data == value) {
                if (current.prev == null && current.next == null) {
                    head = null;
                    tail = null;
                }
                else if (current.prev == null) {
                    head = current.next;
                    head.prev = null;
                }
                else if (current.next == null) {
                    tail = current.prev;
                    tail.next = null;
                }
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
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
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public static void main(String[] args) {
        DoubleLinkedList deret = new DoubleLinkedList();
        
        int[] numbers = {43, 5, 9, 42, 6, 11, 41, 7, 13, 100, 12, 70, 24, 40, 36};
        
        System.out.println("--- DOUBLE LINKED LIST ---");
        
        System.out.println("a. Insert semua angka tersebut ke Double Linked List dan tampilkan:");
        for (int number : numbers) {
            deret.insertAtEnd(number);
        }
        deret.displayForward();
        System.out.println("Total elements: " + deret.size() + "\n");
        
        System.out.println("b. Lakukan proses insert angka 15 setelah angka 12:");
        deret.insertAfter(12, 15);
        deret.displayForward();
        System.out.println("Total elements: " + deret.size() + "\n");
        
        System.out.println("c. Lakukan proses delete angka 41:");
        deret.delete(41);
        deret.displayForward();
        System.out.println("Total elements: " + deret.size());
    }
}
