/**
 * BinaryNode.java
 * @author John Leonardo, W Reed
 * Class: CSC 130
 */

public class BinaryNode {
    int data;        //data for this node
    BinaryNode left;        //left child
    BinaryNode right;       //right child
    int height;     //height for node
    
    /**
     * Constructor
     * @param x : data to initialize this node with
     */
    BinaryNode(int x) {
        this(x, null, null);
    }
    
    /**
     * Constructor
     * @param x : data to initialize this node with
     * @param lt : left child
     * @param rt : right child
     */
    BinaryNode(int x, BinaryNode lt, BinaryNode rt) {
        this.data = x;
        this.left = lt;
        this.right = rt;
    }
    
    /**
     * Getter for data
     * @return data
     */
    public int getData() {
        return this.data;
    }
    
    /**
     * Getter for left child
     * @return left
     */
    public BinaryNode getLeft() {
        return this.left;
    }
    
    /**
     * Getter for right child
     * @return right
     */
    public BinaryNode getRight() {
        return this.right;
    }
    
    /**
     * Setter for data
     * @param x : the data to assign
     */
    public void setData(int x) {
        this.data = x;
    }
    
    /**
     * Setter for left child
     * @param node : node to assign as left child
     */
    public void setLeft(BinaryNode node) {
        this.left = node;
    }
    
    /**
     * Setter for right child
     * @param node : node to assign as right child
     */
    public void setRight(BinaryNode node) {
        this.right = node;
    }
    
    
    
}
