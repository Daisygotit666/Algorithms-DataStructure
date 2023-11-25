package datastructure.linked_list;

import java.util.Iterator;

// 双向链表带哨兵
public class DoublyLinkedListSentinel implements Iterable<Integer> {
  static class Node{
    Node prev; //上一个指针
    Node next; //下一个结点指针
    int value;

    public Node (Node prev, int value, Node next) {
      this.prev = prev;
      this.next = next;
      this.value = value;
    }
  }

  private Node head; // 头烧饼
  private Node tail; // 尾哨兵

  public DoublyLinkedListSentinel(){
    head = new Node(null, 666, null);
    tail = new Node(null, 888, null);
    head.next = tail;
    tail.prev = head;

  }

  private Node findNode(int index){
    int i = -1;
    for(Node p = head; p != tail; p = p.next, i++){
      if(i == index) return p;
    }
    return null;
  }

  public void insert(int index, int value){
    Node prev = findNode(index - 1);
    if(prev == null){
      throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index ));
    }
    Node next = prev.next;
    Node insertNode = new Node(prev, value, next);
    prev.next = insertNode;
    next.prev = insertNode;
    
  }

  public void remove(int index){
    Node prev = findNode(index - 1);
    if (prev == null) {
      throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index ));
    }


    Node removed = prev.next;
    if(removed == tail){
      throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index ));
    }

    Node next = removed.next;
    prev.next = next;
    next.prev = prev;

  }

  public void addLast(int value){
    Node last = tail.prev;
    Node added = new Node(last,value,tail);
    last.next = added;
    tail.prev = added;
  }

  public void removeLast(){
    Node removed = tail.prev;
    if(removed == head) {
      throw new IllegalArgumentException(String.format("index[%d] 不合法%n", 0 ));
    }
    
    tail.prev = removed.prev;
    removed.prev.next = tail;
  }

  public Iterator<Integer> iterator(){
    return new Iterator<Integer>() {
      Node p = head.next;
      public boolean hasNext(){
        return p.next != tail;
      }

      public Integer next(){
        int value = p.value;
        p = p.next;
        return value;
      }
    };
  }

  
}
