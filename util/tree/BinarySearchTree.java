/* BianrySearchTree.java */

package tree;

import java.util.LinkedList;
import java.io.StringWriter;

/**
 *  A BinarySearchTree is a binary search tree, where each node has a
 *  left and right child. This ADT does not allow duplicate items.
 **/

public class BinarySearchTree extends Tree {

  /**
   *  (inherited) size is the number of items in the tree.
   *  root references the root of this tree.
   */

  protected BinarySearchTreeNode root;

  /**
   *  BinarySearchTree() constructs an empty tree.
   **/
  public BinarySearchTree() {
    this.size = 0;
  }

  /**
   *  insert() inserts an item into this tree at the appropriate
   *  location.
   *
   *  @param item is the item to be inserted.
   *
   *  @return true if the item is inserted successfully, false
   *  otherwise.
   **/
  public boolean insert(Object item) {
    if (root == null) {
      root = new BinarySearchTreeNode(item, this);
      size++;
      return true;
    } else {
      BinarySearchTreeNode node = root;
      while (true) {
        try {
          if (((Comparable) item).compareTo((Comparable) node.item()) < 0) {
            if (node.leftChild == null) {
              node.leftChild = new BinarySearchTreeNode(item, this);
              size++;
              return true;
            } else {
              node = node.leftChild;
            }
          } else if (((Comparable) item).compareTo((Comparable) node.item()) == 0) {
            return false;
          } else {
            if (node.rightChild == null) {
              node.rightChild = new BinarySearchTreeNode(item, this);
              size++;
              return true;
            } else {
              node = node.rightChild;
            }
          }
        } catch (InvalidNodeException e) {
          return false;
        }
      }
    }
  }

  /**
   *  remove() removes an item from this tree.
   *
   *  @param item is the item to be removed.
   *
   *  @return true if the item is succesfully removed, false otherwise.
   **/
  public boolean remove(Object item) {
    return false;
  }

  /**
   *  contains() check if an item is in this tree.
   *
   *  @param item is the item to be checked.
   *
   *  @return true if the item is in this tree, false otherwise.
   **/
  public boolean contains(Object item) {
    if (root == null) {
      return false;
    } else {
      BinarySearchTreeNode node = root;
      while (true) {
        try {
          if (((Comparable) item).compareTo((Comparable) node.item()) < 0) {
            if (node.leftChild == null) {
              return false;
            } else {
              node = node.leftChild;
            }
          } else if (((Comparable) item).compareTo((Comparable) node.item()) == 0) {
            return true;
          } else {
            if (node.rightChild == null) {
              return false;
            } else {
              node = node.rightChild;
            }
          }
        } catch (InvalidNodeException e) {
          return false;
        }
      }
    }
  }

  /**
   *  inOrder() iteratively perform an inorder traversal of this tree.
   *
   *  @return a string representing an inorder traversal of this tree.
   *
   *  Performance: O(n)
   **/
  public String inOrder() {
    LinkedList<BinarySearchTreeNode> nodes = new LinkedList<BinarySearchTreeNode>();
    BinarySearchTreeNode node = root;
    StringWriter inorder = new StringWriter();
    inorder.append('[');
    while (!nodes.isEmpty() || node != null) {
      if (node != null) {
        nodes.add(node);
        node = node.leftChild;
      } else {
        node = nodes.removeLast();
        try {
          inorder.append(node.item().toString());
        } catch (InvalidNodeException e) {
          return null;
        }
        node = node.rightChild;
        if (!nodes.isEmpty() || node != null) {
          inorder.append(',');
        }
      }
    }
    return inorder.append(']').toString();
  }
}
