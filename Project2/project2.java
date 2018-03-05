/**
 * project2.java
 * @author John Leonardo, W Reed
 * Class: CSC 130
 */
import java.util.Random;
import java.util.Arrays;

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
            tp.print("\nRemoved the root...");
        }
        
        AVLTree tree2 = new AVLTree();      //initialize AVL
        int randomNum = R.nextInt(90) + 10;     //random num w bounds [10,99]
        BinaryNode root2 = new BinaryNode(randomNum);       //create node w random num
        tree2.setRoot(root2);
        
        //insert 34 random values into this new AVL tree (35 - 1, since we have root)
        //they must be unique, so let's keep track in an array
        int[] usedNumbers = new int[35];
        usedNumbers[0] = randomNum;     //we know the root
        for (int i = 0; i < 34; i++) {
            int num = R.nextInt(90) + 10;
            
            //if the number is used, keep trying until we find un-used
            while (Arrays.asList(usedNumbers).contains(num)) {
                num = R.nextInt(90) + 10;
            }
            usedNumbers[i + 1] = num;
            tree2.setRoot(tree2.insert(num, tree2.getRoot()));
            TreePrinter tp = new TreePrinter(tree2);
            tp.print(" ");
        }
    }
}
