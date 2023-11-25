package datastructure.linked_list;

import java.util.Iterator;
import java.util.function.Consumer;

// 单向链表
public class SinglyLinkedListSentinel implements Iterable<Integer>{ // 整体
  private Node head = new Node(666, null); // 头指针指向一个哨兵节点

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
    insert(0, value);
  }
  

  public void loop1(Consumer<Integer> consumer) {
    Node p = head.next;
    while(p != null){
      consumer.accept(p.value);
      p = p.next;
    }
  }

  public void loop2(Consumer<Integer> consumer) {
    for(Node p = head.next; p != null; p = p.next){
      consumer.accept(p.value);
    }
  }


  // 迭代器
  @Override
  public Iterator<Integer> iterator() {
    // 匿名内部类
    return new Iterator<Integer>() {
      Node p = head.next;
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
    Node p;
    // 这里是p.next != null 因为要让p指向最后一个节点，而不是外部
    for(p = head; p.next!= null; p = p.next);
    return p;
  }

  public void addLast(int value) {
    Node last = findLast();                      // 区别 1
    last.next = new Node(value, null);
  }

  private Node findNode(int index) {
    int i = -1;
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

