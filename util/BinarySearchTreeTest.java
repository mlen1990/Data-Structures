/* BinarySearchTreeTest.java */

import tree.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

  @Test
  public static void test1() {
    System.out.print("Test 1 - ");
    BinarySearchTree tree = new BinarySearchTree();
    assertTrue(tree.size() == 0);
    assertTrue("[]".equals(tree.inOrder()));
    assertTrue(tree.insert(new Integer(20)));
    assertTrue(tree.size() == 1);
    assertTrue("[20]".equals(tree.inOrder()));
    assertTrue(!tree.insert(new Integer(20)));
    assertTrue(tree.size() == 1);
    assertTrue(tree.insert(new Integer(10)));
    assertTrue(tree.size() == 2);
    assertTrue("[10,20]".equals(tree.inOrder()));
    assertTrue(tree.insert(new Integer(30)));
    assertTrue(tree.size() == 3);
    assertTrue("[10,20,30]".equals(tree.inOrder()));
    assertTrue(tree.insert(new Integer(15)));
    assertTrue(tree.size() == 4);
    assertTrue("[10,15,20,30]".equals(tree.inOrder()));
    assertTrue(tree.insert(new Integer(22)));
    assertTrue(tree.size() == 5);
    assertTrue("[10,15,20,22,30]".equals(tree.inOrder()));
    assertTrue(tree.insert(new Integer(32)));
    assertTrue(tree.size() == 6);
    assertTrue("[10,15,20,22,30,32]".equals(tree.inOrder()));
    assertTrue(tree.insert(new Integer(12)));
    assertTrue(tree.size() == 7);
    assertTrue("[10,12,15,20,22,30,32]".equals(tree.inOrder()));
    assertTrue(tree.insert(new Integer(6)));
    assertTrue(tree.size() == 8);
    assertTrue("[6,10,12,15,20,22,30,32]".equals(tree.inOrder()));
    assertTrue(!tree.insert(new Integer(12)));
    assertTrue(tree.size() == 8);
    System.out.println("PASSED!");
  }

  @Test
  public static void test2() {
    System.out.print("Test 2 - ");
    BinarySearchTree tree = new BinarySearchTree();
    assertTrue(!tree.contains(new Integer(50)));
    assertTrue(tree.insert(new Integer(50)));
    assertTrue(tree.contains(new Integer(50)));
    assertTrue(!tree.contains(new Integer(60)));
    assertTrue(tree.insert(new Integer(60)));
    assertTrue(tree.contains(new Integer(60)));
    assertTrue(!tree.contains(new Integer(10)));
    assertTrue(tree.insert(new Integer(10)));
    assertTrue(tree.contains(new Integer(10)));
    assertTrue(!tree.contains(new Integer(25)));
    assertTrue(tree.insert(new Integer(25)));
    assertTrue(tree.contains(new Integer(25)));
    assertTrue(!tree.contains(new Integer(0)));
    assertTrue(tree.insert(new Integer(0)));
    assertTrue(tree.contains(new Integer(0)));
    assertTrue(!tree.contains(new Integer(75)));
    assertTrue(tree.insert(new Integer(75)));
    assertTrue(tree.contains(new Integer(75)));
    assertTrue(!tree.contains(new Integer(12)));
    assertTrue(tree.insert(new Integer(12)));
    assertTrue(tree.contains(new Integer(12)));
    assertTrue(!tree.contains(new Integer(33)));
    assertTrue(tree.insert(new Integer(33)));
    assertTrue(tree.contains(new Integer(33)));
    assertTrue(!tree.contains(new Integer(88)));
    assertTrue(tree.insert(new Integer(88)));
    assertTrue(tree.contains(new Integer(88)));
    assertTrue("[0,10,12,25,33,50,60,75,88]".equals(tree.inOrder()));
    System.out.println("PASSED!");
  }

  @Test
  public static void test3() {
    System.out.print("Test 3 - ");
    BinarySearchTree tree = new BinarySearchTree();
    assertTrue(tree.size() == 0);
    assertTrue("[]".equals(tree.toString()));
    assertTrue(tree.insert(new Integer(50)));
    assertTrue(tree.size() == 1);
    assertTrue("[[Parent: null, Item: 50]]".equals(tree.toString()));
    assertTrue(tree.insert(new Integer(60)));
    assertTrue(tree.size() == 2);
    assertTrue("[[Parent: null, Item: 50],[Parent: 50, Item: 60]]".equals(tree.toString()));
    assertTrue(tree.insert(new Integer(70)));
    assertTrue(tree.size() == 3);
    assertTrue("[[Parent: null, Item: 50],[Parent: 50, Item: 60],[Parent: 60, Item: 70]]".equals(tree.toString()));
    assertTrue(tree.insert(new Integer(40)));
    assertTrue(tree.size() == 4);
    assertTrue("[[Parent: 50, Item: 40],[Parent: null, Item: 50],[Parent: 50, Item: 60],[Parent: 60, Item: 70]]".equals(tree.toString()));
    assertTrue(tree.insert(new Integer(45)));
    assertTrue(tree.size() == 5);
    assertTrue(tree.insert(new Integer(55)));
    assertTrue(tree.size() == 6);
    assertTrue("[[Parent: 50, Item: 40],[Parent: 40, Item: 45],[Parent: null, Item: 50],[Parent: 60, Item: 55],[Parent: 50, Item: 60],[Parent: 60, Item: 70]]".equals(tree.toString()));
    System.out.println("PASSED!");
  }

  public static void main(String[] args) {
    System.out.println("Begin BinarySearchTree Testing:");
    test1();
    test2();
    test3();
    System.out.println("All Tests Passed!!");
  }
}
