package com.gouminger.data.link.chapter5;

import com.gouminger.data.link.common.ListNode;

//两数相加
public class AddTwoNumbers {

    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     */
    public static void main(String[] args) {
        ListNode node1_1 = new ListNode(2);
        ListNode node1_2 = new ListNode(4);
        ListNode node1_3 = new ListNode(6);
        node1_1.next = node1_2;
        node1_2.next = node1_3;

        ListNode node2_1 = new ListNode(5);
        ListNode node2_2 = new ListNode(6);
        ListNode node2_3 = new ListNode(4);
        node2_1.next = node2_2;
        node2_2.next = node2_3;

        ListNode result1 = addTwoNumbers(node1_1, node2_1);
        System.out.println(result1);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int sum = 0, t = 0;
        while (l1 != null || l2 != null) {
            sum += t;
            t = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            t = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum = 0;
        }
        if (t > 0) {
            cur.next = new ListNode(t);
        }
        return head.next;
    }
}
