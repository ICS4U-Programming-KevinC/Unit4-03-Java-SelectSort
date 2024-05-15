import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Does selection sort stuff yay!!!
 *
 * @author Kevin Csiffary
 * @version 1.0
 * @since 2024-05-14
 */

// SelectSort class
public final class SelectSort {

  /** Private constructor to prevent instantiation. */
  private SelectSort() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  /**
   * This is the main method.
   *
   * @param args Unused
   */
  public static void main(final String[] args) {
    try {
      // Setup scanner on file.
      File file = new File("input.txt");
      Scanner sc = new Scanner(file);
      // Setup writer for output file.
      FileWriter writer = new FileWriter("output.txt");
      BufferedWriter bufferedWriter = new BufferedWriter(writer);

      while (sc.hasNextLine()) {
        // Read the line from file.
        String line = sc.nextLine();

        // Check if line is valid input.
        try {
          int[] arrLine = strToIntArr(line);
          // Call method.
          int[] sortArr = selectSort(arrLine);
          // Write to file with a new line.
          for (int i = 0; i < sortArr.length; i++) {
            bufferedWriter.write(arrLine[i] + " ");
          }
        } catch (Exception e) {
          bufferedWriter.write("Please input a number!");
        }
        bufferedWriter.newLine();
      }

      // Close all writers and scanner.
      bufferedWriter.close();
      writer.close();
      sc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * For casting to int array.
   *
   * @param str
   * @return Integer array.
   */
  public static int[] strToIntArr(final String str) {
    String[] splitArray = str.split(" ");
    int[] array = new int[splitArray.length];

    for (int i = 0; i < splitArray.length; i++) {
      array[i] = Integer.parseInt(splitArray[i]);
    }
    return array;
  }

  /**
   * Does the selection sort stuff.
   *
   * @param arr
   * @return Returns a sorted int array.
   */
  public static int[] selectSort(final int[] arr) {
    // Loop though every element in the list.
    for (int i = 0; i < arr.length; i++) {
      // Set min for the j pass to i.
      int min = i;
      // Loop through the remaining elements in the list.
      for (int j = i + 1; j < arr.length; j++) {
        // Check for a new min then set it.
        if (arr[min] > arr[j]) {
          min = j;
        }
      }
      // Check if there was a new min.
      if (arr[min] < arr[i]) {
        // Do the swap.
        int tmp = arr[min];
        arr[min] = arr[i];
        arr[i] = tmp;
      }
    }
    return arr;
  }
}
