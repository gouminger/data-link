package com.gouminger.data.link.chapter3;

import com.gouminger.data.link.common.ListNode;
import javafx.util.Pair;

//回文链表
public class IsPalindrome {

    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     */
    public static void main(String[] args) {
        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(2);
        ListNode listNode1_3 = new ListNode(2);
        ListNode listNode1_4 = new ListNode(1);
        listNode1_1.next = listNode1_2;
        listNode1_2.next = listNode1_3;
        listNode1_3.next = listNode1_4;
        System.out.println(isPalindrome(listNode1_1));

        ListNode listNode2_1 = new ListNode(1);
        ListNode listNode2_2 = new ListNode(2);
        listNode2_1.next = listNode2_2;
        System.out.println(isPalindrome(listNode2_1));
    }

    public static boolean isPalindrome(ListNode head) {
        return compareNode(head, head).getKey();
    }

    public static Pair<Boolean, ListNode> compareNode(ListNode left, ListNode right) {
        if (right.next != null) {
            Pair<Boolean, ListNode> result = compareNode(left, right.next);
            boolean isPalindrome = result.getKey();
            if (isPalindrome) {
                isPalindrome = result.getValue().val == right.val;
            }
            return new Pair<>(isPalindrome, result.getValue().next);
        }
        return new Pair<>(left.val == right.val, left.next);
    }
}
