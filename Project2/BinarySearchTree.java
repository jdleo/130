/**
 * BinarySearchTree.java
 * @author John Leonardo, W Reed
 * Class: CSC 130
 */

public class BinarySearchTree<Integer> {
    private BinaryNode<Integer> root;       //root of BST
    private int height;     //height of BST
    
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
    public BinaryNode<Integer> getRoot() {
        return this.root;
    }
    
    /**
     * Method for getting the height of this BST
     * @return height : returns the height of this BST
     */
    public int height() {
        return this.height;
    }
}


class BinaryNode<Integer> {
    int element;        //the data for this node
    BinaryNode<Integer> left;       //the left child node
    BinaryNode<Integer> right;      //the right child node
    
    /**
     * Constructor for BinaryNode class
     * @param element : the int data to issue this node
     * @param lt : the left child node
     * @param rt : the right child node
     */
    public BinaryNode(int element, BinaryNode<Integer> lt, BinaryNode<Integer> rt) {
        this.element = element;
        this.left = lt;
        this.right = rt;
    }
    
    /**
     * Method for getting the data this node contains
     * @return element : returns the data in this node
     */
    public int getData() {
        return this.element;
    }
    
    /**
     * Method for getting the left child node
     * @return left : returns the left child node
     */
    public BinaryNode<Integer> getLeft() {
        return this.left;
    }
    
    /**
     * Method for getting the right child node
     * @return right : returns the right child node
     */
    public BinaryNode<Integer> getRight() {
        return this.right;
    }
}
