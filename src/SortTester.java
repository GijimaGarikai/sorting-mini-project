import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Garikai
 * @author Sam Rebelsky
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter = new MergeSort();

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void orderedIntegerTest() {
    Integer[] array = new Integer[100];
    for (int i = 0; i < 100; i++) {
        array[i] = i*2;
    }
    Integer[] expected = array.clone();
    sorter.sort(array, (x, y) -> x.compareTo(y));
    assertArrayEquals(array, expected);
  } // orderedIntegerTest
  @Test
  public void palindromicIntegerTest() {
    Integer[] array = {1,2,3,4,5,4,3,2,1};
    Integer[] expected = {1,1,2,2,3,3,4,4,5};
    sorter.sort(array, (x, y) -> x.compareTo(y));
    assertArrayEquals(array, expected);
  } // palindromicIntegerTest

  @Test
  public void reverseOrderedIntegerTest() {
    Integer[] array = {10,8,6,4,2,0};
    Integer[] expected = {0,2,4,6,8,10};
    sorter.sort(array, (x, y) -> x.compareTo(y));
    assertArrayEquals(array, expected);
  } // reverseOrderedIntegerTest

  @Test
  public void positiveNegativeIntegerTest() {
    Integer[] array = new Integer[100];
    Integer[] expected = new Integer[100]; 
    for (int i = 0; i < 100; i++) {
        array[i] = (i % 2 == 0) ? i : -i;
    }
    int count = 0;
    for (int i = -99; i < 0; i+=2) {
      expected[count++] = i;
    }
    for (int i = 0; i < 100; i+=2) {
      expected[count++] = i;
    }
    sorter.sort(array, (x, y) -> x.compareTo(y));
    assertArrayEquals(array, expected);
  } // orderedIntegerTest

  @Test
  public void repeatingIntegerTest() {
    Integer[] array = new Integer[100];
    Integer[] expected = new Integer[100]; 
    for (int i = 0; i < 100; i++) {
        array[i] = (i < 20) ? 5 : 2;
    }
    for (int i = 0; i < 100; i++) {
      expected[i] = (i < 80) ? 2 : 5;
    }
    sorter.sort(array, (x, y) -> x.compareTo(y));
    assertArrayEquals(array, expected);
  } // orderedIntegerTest

} // class SortTester
