import java.util.Comparator;

  /**
 * Sort using Simplified TimSort.
 * 
 * @author Garikai Gijima
 * @author Sam Rebelsky
 * @author ChatGPT
 */

public class GijimaGarikaiSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  private static final int MIN_RUN_LENGTH = 32;

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new GijimaGarikaiSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  GijimaGarikaiSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    timSort(values, order);
  } // sort(T[], Comparator<? super T>

  // The main function that sorts array[left...right] using TimSort
public <T> void timSort(T[] array, Comparator<? super T> order) {
  int n = array.length;
  int minRun = n / 10; // Minimum run length set to length/10 as per your requirement
  minRun = Math.max(minRun, MIN_RUN_LENGTH); // Ensuring a practical minimum run length

  // Sort individual subarrays of size minRun
  for (int i = 0; i < n; i += minRun) {
      insertionSort(array, i, Math.min((i + minRun), n), order);
  } // for

  // Start merging from size minRun (or MIN_RUN_LENGTH). It will merge
  // to form size 2*minRun, then 4*minRun, 8*minRun, and so on ...
  for (int size = minRun; size < n; size = 2 * size) {
      for (int left = 0; left < n; left += 2 * size) {
          // Find ending point of left subarray. Mid+1 is starting point of right
          int mid = left + size - 1;
          int right = Math.min((left + 2 * size), n);

          // Merge subarrays array[left...mid] & array[mid+1...right]
          if (mid < right - 1) {
              merge(array, left, mid, right, order);
          } // if 
      } // for
  } // for
} // timSort

// Function to merge the two halves array[left...mid] and array[mid+1...right] of array[]
private <T> void merge(T[] array, int left, int mid, int right, Comparator<? super T> order) {
  // Create temp arrays
  T[] leftArr = (T[]) new Object[mid - left + 1];
  T[] rightArr = (T[]) new Object[right - mid - 1];

  // Copy data to temp arrays
  System.arraycopy(array, left, leftArr, 0, mid - left + 1);
  System.arraycopy(array, mid + 1, rightArr, 0, right - mid - 1);

  // Merge the temp arrays back into array[left...right]
  int i = 0, j = 0, k = left;
  while (i < leftArr.length && j < rightArr.length) {
    if (order.compare(leftArr[i], rightArr[j]) <= 0) {
      array[k++] = leftArr[i++];
    } else {
      array[k++] = rightArr[j++];
    } // if
  }//while

  // Copy remaining elements of leftArr and rightArr if any
  while (i < leftArr.length) {
      array[k++] = leftArr[i++];
  } //while
  while (j < rightArr.length) {
      array[k++] = rightArr[j++];
  }//while
} // merge func

// Function to sort the array[left...right] using insertion sort
private <T> void insertionSort(T[] array, int left, int right, Comparator<? super T> order) {
  for (int i = left + 1; i < right; i++) {
      T key = array[i];
      int j = i - 1;
      while (j >= left && order.compare(array[j], key) > 0) {
          array[j + 1] = array[j];
          j--;
      } //while
      array[j + 1] = key;
  } //for
} // insertionSort



} // class GijimaGarikaiSort

