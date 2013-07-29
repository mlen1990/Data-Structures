/* IterativeFibonacci.java */

public class IterativeFibonacci {

  /*
   *  This function computes the nth fibonacci number iteratively.
   *  @param n the nth fibonacci number to be computed.
   *  @return an integer representing the nth fibonacci number.
   *  Running time: O(n)
   *  Space Complexity: O(1)
   */
  public static int fibonacci(int n) {
    if (n < 0) {
      System.out.println("Input must be positive.");
      return -1;
    } else if (n == 1) {
      return 1;
    }
    int f1 = 0;
    int f2 = 1;
    int fn = 0;
    for (int i = 2; i < n + 1; i++) {
      fn = f1 + f2;
      f1 = f2;
      f2 = fn;
    }
    return fn;
  }

  /*
   *  To compile this program using the command line, type
   *  "javac IterativeFibonacci.java"
   *  To run this program using the command line, type
   *  "java IterativeFibonacci <n>"
   *  On a successful run, the nth fibonacci number is outputted
   *  to stdout.
   */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java IterativeFibonacci <n>");
      return;
    }
    System.out.println(fibonacci(Integer.parseInt(args[0])));
  }
}
