/**
 * BinarySearchTree.java
 * @author John Leonardo, W Reed
 * Class: CSC 130
 */

public class BinarySearchTree<Integer> {
    private BinaryNode<Integer> root;      //root of BST
    
    
    /**
     * Constructor for BinarySearchTree class
     */
    public BinarySearchTree() {
        this.root = null;
    }
    
    /**
     * Method for getting the root of this BST
     * @return root : returns the root of this BST
     */
    public BinarySearchTree<Integer> getRoot() {
        return root;
    }
}


class BinaryNode<Integer> {
    int element;
    BinaryNode<Integer> left;
    BinaryNode<Integer> right;
    
    public BinaryNode(int element, BinaryNode<Integer> lt, BinaryNode<Integer> rt) {
        this.element = element;
        this.left = lt;
        this.right = rt;
    }
}
