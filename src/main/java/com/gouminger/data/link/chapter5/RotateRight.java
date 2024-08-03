package com.gouminger.data.link.chapter5;

import com.gouminger.data.link.common.ListNode;

//旋转链表
public class RotateRight {

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = rotateRight(node1, 2);
        System.out.println(result);

        ListNode result2 = rotateRight(new ListNode(1), 0);
        System.out.println(result2);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = 1;
        ListNode tHead = head;
        while (tHead.next != null) {
            tHead = tHead.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        //形成闭环
        tHead.next = head;
        k = length-k;
        while (k != 1) {
            head = head.next;
            k--;
        }
        ListNode result = head.next;
        head.next = null;
        return result;
    }
}
