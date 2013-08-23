/* Tree.java */

package tree;

/**
 *  A Tree is a mutable tree ADT. This class is only meant to be a
 *  template for all sorts of trees.
 **/

public abstract class Tree {

  /**
   *  size is the number of items in the tree.
   **/

  protected int size;

  /**
   *  isEmpty() returns true if this Tree contains no items, false
   *  otherwise.
   *
   *  @return true if this Tree is empty, false otherwise.
   *
   *  Performance: runs in O(1) time.
   **/
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   *  size() returns the size of this Tree.
   *
   *  @return the number of items in this Tree.
   *
   *  Performance: runs in O(1) time.
   **/
  public int size() {
    return size;
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
  public abstract boolean insert(Object item);

  /**
   *  remove() removes an item from this tree.
   *
   *  @param item is the item to be removed.
   *
   *  @return true if the item is successfully removed, false otherwise.
   **/
  public abstract boolean remove(Object item);

  /**
   *  contains() check if an item is in this tree.
   *
   *  @param item is the item to be checked.
   *
   *  @return true if the item is in this tree, false otherwise.
   **/
  public abstract boolean contains(Object item);
}
