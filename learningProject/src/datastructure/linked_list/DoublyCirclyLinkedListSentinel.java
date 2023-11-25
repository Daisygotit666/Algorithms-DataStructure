
package datastructure.linked_list;

import java.util.Iterator;

// 双向链表环形带哨兵
public class DoublyCirclyLinkedListSentinel implements Iterable<Integer> {
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

  private Node sentinel = new Node(null, -1, null); // 哨兵

  public DoublyCirclyLinkedListSentinel(){
    sentinel.next = sentinel;
    sentinel.prev = sentinel;

  }

  public void addFirst(int value) {
    Node a = sentinel;
    Node b = sentinel.next;
    Node added = new Node(a, value, b);
    a.next = added;
    b.prev = added;

  }
  

  private Node findByValue(int value) {
    Node p = sentinel.next;
    while (p != sentinel) {
      if (p.value == value) return p;
       p = p.next;
    }
    return null;
      
  }


  public void removeFirst(){
    sentinel.next = sentinel.next.next;
    sentinel.next.next.prev = sentinel;
  }

  public void removeByValue(int value){
    Node removed = findByValue(value);
    if (removed == null) {
      return; // 不用删
    }
    removed.next.prev = removed.prev;
    removed.prev.next = removed.next;

  }

  public void addLast(int value){
    Node last = sentinel.prev;
    Node added = new Node(last,value,sentinel);
    last.next = added;
    sentinel.prev = added;
  }

  public void removeLast(){
    Node removed = sentinel.prev;
    if(removed == sentinel) {
      throw new IllegalArgumentException(String.format("index[%d] 不合法%n", 0 ));
    }
    
    sentinel.prev = removed.prev;
    removed.prev.next = sentinel;
  }

  public Iterator<Integer> iterator(){
    return new Iterator<Integer>() {
      Node p = sentinel.next;
      public boolean hasNext(){
        return p.next != sentinel;
      }

      public Integer next(){
        int value = p.value;
        p = p.next;
        return value;
      }
    };
  }

  
}
