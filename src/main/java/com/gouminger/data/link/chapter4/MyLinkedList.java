package com.gouminger.data.link.chapter4;

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        System.out.println(myLinkedList.get(1));              // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        System.out.println(myLinkedList.get(1));              // 返回 3

        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.addAtTail(1);
        myLinkedList1.addAtTail(3);
        System.out.println(myLinkedList.get(1));
    }

    private Node head;

    public MyLinkedList() {
    }

    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        Node cur = head;
        while (index > 0) {
            if (cur == null) {
                return -1;
            }
            cur = cur.next;
            index--;
        }
        if (cur == null) {
            return -1;
        }
        return cur.getVal();
    }

    public void addAtHead(int val) {
        if (this.head == null) {
            this.head = new Node(val);
            return;
        }
        Node newHead = new Node(val);
        this.head.setPre(newHead);
        newHead.setNext(this.head);
        this.head = newHead;
    }

    public void addAtTail(int val) {
        if (this.head == null) {
            this.head = new Node(val);
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        Node v = new Node(val);
        v.setPre(cur);
        cur.setNext(v);
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node cur = this.head;
        while (index > 1) {
            if (cur == null) {
                return;
            }
            cur = cur.next;
            index--;
        }
        if (cur == null) {
            return;
        }
        Node next = cur.getNext();
        Node v = new Node(val);
        cur.setNext(v);
        v.setNext(next);
        v.setPre(cur);
        if (next != null) {
            next.setPre(v);
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (this.head != null) {
                this.head = this.head.getNext();
            }
            return;
        }
        Node cur = this.head;
        while (index > 1) {
            if (cur == null) {
                return;
            }
            cur = cur.next;
            index--;
        }
        if (cur == null || cur.getNext() == null) {
            return;
        }
        Node next = cur.getNext().getNext();
        cur.setNext(next);
        if (next != null) {
            next.setPre(cur);
        }
    }

    static class Node {
        private final int val;
        private Node pre;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
