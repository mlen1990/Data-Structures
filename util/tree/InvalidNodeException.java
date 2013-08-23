/* InvalidNodeException.java */

package tree;

/**
 *  Implements an Exception that signals an attempt to use an invalid
 *  TreeNode.
 **/

public class InvalidNodeException extends Exception {

  protected InvalidNodeException() {
    super();
  }

  protected InvalidNodeException(String s) {
    super(s);
  }
}
