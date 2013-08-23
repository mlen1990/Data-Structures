/* BinarySearchTreeNode.java */

package tree;

/**
 *  A BinarySearchTreeNode is a node in a binary search tree. The item
 *  contained in each node cannot change.
 **/

public class BinarySearchTreeNode extends TreeNode {

  /**
   *  (inherited) item references the item stored in this node.
   *  (inherited) myTree references the Tree that contains this node.
   *  leftChild references the left child of this node.
   *  rightChild references the right child of this node.
   *  parent references the parent of this node.
   **/

  protected BinarySearchTreeNode leftChild;
  protected BinarySearchTreeNode rightChild;
  protected BinarySearchTreeNode parent;

  /**
   *  BinarySearchTreeNode() constructor.
   *
   *  @param item the item to store in this node.
   **/
  BinarySearchTreeNode(Object item, BinarySearchTree tree) {
    this.item = item;
    this.myTree = tree;
  }

  /**
   *  toString() returns a String representation of this
   *  BinarySearchTreeNode.
   *
   *  @return a String representation of this BinarySearchTreeNode.
   **/
  public String toString() {
    String ret = "[Parent: ";
    if (parent != null) {
      ret += parent.item;
    } else {
      ret += "null";
    }
    ret += ", Item: " + item;
    return ret + "]";
  }
}
