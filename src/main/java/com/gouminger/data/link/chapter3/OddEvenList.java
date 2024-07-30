package com.gouminger.data.link.chapter3;

import com.gouminger.data.link.common.ListNode;

//奇偶链表
public class OddEvenList {

    /**
     * 给定单链表的头节点head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为偶数 ，以此类推。
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     * 你必须在O(1)的额外空间复杂度和O(n)的时间复杂度下解决这个问题。
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
        ListNode result1 = oddEvenList(listNode1_1);
        System.out.println(result1);

        ListNode listNode2_1 = new ListNode(2);
        ListNode listNode2_2 = new ListNode(1);
        ListNode listNode2_3 = new ListNode(3);
        ListNode listNode2_4 = new ListNode(5);
        ListNode listNode2_5 = new ListNode(6);
        ListNode listNode2_6 = new ListNode(4);
        ListNode listNode2_7 = new ListNode(7);
        listNode2_1.next = listNode2_2;
        listNode2_2.next = listNode2_3;
        listNode2_3.next = listNode2_4;
        listNode2_4.next = listNode2_5;
        listNode2_5.next = listNode2_6;
        listNode2_6.next = listNode2_7;
        ListNode result2 = oddEvenList(listNode2_1);
        System.out.println(result2);
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        ListNode linkRight = right;
        boolean isRight = true;
        while (true) {
            if (isRight) {
                if (right.next != null) {
                    left.next = right.next;
                    left = right.next;
                    isRight = false;
                } else {
                    break;
                }
            } else {
                if (left.next != null) {
                    right.next = left.next;
                    right = left.next;
                    isRight = true;
                } else {
                    break;
                }
            }
        }
        left.next =  linkRight;
        right.next = null;
        return head;
    }
}
