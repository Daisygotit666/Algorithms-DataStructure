package datastructure.array;

/************************************************************************************************
 * 数组是由一组元素（值或者变量）组成的数据结构，每个元素有至少一个索引或键来标识
 * 
 * 数组内的元素是连续存储的，所以数组中元素的地址，可以通过其索引计算出来
 * : 知道了数组的数据起始地址BaseAddress，就可以根据公式BaseAddress + i * size计算出索引i元素的地址
 *  size : int 4个字节 double8个字节 
 */


/************************************************************************************************
 * java中数组结构为： 8 字节markword class指针4字节 数组大小4字节 数组元素 + 对其字节
 * （java中所有对象大小都是8字节的整数倍， 不足的要用对齐字节补足）
 * 如： int[] array = {1, 2, 3, 4, 5} 的大小为40个字节
 *    ------------------------------
 *    |       markword 8字节        |
 *    ------------------------------
 *    |class指针4字节 |数组大小4字节|
 *    ------------------------------
 *    |  1 (4字节)    | 2 (4字节)   |
 *     ------------------------------
 *    |  3 (4字节)    | 4 (4字节)   |
 *     ------------------------------
 *    |  5 (4字节)    |补足 (4字节) |
 *    ------------------------------
 * 
 * 随机访问数组的时间复杂度是O(1)
 */

public class Arrays {
  
}