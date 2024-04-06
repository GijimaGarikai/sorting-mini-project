import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Your Name Here
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quickSort(values, 0, values.length-1, order);
  } // sort(T[], Comparator<? super T>

  private <T> void quickSort(T[] values, int low, int high, Comparator<? super T> order) {
    if (low < high) {
      int pivot = partition(values, low, high, order);
      quickSort(values, low, pivot-1, order);
      quickSort(values, pivot+1, high, order);
    }//if statement
  }// quickSort(values, low, high, order)

  private <T> int partition(T[] values, int low, int high, Comparator<? super T> order) {
    T pivot = values[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (order.compare(values[j], pivot) < 0) {
        i++;
        //swap
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
      }//if statement
    }//for loop

    //swap
    T temp1 = values[i+1];
    values[i+1] = values[high];
    values[high] = temp1;
    return i+1;
  } //partition(values,low,high,order)
} // class Quicksort
