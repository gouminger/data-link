package com.gouminger.data.link.chapter3;

import com.gouminger.data.link.common.ListNode;
import javafx.util.Pair;

//反转链表
public class ReverseList {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
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
        ListNode res1 = reverseList(listNode1_1);
        System.out.println(res1);

        ListNode listNode2_1 = new ListNode(1);
        ListNode listNode2_2 = new ListNode(2);
        listNode2_1.next = listNode2_2;
        ListNode res2 = reverseList(listNode2_1);
        System.out.println(res2);
    }

    //迭代
    public static ListNode reverseList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = head;
            head = next;
        }
        return head;
    }

    //递归
    public static ListNode reverseList(ListNode head) {
        Pair<ListNode, ListNode> result = searchNext(head);
        return result.getKey();
    }

    public static Pair<ListNode, ListNode> searchNext(ListNode head) {
        if (head.next == null) {
            return new Pair<>(head, head);
        }
        Pair<ListNode, ListNode> result = searchNext(head.next);
        head.next = null;
        result.getValue().next = head;
        return new Pair<>(result.getKey(), head);
    }
}
