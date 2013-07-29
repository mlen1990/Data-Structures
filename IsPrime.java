/* IsPrime.java */

public class IsPrime {

  /*
   *  To call this method in another method use "IsPrime.isPrime(n)"
   *  Given an integer, this method determines if the integer is prime.
   *  @param n an integer
   *  @return true if n is prime and false is not prime.
   */
  public static boolean isPrime(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /*
   *  To compile this program using the command line, type
   *  "javac IsPrime.java"
   *  To run this program using the command line, type
   *  "java IsPrime <n>
   *  On a successful run, a boolean will be outputted to stdout.
   */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("Usage: java IsPrime <n>");
      return;
    }
    System.out.println(isPrime(Integer.parseInt(args[0])));
  }
}
