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
        
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>;
        
        while (treeHeight < 5) {
            int num = R.nextInt(90) + 10;     //random integer w bounds
            
            //tree.put(num);
            //treeHeight = tree.height();
            
        }
        
        //print BinarySearchTree
    }
}
