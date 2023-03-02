
//Imports
import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//IsAnA is a StringChecker class used for testing
class IsAnA implements StringChecker {
  @Override
  public boolean checkString(String s) {
    return !s.equals("a");
  }
}

public class Tester {
  // Tests filter on arbitrary sequence of strings
  @Test
  public void testFilterArbitrary() {
    List<String> myList = Arrays.asList("a", "hello", "b", "a", "c");
    List<String> expected = Arrays.asList("hello", "b", "c");

    assertEquals(expected, ListExamples.filter(myList, new IsAnA()));
  }

  // Tests filter on an empty list
  @Test
  public void testFilterEmpty() {
    List<String> myList = Arrays.asList();
    List<String> expected = Arrays.asList();

    assertEquals(expected, ListExamples.filter(myList, new IsAnA()));
  }

  // Tests merge on arbitrary sequence of letters
  @Test(timeout = 500)
  public void testMergeArbitrary() {
    List<String> list1 = Arrays.asList("a", "c", "e");
    List<String> list2 = Arrays.asList("a", "b", "f", "g");

    List<String> merged = ListExamples.merge(list1, list2);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "e", "f", "g");

    assertEquals(expected, merged);
  }

  // Tests merge on empty lists
  @Test
  public void testMergeEmpty() {
    List<String> list1 = Arrays.asList();
    List<String> list2 = new ArrayList<>();

    List<String> merged = ListExamples.merge(list1, list2);
    List<String> expected = Arrays.asList();

    assertEquals(expected, merged);

    list1 = Arrays.asList("asdf");
    list2 = new ArrayList<>();

    merged = ListExamples.merge(list1, list2);
    expected = Arrays.asList("asdf");

    assertEquals(expected, merged);
  }
}