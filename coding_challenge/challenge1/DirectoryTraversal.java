/* DirectoryTraversal.java */

import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.PrintWriter;

public class DirectoryTraversal {

  private int numThreads;
  private int defaultNumThreads = 5;

  private MySQLDatabase mysql;
  private HashMap<String, Integer> counts;
  private Thread[] threadpool;
  private ArrayList<File> files;
  private Runnable run;
  private int exited = 0;

  /**
   *  DirectoryTraversal() constructor.
   *  @param filepath the file to be traversed.
   *  @param numThreads the number of threads to be used.
   **/
  public DirectoryTraversal(String filepath, String numThreads) {
    counts = new HashMap<String, Integer>();
    mysql = new MySQLDatabase();
    mysql.connectToDatabase();
    mysql.setup();
    this.numThreads = Integer.parseInt(numThreads);
    if (this.numThreads <= 0) {
      System.out.println("Error: Invalid Number of Threads");
      System.out.println("Using 5 Threads Instead");
      this.numThreads = defaultNumThreads;
    }
    threadpool = new Thread[this.numThreads];
    files = new ArrayList<File>();
    files.add(new File(filepath));
    run = new Runnable() {
      public void run() {
        try {
          System.out.println("Thread " + Thread.currentThread().getId() + " Started and running");
          while (files.size() != 0) {
            File file = null;
            synchronized(files) {
              if (files.size() == 0) {
                break;
              } else {
                file = files.remove(0);
              }
            }
            if (file.isDirectory()) {
              String[] filenames = file.list();
              for (String filename : filenames) {
                files.add(new File(file, filename));
              }
            } else if (file.isFile()) {
              String[] path = file.toString().split("/");
              String key = path[path.length - 1];
              String sql = "INSERT INTO FILES values(now(), \"" + key + "\", \"" + path[1] + "\", " + Thread.currentThread().getId() + ")";
              mysql.addEntry(sql);
              synchronized(counts) {
                if (counts.containsKey(key)) {
                  int count = counts.get(key);
                  count++;
                  counts.put(key, count);
                } else {
                  counts.put(key, 1);
                }
              }
            }
          }
        } catch (Exception e) {
        } finally {
          exited++;
          System.out.println("Thread " + Thread.currentThread().getId() + " Finished");
        }
      }
    };
  }

  /**
   *  closeConnection() close the connection to the mysql database.
   **/
  public void closeConnection() {
    mysql.closeConnection();
  }

  /**
   *  printCounts() print to stdout the counts of all files in the format:
   *  filename - count.
   **/
  public void printCounts() {
    Object[] count = counts.keySet().toArray();
    for (Object c : count) {
      System.out.println(c + " - " + counts.get(c));
    }
  }

  /**
   *  writeCounts() write to a file output.txt the counts of all the files
   *  in the format: filename - count.
   **/
  public void writeCounts() {
    Object[] count = counts.keySet().toArray();
    try {
      PrintWriter output = new PrintWriter("counts.txt", "UTF-8");
      for (Object c : count) {
        output.println(c + " - " + counts.get(c));
      }
      output.flush();
      output.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   *  traverse() using multiple threads, traverse the directory structure and
   *  print the counts to stdout and write them to a file output.txt.
   **/
  public void traverse() {
    for (int i = 0; i < numThreads; i++) {
      threadpool[i] = new Thread(run);
      System.out.println("Starting Thread " + threadpool[i].getId());
      threadpool[i].start();
    }
    while (exited != numThreads) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }
    printCounts();
    writeCounts();
  }

  /**
   *  java DirectoryTraversal <path> <numThreads> <executionTime>
   **/
  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Usage: java DirectoryTraversal <path> <numThreads> <executionTime>");
      return;
    }
    System.out.println("Begin Traversing Directory: " + args[0] + " using " + args[1] + " threads");
    DirectoryTraversal d = new DirectoryTraversal(args[0], args[1]);
    d.traverse();
    d.closeConnection();
    System.out.println("Finished Traversing Directory: " + args[0]);
  }
}
