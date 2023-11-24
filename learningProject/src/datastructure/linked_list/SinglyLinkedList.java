package datastructure.linked_list;

import java.util.Iterator;
import java.util.function.Consumer;

// 单向链表
public class SinglyLinkedList implements Iterable<Integer>{ // 整体
  Node head = null; // 头指针


  /**
   * 节点类（内部类） 外部知道越少的东西越好
   * java中的指针是引用
   */
  private static class Node{
    int value; //值
    Node next; //下一个节点指针
    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  // 向链表头部添加
  public void addFirst(int value) {
    // 1. 链表为空
    // head = new Node(value, null);
    // 2. 链表非空
    head = new Node(value, head);
  }
  

  // 遍历链表
  // 对链表的操作最好不要放在循环里面 而是当作参数传递过来
  // 调用： list.loop(value -> {System.out.println(value);})
  public void loop1(Consumer<Integer> consumer) {
    Node p = head;
    while(p != null){
      consumer.accept(p.value);
      p = p.next;
    }
  }

  public void loop2(Consumer<Integer> consumer) {
    for(Node p = head; p != null; p = p.next){
      consumer.accept(p.value);
    }
  }


  // 迭代器
  @Override
  public Iterator<Integer> iterator() {
    // 匿名内部类
    return new Iterator<Integer>() {
      Node p = head;
      public boolean hasNext() { // 是否有下一个元素
        return p.next != null;
      }
      public Integer next() {  // 返回当前值， 并指向下一个元素
        p = p.next;
        return p.value;
      }
    };
  }


  // 在尾部添加
  private Node findLast(){
    if (head == null){
      return null;
    }
    Node p;
    // 这里是p.next != null 因为要让p指向最后一个节点，而不是外部
    for(p = head; p.next!= null; p = p.next);
    return p;
  }

  public void addLast(int value) {
    Node last = findLast();
    if (last == null){
      addFirst(value);
      return;
    }
    last.next = new Node(value, null);
  }

  private Node findNode(int index) {
    int i = 0;
    for(Node p = head; p != null; p = p.next, i++){
      if(i == index){
        return p;
      }
    }
    return null; // 没找到
  }

  // 根据索引查找
  public int get(int index){
    Node node = findNode(index);
    if (node == null){
      throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index));
    }
    return node.value;
  }

  // 向索引位置插入
  public void insert(int value, int index){
    if(index==0){
      addFirst(value);
      return;
    }
    Node pBefore = findNode(index-1);
    if (pBefore == null){
      throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index));
    }
    pBefore.next = new Node(value, pBefore.next);
  }


  public void removeFirst(){
    if (head == null){
      throw new IllegalArgumentException(String.format("index[%d] 不合法%n", 0));
    }
    head = head.next;
  }

  public void remove(int index){
    if (index==0){
      removeFirst();
      return;
    }
    Node pBefore = findNode(index-1);
    if (pBefore == null){  // 如果上一个节点是null
      throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index));
    }
    if (pBefore.next == null){  // 如果被删除的节点是null
      throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index));
    }
    pBefore.next = pBefore.next.next;
  }

}

