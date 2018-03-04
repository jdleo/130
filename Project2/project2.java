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
        int treeHeight = 0;     //to keep track of tree height
        
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        
        tree.put(R.nextInt(90) + 10);        //insert root
        
        while (treeHeight < 5) {
            int num = R.nextInt(90) + 10;     //random integer w bounds
            
            tree.put(num, tree.getRoot());      //insert data
            treeHeight = tree.height();     //update tree height
        }
        
        //print our BST
        System.out.print("\n-----------------------------------\n"+
                         "-----------------------------------\n");
        TreePrinter printer = new TreePrinter(tree);
        printer.print("Initial BST");
        
        System.out.print("\n-----------------------------------\n"+
                         "-----------------------------------\n");
        
        //repeatedly delete the root of the tree
        //print to verify deletion was done correctly
        //stop when tree is empty
        while (tree.getRoot() != null) {
            int toDelete = tree.getRoot().element;
            
            //delete
            tree.delete(toDelete);
            
            //print our BST
            TreePrinter tp = new TreePrinter(tree);
            String title = String.format("Removed element: %d", toDelete);
            tp.print(title);
        }
        
        System.out.print("\n-----------------------------------\n"+
                         "-----------------------------------\n");
        
        //Create an AVL tree and insert 35 random integers in [10,99]
        AVLTree<Integer> avlTree = new AVLTree<Integer>();
        avlTree.put(R.nextInt(90) + 10);        //insert root
        for (int i = 0; i < 35; i++) {
            avlTree.put(R.nextInt(90) + 10, avlTree.getRoot());
            
            //print our AVL tree
            TreePrinter tp = new TreePrinter(avlTree);
            tp.print(" ");
        }
    }
}
