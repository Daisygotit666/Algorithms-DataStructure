package algorithms.binarysearch;

// 测试文件
public class TestBinarySearch {
  public static void main(String[] args) {
    int[] a = { 7, 13, 21, 30, 38, 44, 52, 53 };
    BinarySearch.binarysearchInsert(a, 12);
  }

}

/**
 * InnerTestBinarySearch
 */
class TestBinarySearch01 {
  public static boolean assertEquals(int expected, int actual) {
    if (expected != actual) {
      return false; //
    }
    return true;
  }

  public static void testSearchBasic() {
    System.out.println("========基础版======");
    int[] a = { 7, 13, 21, 30, 38, 44, 52, 53 };
    System.out.println(assertEquals(0, BinarySearch.binarysearchBasic(a, 7)));
    System.out.println(assertEquals(1, BinarySearch.binarysearchBasic(a, 13)));
    System.out.println(assertEquals(2, BinarySearch.binarysearchBasic(a, 21)));
    System.out.println(assertEquals(3, BinarySearch.binarysearchBasic(a, 30)));
    System.out.println(assertEquals(4, BinarySearch.binarysearchBasic(a, 38)));
    System.out.println(assertEquals(5, BinarySearch.binarysearchBasic(a, 44)));
    System.out.println(assertEquals(6, BinarySearch.binarysearchBasic(a, 52)));
    System.out.println(assertEquals(7, BinarySearch.binarysearchBasic(a, 53)));
  }

  public static void testSearchAlternative() {
    System.out.println("=======改动版=======");
    int[] a = { 7, 13, 21, 30, 38, 44, 52, 53 };
    System.out.println(assertEquals(0, BinarySearch.binarysearchAlternative(a, 7)));
    System.out.println(assertEquals(1, BinarySearch.binarysearchAlternative(a, 13)));
    System.out.println(assertEquals(2, BinarySearch.binarysearchAlternative(a, 21)));
    System.out.println(assertEquals(3, BinarySearch.binarysearchAlternative(a, 30)));
    System.out.println(assertEquals(4, BinarySearch.binarysearchAlternative(a, 38)));
    System.out.println(assertEquals(5, BinarySearch.binarysearchAlternative(a, 44)));
    System.out.println(assertEquals(6, BinarySearch.binarysearchAlternative(a, 52)));
    System.out.println(assertEquals(7, BinarySearch.binarysearchAlternative(a, 53)));
  }
}