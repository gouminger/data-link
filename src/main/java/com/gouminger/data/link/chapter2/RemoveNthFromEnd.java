package com.gouminger.data.link.chapter2;

import com.gouminger.data.link.common.ListNode;

//删除链表的倒数第N个节点
public class RemoveNthFromEnd {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */
    public static void main(String[] args) {
        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(2);
        ListNode listNode1_3 = new ListNode(3);
        ListNode listNode1_4 = new ListNode(4);
        ListNode listNode1_5 = new ListNode(5);
        listNode1_1.next = listNode1_2;
        listNode1_2.next = listNode1_3;
        listNode1_3.next = listNode1_4;
        listNode1_4.next = listNode1_5;
        ListNode res1 = removeNthFromEnd(listNode1_1, 2);
        System.out.println(res1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            assert head != null;
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
