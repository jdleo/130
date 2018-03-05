/**
 * BinarySearchTree.java
 * @author John Leonardo, W Reed
 * Class: CSC 130
 */

public class BinarySearchTree {
    private BinaryNode root;        //the root
    
    /**
     * Constructor
     */
    public BinarySearchTree() {
        root = null;
    }
    
    /**
     * Method to insert a node into this tree
     * @param x : data to insert
     * @param node
     * @return the node
     */
    public BinaryNode insert(int x, BinaryNode node) {
      //create a new node to be attached to the last visited node
        if (node == null) {
            return new BinaryNode(x, null, null);
        }
        
        int comparison = (x - node.getData());
        
        //find insertion point
        if (comparison < 0) {
            node.setLeft(insert(x, node.getLeft()));
        } else if (comparison > 0) {
            node.setRight(insert(x, node.getRight()));
        } else {
            //duplicate : do nothing
        }
        
        return node;        //return the final node
    }
    
    /**
     * Method to remove a node in a subtree
     * @param x : data to find and remove
     * @param t : root of the subtree to search
     * @return node
     */
    public BinaryNode remove(int x, BinaryNode t) {
        if (t == null) return t;        //item not found, do nothing
        int comparison = (x - t.getData());     //comparison
        
        if (comparison < 0) {
            t.setLeft(remove(x, t.getLeft()));
        } else if (comparison > 0) {
            t.setRight(remove(x, t.getRight()));
        } else if (t.getLeft() != null && t.getRight() != null) {
            t.setData(findMin(t.getRight()).getData());
            t.setRight(remove(t.getData(), t.getRight()));
        } else {
            t = (t.getLeft() != null) ? t.getLeft() : t.getRight();
        }
        
        return t;       //return the node
    }
    
    /**
     * Method to remove the root of this tree
     */
    public void removeRoot() {
        this.root = remove(root.getData(), root);
    }
    
    /**
     * Method to find minimum value of a subtree
     * @param t : root node of subtree to find min of
     * @return node the node with the minimum value
     */
    private BinaryNode findMin(BinaryNode t) {
        if (t == null) {
            return null;
        } else if (t.getLeft() == null) {
            return t;       //found the leftmost node
        } else {
            return findMin(t.getLeft());
        }
    }
     
    
    /**
     * Method to compute height of this tree
     * @return height : int
     */
    public int height() {
        if (root == null) {
            return -1;      //if root is null, tree height is -1
        } else {
            return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
        }
    }
    
    /**
     * Method to compute height of any subtree
     * @return height : int
     */
    public int height(BinaryNode node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        }
    }
    
    /**
     * Getter for root node
     * @return root
     */
    public BinaryNode getRoot() {
        return this.root;
    }
    
    /**
     * Setter for root node
     * @param node : node to set as root
     */
    public void setRoot(BinaryNode node) {
        this.root = node;
    }
    
}
