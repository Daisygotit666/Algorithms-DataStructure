package algorithms.binarysearch;

import java.util.Arrays;

// 704 35 34  leetcode题目

public class BinarySearch{
  /**
   * @param a 待查找的升序数组
   * @param target 待查找的目标值
   * @return 找到返回索引 找不到返回-1  test！！
   */
  public static int binarysearchBasic(int[] a, int target) {
    int i = 0, j = a.length - 1;
    while(i <= j) { //范围内有东西
      int m = (i+j)/2;
      if (target < a[m]) {
        j = m - 1;
      }else if (a[m] < target) {
        i = m + 1;
      }else{
        return m;
      }
    }
    return (int)-1;
  }
  /*
   * question1: 为什么是i<=j 而不是 i<j?
   * answer: i, j 它们指向的元素也会参与比较， 如果i<j就只有m参与比较
   * 
   * question2: (i+j)/2 有没有问题？
   * answer: 如果a.length是数据类型最大值 MAX_VALUE 那么 （i+j）/2 会溢出
   * solution: (i + j) >>> 1 无符号右移
   * 
   * question3: 都写成小于符号？
   */


    /**
     * 二分查找改动版  运算次数更小 速度更快
     * @param a
     * @param target
     * @return
     */

    public static int binarysearchAlternative(int[] a, int target) {
      int i = 0, j = a.length;  // 1.
      while(i < j) {            // 2.  如果是 i<=j  j 会一直等于m 会陷入死循环嘞
        int m = (i+j)/2;
        if (target < a[m]) {
          j = m;                // 3.
        }else if (a[m] < target) {
          i = m + 1;
        }else{
          return m;
        }
      }
      return (int)-1;
    } 

    /**
     * 线性查找就是for循环查找
     */

    /***
     * 事前分析法：
     * 1. 最差的执行情况
     * 2. 假设每行语句执行时间一样
     * 
     * 时间复杂度：
     * f(n) 实际执行代码行数与n的函数
     * g(n) 经过化简， 变化趋势与f(n)一致的n的函数
     * 二分查找的最坏情况 O(log n) 最好情况 O(1)
     * 
     * 
     * 空间复杂度： 一个算法执行随数据规模增大，而增长的额外空间成本
     * 
     * 算字节占用 
     * 二分查找的空间复杂度： 空间成本不会随n的变化而变化 所以是O(1)
     */


     /***
      * 
      * 二分查找 平衡板 让if 和 else-if执行的次数平衡 
      */
     public static int binarysearchBalance(int[] a, int target) {
      int i = 0, j = a.length;     
      while(1 < j - i) {            // 2.  
        int m = (i+j)/2;
        if (target < a[m]) {
          j = m;                // 3.
        }else{
          i = m;
        }
      }
      if (a[i] == target){
        return i;
      }else{
        return -1;
      }
    } 
    

    /***
     *  插入不存在的元素
     */
    public static void binarysearchInsert(int[] a, int target){
      int i = Arrays.binarySearch(a, target);
      if(i<0){
        int insertIndex = Math.abs(i+1);
        int[] b = new int[a.length + 1];
        System.arraycopy(a, 0, b, 0, insertIndex);
        b[insertIndex] = target;
        System.arraycopy(a, insertIndex, b, insertIndex+1, a.length - insertIndex);
        System.out.println(Arrays.toString(b));
      }
    }
    
    /**
     * 如果数组中有重复元素， 返回重复元素中最左边的元素
     *  LeftMost
     */
    public static int binarysearchLeftMost(int[] a, int target) {
      int i = 0, j = a.length - 1;
      int candidate = -1;
      while(i <= j) { 
        int m = (i+j)/2;
        if (target < a[m]) {
          j = m - 1;
        }else if (a[m] < target) {
          i = m + 1;
        }else{
          // 记录候选位置
          candidate = m;
          j = m-1;   // 换成 i = m + 1 就是rightmost
        }
      }
      return candidate;
    }


    // 没找到的话让返回值更有用
    // 返回 >= target的最靠左的索引
    public static int binarysearchLeftMostAlternative(int[] a, int target) {
      int i = 0, j = a.length - 1;
      while(i <= j) { 
        int m = (i+j) >>> 1;
        if (target <= a[m]) {
          j = m - 1;
        }else {
          i = m + 1;
        }
      }
      return i;
    }
    
    // 返回<= target的最靠右的索引位置
    public static int binarysearchRightMostAlternative(int[] a, int target) {
      int i = 0, j = a.length - 1;
      while(i <= j) { 
        int m = (i+j) >>> 1;
        if (target < a[m]) {
          j = m - 1;
        }else {
          i = m + 1;
        }
      }
      return i - 1;
    }

    /**
     * 我的小tips：
     * 1. 画一个长度为6的数组， 选一个target
     * 2. 根据满足的条件假设i = j的索引位置
     * 3. 分析target和a[m]的大小关系， 找到while循环可以终止的条件
     * 4. 但要记住： 找target的右边的索引 返回的是i， 找target的左边的索引 返回的是i-1
     * 
     */




    /**  理解 ↓
     *  [1 2 4 4 4 7 7]
     *  X < 4  ->  0...leftmost(4)-1
     *  X <= 4 ->  0...rightmost(4)
     *  X > 4  ->  rightmost(4)+1 ... 无穷大
     *  X >= 4 ->  leftmost(4) .. 无穷大
     *  4 <= x <= 7 -> leftmost(4) ... rightmost(7)
     *  4 < x < 7 -> rightmost(4)+1 ... leftmost(7)-1
     */

  

}
