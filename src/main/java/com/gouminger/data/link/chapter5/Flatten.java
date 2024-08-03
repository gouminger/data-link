package com.gouminger.data.link.chapter5;

import com.gouminger.data.link.common.Node;

//扁平化多级双向链表
public class Flatten {

    /**
     * 你会得到一个双链表，其中包含的节点有一个下一个指针、一个前一个指针和一个额外的 子指针 。
     * 这个子指针可能指向一个单独的双向链表，也包含这些特殊的节点。
     * 这些子列表可以有一个或多个自己的子列表，以此类推，以生成如下面的示例所示的 多层数据结构 。
     * 给定链表的头节点head，将链表 扁平化 ，以便所有节点都出现在单层双链表中。
     * 让 curr 是一个带有子列表的节点。子列表中的节点应该出现在扁平化列表中的curr 之后 和curr.next之前 。
     * 返回 扁平列表的 head。列表中的节点必须将其 所有 子指针设置为null。
     */
    public static void main(String[] args) {
        Node node1_1 = new Node();
        node1_1.val = 1;
        Node node1_2 = new Node();
        node1_2.val = 2;
        Node node1_3 = new Node();
        node1_3.val = 3;
        Node node1_4 = new Node();
        node1_4.val = 4;
        Node node1_5 = new Node();
        node1_5.val = 5;
        Node node1_6 = new Node();
        node1_6.val = 6;
        node1_1.next = node1_2;
        node1_2.next = node1_3;
        node1_3.next = node1_4;
        node1_4.next = node1_5;
        node1_5.next = node1_6;
        node1_2.prev = node1_1;
        node1_3.prev = node1_2;
        node1_4.prev = node1_3;
        node1_5.prev = node1_4;
        node1_6.prev = node1_5;

        Node node2_1 = new Node();
        node2_1.val = 7;
        Node node2_2 = new Node();
        node2_2.val = 8;
        Node node2_3 = new Node();
        node2_3.val = 9;
        Node node2_4 = new Node();
        node2_4.val = 10;
        node2_1.next = node2_2;
        node2_2.next = node2_3;
        node2_3.next = node2_4;
        node2_2.prev = node2_1;
        node2_3.prev = node2_2;
        node2_4.prev = node2_3;

        Node node3_1 = new Node();
        node3_1.val = 11;
        Node node3_2 = new Node();
        node3_2.val = 12;
        node3_1.next = node3_2;
        node3_2.prev = node3_1;

        node1_3.child = node2_1;
        node2_2.child = node3_1;

        Node result = flatten(node1_1);
        System.out.println(result);
    }

    public static Node flatten(Node head) {
        Node cur = head;
        if (cur == null) {
            return cur;
        }
        while (cur.child == null && cur.next != null) {
            cur = cur.next;
        }
        if (cur.child == null) {
            return head;
        }
        Node child = flatten(cur.child);
        cur.child = null;
        Node next = cur.next;
        cur.next = child;
        child.prev = cur;
        while (child.next != null) {
            child = child.next;
        }
        if (next != null) {
            child.next = next;
            next.prev = child;
        }
        return head;
    }
}
