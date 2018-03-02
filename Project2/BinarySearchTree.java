/**
 * BinarySearchTree.java
 * @author John Leonardo, W Reed
 * Class: CSC 130
 */

public class BinarySearchTree<Integer> {
    private Node root;      //root of BST
    private int height;     //height of BST
    
    /**
     * Method for getting the root of this BST
     * @return root : returns the root of this BST
     */
    public Node getRoot() {
        return root;
    }
    
    /**
     * Method for getting the height of this BST
     * @return height : returns the height of this BST
     */
    public int height() {
        return height;
    }
}

class Node {
    int key;
    Node left, right;
    
    public Node(int item) {
        key = item;
        left = right = null;
    }
}
