import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Treet {
    Node root;

    void insert(Node r, Node n) {
        if (root == null) {
            root = n;
        } else {
            if (n.data < r.data) {
                if (r.left == null) {
                    r.left = n;
                } else {
                    insert(r.left, n);
                }
            } else {
                if (r.right == null) {
                    r.right = n;
                } else {
                    insert(r.right, n);
                }
            }
        }
    }

    void inorder(Node r) {
        if (r != null) {
            inorder(r.left); 
            System.out.print(r.data + " , "); 
            inorder(r.right); 
        }
    }

    void preorder(Node r) {
        if (r != null) {
            System.out.print(r.data + " , "); 
            preorder(r.left); 
            preorder(r.right); 
        }
    }

    void postorder(Node r) {
        if (r != null) {
            postorder(r.left); 
            postorder(r.right); 
            System.out.print(r.data + " , "); 
        }
    }

    int count(Node r) {
        if (r != null) {
            return 1 + count(r.left) + count(r.right);
        }
        return 0;
    }

    int countLeafNodes(Node r) {
        if (r == null) {
            return 0;
        } else if (r.left == null && r.right == null) {
            return 1;
        } else {
            return countLeafNodes(r.left) + countLeafNodes(r.right);
        }
    }

    int depth(Node r) {
        if (r == null) {
            return 0;
        } else {
            int left_depth = depth(r.left);
            int right_depth = depth(r.right);
            return 1 + Math.max(left_depth, right_depth);
        }
    }

    boolean search(Node r, int m) {
        if (r == null) {
            return false;
        } else if (r.data == m) {
            return true;
        } else if (m < r.data) {
            return search(r.left, m);
        } else {
            return search(r.right, m);
        }
    }

    int findsum(Node r) {
        if (r != null) {
            return r.data + findsum(r.left) + findsum(r.right);
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Treet t = new Treet();

        System.out.println("Enter 10 elements:");
        for (int i = 0; i < 10; i++) {
            t.insert(t.root, new Node(sc.nextInt()));
        }

        System.out.println("\nInorder traversal:");
        t.inorder(t.root);

        System.out.println("\nPreorder traversal:");
        t.preorder(t.root);

        System.out.println("\nPostorder traversal:");
        t.postorder(t.root);

        System.out.println("\nTotal number of nodes: " + t.count(t.root));
        System.out.println("Total number of leaf nodes: " + t.countLeafNodes(t.root));
        System.out.println("Tree depth (edges from root to deepest leaf): " + (t.depth(t.root) - 1));

        System.out.print("\nEnter value to search: ");
        int val = sc.nextInt();
        System.out.println("Search result: " + (t.search(t.root, val) ? "Found" : "Not Found"));

        System.out.println("Sum of all node values: " + t.findsum(t.root));

        sc.close();
    }
}
