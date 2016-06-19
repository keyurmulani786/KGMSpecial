import java.io.*;
import java.util.Scanner;
public class Solution {
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner scan = new Scanner(System.in);

     //   System.out.println("Enter first node ::");
        int a = scan.nextInt();

       // System.out.println("Enter second node ::");
        int b = scan.nextInt();

        //System.out.println("Enter number of nodes ");
        int numNode = scan.nextInt();

        BST bst = new BST();
        //System.out.println("Enter all nodes ");
        for (int i = 0; i < numNode; i++) {
            bst.insert(insertNodeVal());

        }

        try {
            long result = bst.findDistance(a, b);
            //System.out.println(result);
            if (result <= 0) {
                System.out.println("Not found");
            } else {
                System.out.println(result);
            }
        } catch (Exception e) {
            System.out.println("Not found");
        }
    }

    public static long insertNodeVal() {
        Scanner scan = new Scanner(System.in);
        long value = scan.nextInt();

        if (value < 0 || value > 4294967296L) {
            System.out.println("enter proper value in range [0, 2^32]");
            value = insertNodeVal();
        }
        return value;
    }
}
class BSTNode {

    BSTNode left, right;
    long data;

    /* Constructor */
    public BSTNode() {
        left = null;
        right = null;
        data = 0;
    }
    /* Constructor */

    public BSTNode(long n) {
        left = null;
        right = null;
        data = n;
    }
    /* Function to set left node */

    public void setLeft(BSTNode n) {
        left = n;
    }
    /* Function to set right node */

    public void setRight(BSTNode n) {
        right = n;
    }
    /* Function to get left node */

    public BSTNode getLeft() {
        return left;
    }
    /* Function to get right node */

    public BSTNode getRight() {
        return right;
    }
    /* Function to set data to node */

    public void setData(long d) {
        data = d;
    }
    /* Function to get data from node */

    public long getData() {
        return data;
    }
}

/* Class BST */
class BST {

    private BSTNode root;

    /* Constructor */
    public BST() {
        root = null;
    }
    /* Function to check if tree is empty */

    public boolean isEmpty() {
        return root == null;
    }
    /* Functions to insert data */

    public void insert(long data) {
        root = insert(root, data);
    }
    /* Function to insert data recursively */

    private BSTNode insert(BSTNode node, long data) {
        if (node == null) {
            node = new BSTNode(data);
        } else {
            if (data <= node.getData()) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    public long findDistance(long n1, long n2) {
        long x = Pathlength(root, n1) - 1;
        long y = Pathlength(root, n2) - 1;
        long lcaData = findLCA(root, n1, n2).data;
        long lcaDistance = Pathlength(root, lcaData) - 1;
        return (x + y) - 2 * lcaDistance;
    }

    public long Pathlength(BSTNode root, long n1) {
        if (root != null) {
            long x = 0;
            if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
                    || (x = Pathlength(root.right, n1)) > 0) {
                // System.out.println(root.data);
                return x + 1;
            }
            return 0;
        }
        return 0;
    }

    public BSTNode findLCA(long n1, long n2) {
        return findLCA(root, n1, n2);
    }

    public BSTNode findLCA(BSTNode root, long n1, long n2) {

        if (root != null) {
            if (root.data == n1 || root.data == n2) {
                return root;
            }
            BSTNode left = findLCA(root.left, n1, n2);
            BSTNode right = findLCA(root.right, n1, n2);

            if (left != null && right != null) {
                return root;
            }
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
        }
        return null;
    }

}




