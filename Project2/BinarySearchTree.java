/**
 * BinarySearchTree.java
 * @author John Leonardo, W Reed
 * Class: CSC 130
 */

public class BinarySearchTree<Integer> {
    private BinaryNode<Integer> root;       //root of BST
    
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
        return maxDepth(root);
    }
    
    /**
     * Method for computing the max depth of a BST
     * @param node : the node to compute the depth from
     * @return the max depth
     */
    int maxDepth(BinaryNode<Integer> node) {
        if (node == null) {
            return (-1); // an empty tree  has height −1
        } else {
            // compute the depth of each subtree
            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);
            // use the larger one
            if (leftDepth > rightDepth )
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }
    
    /**
     * Method for inserting data into this BST
     * @param x : data to insert
     */
    public void put(int x) {
        this.root = new BinaryNode<Integer>(x, null, null);
    }
    
    /**
     * Method for inserting data into this BST
     * @param x : data to insert
     * @param node : last visited node
     */
    public BinaryNode<Integer> put(int x, BinaryNode<Integer> node) {
        if (node == null) {
            return new BinaryNode<Integer>(x, null, null);
        }
        
        int compareResult = (x - node.element);
        
        if (compareResult < 0) {
            node.left = put(x, node.left);
        } else if (compareResult > 0) {
            node.right = put(x, node.right);
        } else {
            //duplicate : do nothing
        }
        
        return node;
    }
    
    /**
     * Method for deleting a node in a BST
     * @param toDelete : the key to delete
     */
    public void delete(int toDelete) {
        this.root = delete(root, toDelete);
    }
    
    /**
     * Method for deleting a node in a BST
     * @param p : the parent node
     * @param toDelete : the key to delete
     * @exception NullPointerException
     */
    public BinaryNode<Integer> delete(BinaryNode<Integer> p, int toDelete) throws NullPointerException {
        
        int compareResult = (toDelete - p.element);
        
        if (p == null) {
            throw new NullPointerException();
        } else if (compareResult < 0) {
            p.left = delete(p.left, toDelete);
        } else if (compareResult > 0) {
            p.right = delete(p.right, toDelete);
        } else {
            if (p.left == null) {
                return p.right;
            } else if (p.right == null) {
                return p.left;
            } else {
                //get data from rightmost node in left subtree
                p.element = retrieve(p.left);
                //delete rightmost node in left subtree
                p.left = delete(p.left, p.element);
            }
        }
        return p;
    }
    
    /**
     * Method for retrieving data of a node
     * @param p : the node to retrieve the data of
     * @return int : the integer data to retrieve
     */
    private int retrieve(BinaryNode<Integer> p) {
        while (p.right != null) p = p.right;
        return p.element;
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
