package com.gouminger.data.link.chapter2;

import com.gouminger.data.link.common.ListNode;

//环形链表 II
public class DetectCycle {

    /**
     * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 不允许修改 链表。
     */
    public static void main(String[] args) {
        ListNode listNode1_1 = new ListNode(3);
        ListNode listNode1_2 = new ListNode(2);
        ListNode listNode1_3 = new ListNode(0);
        ListNode listNode1_4 = new ListNode(-1);
        listNode1_1.next = listNode1_2;
        listNode1_2.next = listNode1_3;
        listNode1_3.next = listNode1_4;
        listNode1_4.next = listNode1_2;
        System.out.println(detectCycle(listNode1_1).val);

        ListNode listNode2_1 = new ListNode(1);
        ListNode listNode2_2 = new ListNode(2);
        listNode2_1.next = listNode2_2;
        listNode2_2.next = listNode2_1;
        System.out.println(detectCycle(listNode2_1).val);

        ListNode listNode3_1 = new ListNode(1);
        System.out.println(detectCycle(listNode3_1));
    }

    public static ListNode detectCycle(ListNode head) {
        boolean hasCycle = false;
        ListNode idx1 = head;
        ListNode idx2 = head;
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
            return null;
        }
        int cycleLength = 1;
        while (idx1.next != idx2) {
            idx1 = idx1.next;
            cycleLength++;
        }

        idx1 = head;
        idx2 = head;
        while (true) {
            idx1 = idx1.next;
            for (int i=0; i<=cycleLength; i++) {
                idx2 = idx2.next;
                if (idx2 == head) {
                    return head;
                }
            }
            if (idx1 == idx2) {
                return idx1;
            }
        }
    }
}
