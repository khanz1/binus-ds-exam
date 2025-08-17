public class BST {
    private Node root;
    
    private class Node {
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public BST() {
        this.root = null;
    }
    
    public void insert(int data) {
        root = insert(root, data);
    }
    
    private Node insert(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        
        if (data < current.data) {
            current.left = insert(current.left, data);
        }
        else if (data > current.data) {
            current.right = insert(current.right, data);
        }
        
        return current;
    }
    
    private void displayTree(Node current, String prefix, boolean isLast) {
        if (current != null) {
            System.out.println(prefix + (isLast ? "└── " : "├── ") + current.data);
            
            if (current.left != null || current.right != null) {
                if (current.left != null) {
                    displayTree(current.left, prefix + (isLast ? "    " : "│   "), current.right == null);
                }
                if (current.right != null) {
                    displayTree(current.right, prefix + (isLast ? "    " : "│   "), true);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        BST bst = new BST();
        
        int[] data = {22, 17, 12, 19, 27, 9, 25, 20, 21, 27};
        
        System.out.println("--- Binary Search Tree ---");
        System.out.println("Insert semua angka tersebut ke BST dan tampilkan proses");
        System.out.println();
        
        for (int i = 0; i < data.length; i++) {
            System.out.println("Step " + (i + 1) + ": Inserting " + data[i]);
            bst.insert(data[i]);
            bst.displayTree(bst.root, "", true);
            System.out.println();
        }
    }
}
