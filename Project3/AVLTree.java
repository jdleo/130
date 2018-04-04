
public class AVLTree<E extends Comparable<? super E>> extends BinarySearchTree<E> {
    
    @Override
    public void incCount(E data) {
        super.incCount(data);
        overallRoot = balance(overallRoot);
    }
    
    /*Balance the tree by checking height
     *Only rebalance if the height difference is greater than 1
     *If subtree has uneven left/right heights, perform a rotation.
     */
    private BSTNode balance(BSTNode root) {
        if(root.left == null && root.right == null) {
            return root;
        }
        
        int heightDiff;
        do{
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
        
        return root;
    }
    
    /*
     *  This section refers to rotations that will occur
     *  when there is a need to rebalance the tree.
     */
    private BSTNode singleLeftRotation(BSTNode root) {
        BSTNode right = root.right;
        root.right = right.left;
        right.left = root;
        return right;
    }
    
    private BSTNode singleRightRotation(BSTNode root) {
        BSTNode left = root.left;
        root.left = left.right;
        left.right = root;
        return left;
    }
    
    private BSTNode doubleLeftRightRotation(BSTNode root) {
        root.left = singleLeftRotation(root.left);
        return singleRightRotation(root);
    }
    
    private BSTNode doubleRightLeftRotation(BSTNode root) {
        root.right = singleRightRotation(root.right);
        return singleLeftRotation(root);
    }
    
    private int height(BSTNode node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;
        
        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
