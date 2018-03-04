public class AVLTree<Integer extends Comparable<Integer>> extends BinarySearchTree<Integer> {

    protected BinaryNode<Integer> put(int x, BinaryNode<Integer> node) {
        return balance(super.put(x, node));
    }
    
    protected BinaryNode<Integer> put(int x, BinaryNode<Integer> node) {
        return balance(super.delete(x, node));
    }
    
    private BinaryNode<Integer> balance(BinaryNode<Integer> node) {
        
    }
    
}
