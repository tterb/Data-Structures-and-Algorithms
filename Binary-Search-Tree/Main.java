// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Date Modified: 04/27/2016
// Main.java
/* This class contains the main method of the program, which is responsible
 * for both the I/O of the program, while calling the corresponding methods
 * of the BinarySearchTree.                                                 */
// Status: working/tested


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String command = scan.next().toLowerCase();  // ignores case
            if (command.contains("#")) {  // line is comment
                scan.nextLine();
            } else if(scan.hasNextInt()) {
                int key = scan.nextInt();
                if (command.equals("search")) {                   // search
                    if (bst.search(key))
                        System.out.println(key + " found.");
                    else
                        System.out.println(key + " not found.");
                } else if (command.equals("insert")) {            // insert
                    bst.insert(key);
                    System.out.println("inserted " + key + ".");
                } else if (command.equals("delete")) {            // delete
                    if (bst.search(key)) {
                        bst.delete(key);
                        System.out.println("deleted " + key + ".");
                    } else
                        System.out.println("delete " + key + " - not found.");
                } else if (command.equals("successor")) {         // successor
                    if (!bst.search(key))
                        System.out.println(key + " not in tree.");
                    else if(bst.successor(key) == key)
                        System.out.println("no successor for " + key + ".");
                    else
                        System.out.println(key + " successor is " + bst.successor(key) + ".");
                } else if (command.equals("predecessor")) {       // predecessor
                    if (!bst.search(key))
                        System.out.println(key + " not in tree.");
                    else if(bst.predecessor(key) == key)
                        System.out.println("no predecessor for " + key + ".");
                    else
                        System.out.println(key + " predecessor is " + bst.predecessor(key) + ".");
                }
            } else {
                if (command.equals("max")) {                       // max
                    if (!bst.isEmpty())
                        System.out.println("max is " + bst.max() + ".");
                    else
                        System.out.println("tree empty");
                } else if (command.equals("min")) {                // min
                    if (!bst.isEmpty())
                        System.out.println("min is " + bst.min() + ".");
                    else
                        System.out.println("tree empty");

                } else if (command.equals("inorder")) {           // in-order
                    System.out.println("inorder traversal:");
                    bst.inOrder();
                } else if (command.equals("preorder")) {          // pre-order
                    System.out.println("preorder traversal:");
                    bst.preOrder();
                } else if (command.equals("postorder")) {         // post-order
                    System.out.println("postorder traversal:");
                    bst.postOrder();
                }
            }
        }
    }

}
