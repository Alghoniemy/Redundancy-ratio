package javaapplication53;

import java.util.Scanner;



public class BST_RepetitionsCheck_2 {

   
public static void main(String[] args) {
        BST tree = new BST();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Redundancy Ratio 'r' while r>1 ");
        double y = sc.nextDouble();
        double size = 0;
        double s;
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter the value of the #" + (i + 1) + " number");
            size++;
            int x = sc.nextInt();
            if (x == -1) {
                System.out.println("---ONLY FEW REPETITIONS ---");
                break;
            }
            tree.Insert(x, size);
            s = size / (size - tree.count);

            System.out.println("Current ratio : " + s);
            if (size / (size - tree.count) >= y) {
                System.out.println("\n-----MANY REPETITIONS------");
                break;
            }
        }

        System.out.println(" \n-----DISTINCT ELEMENTS-----");
        tree.printInorder(tree.root);

    }
}

class BST {

    class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    Node root;
    int count;

    BST() {
        root = null;
    }

    public void Insert(int key, double size) {
        root = insert(key, root, size);
    }

    public Node insert(int key, Node root, double size) {

        if (root == null) {
            root = new Node(key);
            return root;
        } else if (key == root.key) {
            count++;

            return root;
        } else if (key < root.key) {
            root.left = insert(key, root.left, size);

        } else {
            root.right = insert(key, root.right, size);

        }

        return root;

    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);

        System.out.println(node.key);

        printInorder(node.right);

    }

}
       
  