/**
 * Name: John Leonardo, W Reed
 * Course: CSC 130
 * File: AVLTree.java
 * Description: This file is a AVLTree implementation of DataCounter.
 */
public class AVLTree<E extends Comparable<? super E>> extends BinarySearchTree<E> {
    
    /**
     * Same incCount method from BST, except we rebalance after insert
     * @param data : the data to increase the count of (or insert)
     */
    @Override
    public void incCount(E data) {
        super.incCount(data);
        overallRoot = balance(overallRoot);
    }
    
    /**
     * Method to balance tree
     * @param root : the parent node to rebalance from
     * @return returns the parent node, but rebalanced now
     */
    private BSTNode balance(BSTNode root) {
        
        //only one node in this tree, return it
        if(root.left == null && root.right == null) {
            return root;
        }
        
        //variable to keep track of the height difference
        int heightDiff;
        
        //keep trying, til the tree fully balanced
        do{
            //difference between the heights of left and right subtrees
            heightDiff = height(root.left) - height(root.right);
            
            if(heightDiff > 1){
                if(height(root.left.left) >= height(root.left.right)) {
                    root = singleRightRotation(root);
                }else{
                    root = doubleLeftRightRotation(root);
                }
            }else if(heightDiff < 1){
                if(height(root.right.right) >= height(root.right.left)) {
                    root = singleLeftRotation(root);
                }else{
                    root = doubleRightLeftRotation(root);
                }
            }
        }while(heightDiff > 1 && heightDiff < -1 && root != null);
        
        //return the new, balanced root node
        return root;
    }
    
    //SINGLE-LEFT ROTATION CASE
    private BSTNode singleLeftRotation(BSTNode root) {
        BSTNode right = root.right;
        root.right = right.left;
        right.left = root;
        return right;
    }
    
    //SINGLE-RIGHT ROTATION CASE
    private BSTNode singleRightRotation(BSTNode root) {
        BSTNode left = root.left;
        root.left = left.right;
        left.right = root;
        return left;
    }
    
    //LEFT-RIGHT ROTATION CASE
    private BSTNode doubleLeftRightRotation(BSTNode root) {
        root.left = singleLeftRotation(root.left);
        return singleRightRotation(root);
    }
    
    //RIGHT-LEFT ROTATION CASE
    private BSTNode doubleRightLeftRotation(BSTNode root) {
        root.right = singleRightRotation(root.right);
        return singleLeftRotation(root);
    }
    
    private int height(BSTNode node)
    {
        //tree is empty, so height is 0
        if (node == null)
            return 0;
        
        //tree isn't empty
        //the height is the maximum value between the heights
        //of the left and right subtrees, + 1
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
