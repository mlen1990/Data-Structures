/* RecursiveFibonacci.java */

public class RecursiveFibonacci {

  /*
   *  To call this method in another method use
   *  "RecursiveFibonacci.fibonacci(n)"
   *  This function computes the nth Fibonacci number recursively.
   *  @param n the nth fibonacci number to be computed.
   *  @return an integer representing the nth fibonacci number.
   */
  public static int fibonacci(int n) {
    if (n < 0) {
      System.err.println("The input must be positive.");
      return -1;
    } else if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  /*
   *  To compile this program using the command line, type
   *  "javac RecursiveFibonacci.java"
   *  To run this program using the command line, type
   *  "java RecursiveFibonacci <n>"
   *  On a successful run, the nth fibonacci number is outputted
   *  to stdout.
   */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java RecursiveFibonacci <n>");
      return;
    }
    System.out.println(fibonacci(Integer.parseInt(args[0])));
  }
}
