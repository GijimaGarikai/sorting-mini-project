import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Garikai
 * @author Sam Rebelsky
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    mergeSort(values, 0, values.length-1, order);
  } // sort(T[], Comparator<? super T>

  private <T> void mergeSort(T[] values, int start, int end, Comparator<? super T> order) {
    if (end <= start) {
      return;
    }// if statement
    int mid = start + (end-start)/2;
    mergeSort(values, start, mid, order);
    mergeSort(values, mid+1, end, order);
    merge(values, start, mid, end, order);
  }// mergeSort(values, start, end,order)

  @SuppressWarnings("unchecked")
  private <T> void merge(T[] values, int start, int mid, int end, Comparator<? super T> order) {
    T[] temp = (T[]) new Object[end-start+1];
    int i = start;
    int j = mid+1;
    int cur = 0;
    while (i <= mid && j <= end) {
      if (order.compare(values[i], values[j]) < 0) {
        temp[cur] = values[i++];
      } else {
        temp[cur] = values[j++];
      } // if statement
      cur++;
    }//while loop
    while (i <= mid) {
      temp[cur++] = values[i++];
    }//while loop
    while (j <= end) {
      temp[cur++] = values[j++];
    }//while loop
    for (int count = 0; count < temp.length; count++) {
      values[start+count] = temp[count];
    }//for loop
  }//merge(values,start,mid,end,order)
} // class MergeSort
