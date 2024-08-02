package com.gouminger.data.link.chapter5;

import com.gouminger.data.link.common.ListNode;

//合并两个有序链表
public class MergeTwoLists {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public static void main(String[] args) {
        ListNode node1_1 = new ListNode(1);
        ListNode node1_2 = new ListNode(3);
        ListNode node1_3 = new ListNode(5);
        ListNode node1_4 = new ListNode(7);
        ListNode node1_5 = new ListNode(9);
        node1_1.next = node1_2;
        node1_2.next = node1_3;
        node1_3.next = node1_4;
        node1_4.next = node1_5;

        ListNode node2_1 = new ListNode(2);
        ListNode node2_2 = new ListNode(4);
        ListNode node2_3 = new ListNode(10);
        ListNode node2_4 = new ListNode(113);
        ListNode node2_5 = new ListNode(156);
        node2_1.next = node2_2;
        node2_2.next = node2_3;
        node2_3.next = node2_4;
        node2_4.next = node2_5;

        ListNode result1 = mergeTwoLists(node1_1, node2_1);
        System.out.println(result1);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode link = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                link.next = list1;
                ListNode t = list1.next;
                list1.next = null;
                list1 = t;
            } else {
                link.next = list2;
                ListNode t = list2.next;
                list2.next = null;
                list2 = t;
            }
            link = link.next;
        }
        if (list1 != null) {
            link.next = list1;
        } else if (list2 != null) {
            link.next = list2;
        }
        return head.next;
    }
}
