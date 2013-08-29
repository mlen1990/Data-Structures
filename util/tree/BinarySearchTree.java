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
  private static int preIndex;

  /**
   *  BinarySearchTree() constructs an empty tree.
   **/
  public BinarySearchTree() {
    this.size = 0;
  }

  /**
   *  BinarySearchTree() constructs a binary search tree from its inorder
   *  and preorder traversals.
   */
  public BinarySearchTree(Object[] inOrder, Object[] preOrder) {
    root = buildTree(inOrder, preOrder, 0, inOrder.length - 1);
  }

  /**
   *  find() is a helper method that finds the index of an Object in an
   *  inorder traversal of a binary search tree.
   *
   *  @param inOrder the inOrder traversal of a binary search tree.
   *  @param item the object to be located.
   *
   *  @return the index of the Object in the inOrder array, return -1 if
   *  the item is not found.
   **/
  private static int find(Object[] inOrder, Object item) {
    for (int i = 0; i < inOrder.length; i++) {
      if (inOrder[i].equals(item)) {
        return i;
      }
    }
    return -1;
  }

  /**
   *  buildTree() a helper method that recursively constructs a binary
   *  search tree from its preorder and inorder traversals.
   *
   *  @param inOrder the inorder traversal of this tree.
   *  @param preOrder the preorder traversal of this tree.
   *  @param start the start index
   *  @param end the end index, which must initially be the length of the
   *  inorder array minus 1.
   **/
  private BinarySearchTreeNode buildTree(Object[] inOrder, Object[] preOrder, int start, int end) {
    if (start > end) {
      return null;
    }
    // Make sure both traversals have the same number of nodes.
    if (inOrder.length != preOrder.length) {
      return null;
    }
    // There is no point in continuing if there are no Objects.
    if (inOrder.length == 0) {
      return null;
    } else if (inOrder.length == 1) {
      return new BinarySearchTreeNode(inOrder[0], this);
    } else {
      BinarySearchTreeNode node = new BinarySearchTreeNode(preOrder[size], this);
      size++;
      if (start == end) {
        return node;
      }
      int i = find(inOrder, preOrder[size - 1]); // find the index of the root in the inOrder array
      node.leftChild = buildTree(inOrder, preOrder, start, i - 1);
      node.rightChild = buildTree(inOrder, preOrder, i + 1, end);
      return node;
    }
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
              node.leftChild.parent = node;
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
              node.rightChild.parent = node;
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

  /**
   *  preOrder() iteratively perform a preorder traversal of this tree.
   *
   *  @return a string representing an preorder traversal of this tree.
   *
   *  Performance: O(n)
   **/
  public String preOrder() {
    LinkedList<BinarySearchTreeNode> nodes = new LinkedList<BinarySearchTreeNode>();
    BinarySearchTreeNode node = root;
    StringWriter preorder = new StringWriter();
    preorder.append('[');
    while (!nodes.isEmpty() || node != null) {
      if (node != null) {
        try {
          preorder.append(node.item().toString());
        } catch (InvalidNodeException e) {
          return null;
        }
        if (node.rightChild != null) {
          nodes.add(node.rightChild);
        }
        node = node.leftChild;
        if (!nodes.isEmpty() || node != null) {
          preorder.append(',');
        }
      } else {
        node = nodes.removeLast();
      }
    }
    return preorder.append(']').toString();
  }

  /**
   *  toString() performs an iterative inorder traversal of this tree and
   *  returns a String represenation of this BinarySearchTree.
   *
   *  @return a String representation of this BinarySearchTree.
   **/
  public String toString() {
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
        inorder.append(node.toString());
        node = node.rightChild;
        if (!nodes.isEmpty() || node != null) {
          inorder.append(',');
        }
      }
    }
    return inorder.append(']').toString();
  }

}
