package com.gouminger.data.link.chapter1;

//设计链表
public class MyLinkedList {

    /**
     * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
     * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
     * 如果是双向链表，则还需要属性prev以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
     * 实现 MyLinkedList 类：
     * MyLinkedList() 初始化 MyLinkedList 对象。
     * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
     * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
     * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
     * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
     * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
     */

    private LinkNode head;

    public MyLinkedList() {

    }

    public int get(int index) {
        LinkNode cur = this.head;
        while (index >= 0 && cur != null) {
            if (index == 0) {
                return cur.getVal();
            }
            cur = cur.getNext();
            index--;
        }
        return -1;
    }

    public void addAtHead(int val) {
        LinkNode head = new LinkNode(val);
        head.setNext(this.head);
        this.head = head;
    }

    public void addAtTail(int val) {
        if (this.head == null) {
            this.head = new LinkNode(val);
            return;
        }
        LinkNode cur = this.head;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(new LinkNode(val));
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        LinkNode head = this.head;
        while (index > 1 && head != null && head.getNext() != null) {
            head = head.getNext();
            index--;
        }
        if (index != 1 || head == null) {
            return;
        }
        LinkNode cur = new LinkNode(val);
        cur.setNext(head.getNext());
        head.setNext(cur);
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (this.head != null) {
                this.head = this.head.getNext();
            }
            return;
        }
        LinkNode pre = this.head;
        while (index > 1 && pre.getNext() != null) {
            pre = pre.getNext();
            index--;
        }
        if (index != 1) {
            return;
        }
        LinkNode cur = pre.getNext();
        if (cur == null) {
            return;
        }
        pre.setNext(cur.getNext());
    }

    static class LinkNode {
        private int val;
        private LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public LinkNode getNext() {
            return next;
        }

        public void setNext(LinkNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        System.out.println(myLinkedList.get(1));              // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        System.out.println(myLinkedList.get(1));             // 返回 3

        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.addAtHead(2);
        myLinkedList1.deleteAtIndex(1);
        myLinkedList1.addAtHead(2);
        myLinkedList1.addAtHead(7);
        myLinkedList1.addAtHead(3);
        myLinkedList1.addAtHead(2);
        myLinkedList1.addAtHead(5);
        myLinkedList1.addAtTail(5);
        System.out.println(myLinkedList1.get(5));
        myLinkedList1.deleteAtIndex(6);
        myLinkedList1.deleteAtIndex(4);

        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.addAtIndex(1, 0);
        System.out.println(myLinkedList2.get(0));

        MyLinkedList myLinkedList3 = new MyLinkedList();
        myLinkedList3.addAtIndex(2, 1);
        myLinkedList3.addAtIndex(3, 4);
        myLinkedList3.addAtTail(1);
        System.out.println(myLinkedList3.get(0));
        myLinkedList3.deleteAtIndex(0);
        System.out.println(myLinkedList3.get(0));
    }
}

