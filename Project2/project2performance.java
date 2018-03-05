/**
 * project2performance.java
 * @author John Leonardo, W Reed
 * Class: CSC 130
 */
import java.util.Random;
import java.util.Scanner;

public class project2performance {
    public static void main(String[] args) {
        long seed = System.currentTimeMillis();     //seed for random gen
        Random R = new Random(seed);        //initialize Random class
        
        BinarySearchTree tree1 = new BinarySearchTree();        //initialize BST
        AVLTree tree2 = new AVLTree();      //initialize AVL
        
        int rootData = R.nextInt();
        BinaryNode root1 = new BinaryNode(rootData);     //create root for BST
        BinaryNode root2 = new BinaryNode(rootData);     //create root for AVL
        
        tree1.setRoot(root1);       //set the BST root to start
        tree2.setRoot(root2);       //set the AVL root to start
        
        int n = Integer.parseInt(args[0]);        //input size to test
        
        int[] dataSet = new int[n];     //array that will hold the data set
        for(int i = 0; i < n; i++) {
            //fill our data set with dummy data
            dataSet[i] = R.nextInt();
        }
        
        /* TIMING BST PERFORMANCE IN MILLISECONDS */
        long start = System.currentTimeMillis();
        for(int x: dataSet) {
            tree1.insert(x, tree1.getRoot());
        }
        long end = System.currentTimeMillis();
        System.out.printf("BST RUNTIME RESULTS:\n"+
                          "MILLISECONDS: %d\n"+
                          "--------------------\n", end-start);
        
        /* TIMING AVL PERFORMANCE IN MILLISECONDS */
        start = System.currentTimeMillis();
        for(int x: dataSet) {
            tree2.insert(x, tree2.getRoot(), true);
        }
        end = System.currentTimeMillis();
        System.out.printf("AVL RUNTIME RESULTS:\n"+
                          "MILLISECONDS: %d\n"+
                          "--------------------\n", end-start);
        
    }
    
}
