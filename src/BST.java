import java.beans.beancontext.BeanContextServiceAvailableEvent;
import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Jake Sonsini
 * @version: April 26
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    // This function calls the searchHelper method that completes the task
    public boolean search(int val) {
        return searchHelper(val, root);
    }
    public boolean searchHelper(int val, BSTNode cur){
        // Base case checks if the current node is invalid
        if (cur == null){
            return false;
        }
        // If the current node equals the value then return true
        if (cur.getVal() == val){
            return true;
        }
        // Makes recursive call that splits each root the left and right side
        if (cur.getVal() > val){
            return searchHelper(val, cur.getLeft());
        }
        else{
            return searchHelper(val, cur.getRight());
        }
    }
    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        //Inorder Traversal visits each node from Left → Root → Right
        // Create a new ArrayList and then call the inOrder function inputting the list
        ArrayList<BSTNode> inOrderlist = new ArrayList<>();
        inOrder(root, inOrderlist);
        return inOrderlist;
    }
    public void inOrder(BSTNode cur, ArrayList<BSTNode> total){
        // Check to see if the current Node is a leaf
        if (cur.getLeft() == null && cur.getRight() == null){
            total.add(cur);
            return;
        }
        // Call recursively following the inOrder order (left > root > right)
        if (cur.getLeft() != null){
            inOrder(cur.getLeft(), total);
        }
        total.add(cur);
        if (cur.getRight() != null){
            inOrder(cur.getRight(), total);
        }
    }
    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        //Preorder Traversal visits each node from Root → Left → Right
        // Create a new ArrayList and then call the preOrder function inputting the list
        ArrayList<BSTNode> preOrderlist = new ArrayList<>();
        preOrder(root, preOrderlist);
        return preOrderlist;

    }
    public void preOrder(BSTNode cur, ArrayList<BSTNode> total){
        // Check to see if the current Node is a leaf
        if (cur.getLeft() == null && cur.getRight() == null){
            total.add(cur);
            return;
        }
        // Call recursively following the preOrder order (root > left > right)
        total.add(cur);
        if (cur.getLeft() != null){
            preOrder(cur.getLeft(), total);
        }
        if (cur.getRight() != null){
            preOrder(cur.getRight(), total);
        }
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        //Postorder Traversal visits each node from Left → Right → Root
        // Create a new ArrayList and then call the postOrder function inputting the list
        ArrayList<BSTNode> postOrderlist = new ArrayList<>();
        postOrder(root, postOrderlist);
        return postOrderlist;
    }
    public void postOrder(BSTNode cur, ArrayList<BSTNode> total){
        // Check to see if the current Node is a leaf
        if (cur.getLeft() == null && cur.getRight() == null){
            total.add(cur);
            return;
        }
        // Call recursively following the postOrder order (left > right > root)
        if (cur.getLeft() != null){
            postOrder(cur.getLeft(), total);
        }
        if (cur.getRight() != null){
            postOrder(cur.getRight(), total);
        }
        total.add(cur);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // check if it is already there
        if (search(val)){
            return;
        }
        // Create the insert node
        BSTNode set = new BSTNode(val);
        // Call the helper recursive method
        insertHelper(root, set);
    }
    public void insertHelper(BSTNode cur, BSTNode set){
        // First check if the set node is going on the left or right side
        // Then at the same time check if it is null, if so it is empty so add the set node
        if (cur.getVal() > set.getVal() && cur.getLeft() == null){
            cur.setLeft(set);
            return;
        }
        else if (cur.getVal() < set.getVal() && cur.getRight() == null){
            cur.setRight(set);
            return;
        }
        // Since base case isn't true, check whether to traverse left or right
        // This is done by comparing the cur and set values
        if (cur.getVal() > set.getVal()){
            insertHelper(cur.getLeft(), set);
        }
        else{
            insertHelper(cur.getRight(), set);
        }
    }
    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
