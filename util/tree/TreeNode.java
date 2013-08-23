/* TreeNode.java */

package tree;

/**
 *  A TreeNode is a node in a tree. Once tree nodes are created, the item
 *  contained in the node cannot change.
 **/
public abstract class TreeNode {

  /**
   *  item references the item stored in this node.
   *  myTree references the Tree that contains this node.
   */

  protected Object item;
  protected Tree myTree;

  /**
   *  isValidNode returns true if this node is valid; false otherwise.
   *  By default, an invalid node is one that doesn't belong to a tree
   *  (myTree is null), but subclasses can override this definition.
   *
   *  @return true if this node is valid; false otherwise.
   *
   *  Performance: runs in O(1) time.
   **/
  public boolean isValidNode() {
    return myTree != null;
  }

  /**
   *  item() return this node's item. If this node is invalid, throws
   *  an exception.
   *
   *  @return the item stored in this node.
   *
   *  Performance: runs in O(1) time.
   **/
  public Object item() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException();
    }
    return item;
  }

  /**
   *  toString() returns a String representation of this TreeNode.
   *
   *  @return a String representation of this TreeNode.
   */
  public abstract String toString();

}
