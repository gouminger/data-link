package com.gouminger.data.link.chapter2;

import com.gouminger.data.link.common.ListNode;

//相交链表
public class GetIntersectionNode {

    /**
     * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * 图示两个链表在节点 c1 开始相交：
     * A:    a1->a2->
     *              c1->c2->c3
     * B:b1->b2->b3->
     * 题目数据 保证 整个链式结构中不存在环。
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     * 自定义评测：
     * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
     * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
     * listA - 第一个链表
     * listB - 第二个链表
     * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
     * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
     * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
     */
    public static void main(String[] args) {
        ListNode listNode1_1 = new ListNode(4);
        ListNode listNode1_2 = new ListNode(1);
        ListNode listNode1_3 = new ListNode(8);
        ListNode listNode1_4 = new ListNode(4);
        ListNode listNode1_5 = new ListNode(5);

        ListNode listNode2_1 = new ListNode(5);
        ListNode listNode2_2 = new ListNode(6);
        ListNode listNode2_3 = new ListNode(1);
        listNode1_1.next = listNode1_2;
        listNode1_2.next = listNode1_3;
        listNode1_3.next = listNode1_4;
        listNode1_4.next = listNode1_5;

        listNode2_1.next = listNode2_2;
        listNode2_2.next = listNode2_3;
        listNode2_3.next = listNode1_3;
        System.out.println(getIntersectionNode(listNode1_1, listNode2_1).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //第二个链表尾部指向头部，形成环
        ListNode tailNode = headB;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }
        tailNode.next = headB;

        ListNode idx1 = headA;
        ListNode idx2 = headA;
        boolean hasCycle = false;
        while (true) {
            if (idx1 == null || idx1.next == null || idx2.next == null || idx2.next.next == null) {
                break;
            }
            idx1 = idx1.next;
            idx2 = idx2.next.next;
            if (idx1 == idx2) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            tailNode.next = null;
            return null;
        }
        idx2 = headA;
        while (true) {
            if (idx1 == idx2) {
                tailNode.next = null;
                return idx1;
            }
            idx1 = idx1.next;
            idx2 = idx2.next;
        }
    }
}
