package datastructure.array;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

// 动态数组
public class DynamicArray implements Iterable<Integer> {
  private int size = 0; // 逻辑大小
  private int capacity = 8; // 容量
  private int[] array = new int[capacity];

  // 插入新元素到数组尾部
  public void addLast(int element) {
    add(size, element);
  }

  // 插入新元素到指定索引
  public void add(int index, int element) {
    if (index >= 0 && index < size) {
      System.arraycopy(array, index, array, index + 1, size - index);
    }
    array[index] = element;
    size++;
  }

  public int get(int index) {
    return array[index];
  }

  /**
   * 遍历方法1
   * 
   * @param consumer - 遍历要执行的操作， 入参：每个元素
   *                 调用：
   *                 dynamicArray.foreach((element)->{System.out.println(element)})
   * 
   */
  public void foreach(Consumer<Integer> consumer) {
    for (int i = 0; i < size; i++) {
      consumer.accept(array[i]);
    }
  }

  /**
   * 遍历方法2 - 迭代器遍历
   * 
   * @return
   */
  @Override
  public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      int i = 0;

      public boolean hasNext() { // 有没有下一个元素额
        return i < size;
      }

      public Integer next() { // 返回当前元素，并移动到下一个元素
        return array[i++];
      }
    };
    // TODO Auto-generated method stub
  }

  /***
   * 
   */
  public IntStream stream() {
    return IntStream.of(array);
  }

}
