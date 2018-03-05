/**
 * AVLTree.java
 * @author John Leonardo, W Reed
 * Class: CSC 130
 */

public class AVLTree extends BinarySearchTree {
    
    protected BinaryNode insert(int data, BinaryNode node) {
        //perform normal BST insertion
        if (node == null) {
            return new BinaryNode(data, null, null);
        }
        //find insertion point
        if (data < node.getData()) {
            node.setLeft(insert(data, node.getLeft()));
        } else if (data > node.getData()) {
            node.setRight(insert(data, node.getRight()));
        } else {
            return node; //no duplicate keys
        }
        
        //update height of the parent node
        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));
        
        //get balance factor of the parent node to check if that node became unbalanced
        int balance = balance(node);
        
        //LEFT-LEFT CASE
        if (balance > 1 && data < node.getLeft().getData()) {
            System.out.printf("\n\nRight Rotation\nOffending Node: (%d)\n", data);
            return rightRotate(node);
        }
        
        //RIGHT-RIGHT CASE
        if (balance < -1 && data > node.getRight().getData()) {
            System.out.printf("\n\nLeft Rotation\nOffending Node: (%d)\n", data);
            return leftRotate(node);
        }
        
        //LEFT-RIGHT CASE
        if (balance > 1 && data > node.getLeft().getData()) {
            System.out.printf("\n\nLeft-Right Rotation\nOffending Node: (%d)\n", data);
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
        
        //RIGHT-LEFT CASE
        if (balance < -1 && data < node.getRight().getData()) {
            System.out.printf("\n\nRight-Left Rotation\nOffending Node: (%d)\n", data);
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }
        
        //or, return the (unchanged) node
        return node;
    }
    
    protected BinaryNode remove(int data, BinaryNode node) {
        return node; //temp
    }
    
    private int balance(BinaryNode node){
        if (node == null) return 0;
        return height(node.getLeft()) - height(node.getRight());
    }
    
    //utility function to get height of the tree
    protected int height(BinaryNode n) {
        if (n == null)
            return 0;
        return n.height;
    }
    
    //utility function to get max of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    //utility function to right-rotate subtree
    BinaryNode rightRotate(BinaryNode y) {
        BinaryNode x = y.getLeft();
        BinaryNode t = x.getRight();
        
        //perform the rotation
        x.setRight(y);
        y.setLeft(t);
        
        //update heights
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        
        //return new root
        return x;
    }
    
    //utility function to left-rotate subtree
    BinaryNode leftRotate(BinaryNode x) {
        BinaryNode y = x.getRight();
        BinaryNode t = y.getLeft();
        
        //perform the rotation
        y.setLeft(x);
        x.setRight(t);
        
        //update heights
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        
        //return new root
        return y;
    }
}
