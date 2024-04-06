import java.util.Comparator;

  /**
 * Sort using insertion sort.
 *
 * @author Garikai Gijima
 * @author Sam Rebelsky
 */

public class GijimaGarikaiSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

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
    //stub for now
  } // sort(T[], Comparator<? super T>
} // class InsertionSort

