/**
 * project2.java
 * @author John Leonardo, W Reed
 * Class: CSC 130
 */
import java.util.Random;

public class project2 {
    public static void main(String[] args) {
        long seed = System.currentTimeMillis();     //seed for random gen
        Random R = new Random(seed);        //initialize Random class
        
        BinarySearchTree tree1 = new BinarySearchTree();        //initialize BST
        BinaryNode root1 = new BinaryNode(R.nextInt(90) + 10);      //create node w random num
        tree1.setRoot(root1);       //set the root so we can start
        
        //keep going until tree height is 5
        while (tree1.height() < 5) {
            tree1.insert(R.nextInt(90) + 10, tree1.getRoot());      //insert node with random num in [10,99]
        }
        
        //print the final Binary Search tree
        TreePrinter printer = new TreePrinter(tree1);
        printer.print("-------------------------------------------------\n"+
                      "RANDOMLY GENERATED BINARY SEARCH TREE OF HEIGHT 5"+
                      "\n-------------------------------------------------");
        
        //now, repeatedly delete the root of the tree
        //and, print the tree after every deletion
        while (tree1.getRoot() != null) {
            tree1.removeRoot();
            TreePrinter tp = new TreePrinter(tree1);
            tp.print(" ");
        }
    }
}
