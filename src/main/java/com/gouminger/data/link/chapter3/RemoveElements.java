package com.gouminger.data.link.chapter3;

import com.gouminger.data.link.common.ListNode;

//移除链表元素
public class RemoveElements {

    /**
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     */
    public static void main(String[] args) {
        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(2);
        ListNode listNode1_3 = new ListNode(6);
        ListNode listNode1_4 = new ListNode(3);
        ListNode listNode1_5 = new ListNode(4);
        ListNode listNode1_6 = new ListNode(5);
        ListNode listNode1_7 = new ListNode(6);
        listNode1_1.next = listNode1_2;
        listNode1_2.next = listNode1_3;
        listNode1_3.next = listNode1_4;
        listNode1_4.next = listNode1_5;
        listNode1_5.next = listNode1_6;
        listNode1_6.next = listNode1_7;
        ListNode result1 = removeElements(listNode1_1, 6);
        System.out.println(result1);

        ListNode result2 = removeElements(null, 6);
        System.out.println(result2);

        ListNode listNode3_1 = new ListNode(7);
        ListNode listNode3_2 = new ListNode(7);
        ListNode listNode3_3 = new ListNode(7);
        ListNode listNode3_4 = new ListNode(7);
        listNode3_1.next = listNode3_2;
        listNode3_2.next = listNode3_3;
        listNode3_3.next = listNode3_4;
        ListNode result3 = removeElements(listNode3_1, 7);
        System.out.println(result3);
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode result = head;
        while (head != null) {
            if (head.val == val) {
                result = head.next;
                head = head.next;
                continue;
            }
            if (head.next != null) {
                if (head.next.val == val) {
                    ListNode after = head.next.next;
                    head.next = after;
                } else {
                    head = head.next;
                }
            } else {
                break;
            }
        }
        return result;
    }
}
