/* BianrySearchTree.java */

package tree;

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
    return false;
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
    return false;
  }
}
