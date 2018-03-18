// Binary Search Tree
// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Date Modified: 04/27/2016
// BinarySearchTree.java
/* This class contains an implementation of a Binary Search Tree data structure
 * with a inner LinkNode class, which store a single integer as a key within each
 * LinkNode of the tree.   	                                                    */
// Status: working/tested


public class BinarySearchTree {

    protected LinkNode root;

    public BinarySearchTree() { root = null; }  // constructor

    public boolean isEmpty() { return root == null; }

    public boolean search(int key) { return search(root, key) != null; }
    // returns whether the given key is in the tree

    private LinkNode search(LinkNode target, int key) {
        // returns the LinkNode with the given key
        if(target == null) return null;
        else if(target.key == key)
            return target;
        if(target.key > key)
            return search(target.left, key);
        else
            return search(target.right, key);
    }


    public void insert(int key) {
        // adds a new LinkNode with the given key to the tree
        LinkNode newNode = new LinkNode();
        newNode.key = key;
        LinkNode parent = null;
        LinkNode temp = root;
        while(temp != null) {
            parent = temp;
            if(newNode.key < temp.key)
                temp = temp.left;
            else
                temp = temp.right;
        }
        newNode.parent = parent;
        if(parent == null) {
            root = newNode;
            return;
        }
        if(newNode.key < parent.key)
            parent.left = newNode;
        else
            parent.right = newNode;
    }


    public void delete(int key) { delete(search(root, key)); }   // public wrapper for delete()

    private void delete(LinkNode node) {  // deletes the given node from the tree
        LinkNode target;
        LinkNode temp;
        if(node == null) return;
        if(node.left == null || node.right == null)
            target = node;
        else
            target = successor(node);

        if(target.left != null)
            temp = target.left;
        else
            temp = target.right;
        if(temp != null)
            temp.parent = target.parent;
        if(target.parent == null)
            root = temp;
        else {
            if(target == target.parent.left)
                target.parent.left = temp;
            else
                target.parent.right = temp;
        }
        if(target != node)
            node.key = target.key;
    }


    public int min() { return min(root).key; }   // public wrapper for min()

    public int max() { return max(root).key; }   // public wrapper for max()

    private LinkNode min(LinkNode target) {
        // returns the LinkNode with the smallest key value
        if(target == null) return null;
        while(target.left != null)
            target = target.left;
        return target;
    }

    private LinkNode max(LinkNode target) {
        // returns the LinkNode with the largest key value
        if(target == null) return null;
        while(target.right != null)
            target = target.right;
        return target;
    }


    public int successor(int key) {   // public wrapper for successor()
        LinkNode successor = successor(search(root, key));
        if(successor != null)
            return successor.key;
        return key;     // returns original key if no successor found
    }

    public int predecessor(int key) {  // public wrapper for predecessor()
        LinkNode predecessor = predecessor(search(root, key));
        if(predecessor != null)
            return predecessor.key;
        return key;     // returns initial key if no predecessor found
    }

    private LinkNode successor(LinkNode target) {
        // returns the LinkNode with the next largest key value
        if(target == null || target == max(root)) return null;
        if(target.right != null)
            return min(target.right);
        LinkNode parent = target.parent;
        while(parent != null && target == parent.right) {
            target = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private LinkNode predecessor(LinkNode target) {
        // returns the LinkNode with the next smallest key value
        if(target == null || target == min(root)) return null;
        if(target.left != null)
            return max(target.left);
        LinkNode parent = target.parent;
        while(parent != null && target == parent.left) {
            target = parent;
            parent = parent.parent;
        }
        return parent;
    }


    public void inOrder() {  // prints in-order traversal of tree values
        if(isEmpty()) return;
        inOrderHelper(root);
        System.out.println();
    }

    private void inOrderHelper(LinkNode target) {  // helper function of inOrder()
        if(target == null) return;
        inOrderHelper(target.left);
        System.out.print(target.key + " ");
        inOrderHelper(target.right);
    }


    public void preOrder() {  // prints pre-order traversal of tree values
        if(isEmpty()) return;
        preOrderHelper(root);
        System.out.println();
    }

    private void preOrderHelper(LinkNode target) {  // helper function of preOrder()
        if(target == null) return;
        System.out.print(target.key + " ");
        preOrderHelper(target.left);
        preOrderHelper(target.right);
    }


    public void postOrder() {   // prints post-order traversal of tree values
        if(isEmpty()) return;
        postOrderHelper(root);
        System.out.println();
    }

    private void postOrderHelper(LinkNode target) {  // helper function of postOrder()
        if(target == null) return;
        postOrderHelper(target.left);
        postOrderHelper(target.right);
        System.out.print(target.key + " ");
    }


    protected class LinkNode {

        protected LinkNode parent;
        protected LinkNode left;
        protected LinkNode right;
        protected int key;

        public LinkNode() { parent = left = right = null; }   // LinkNode constructor

    }

}
