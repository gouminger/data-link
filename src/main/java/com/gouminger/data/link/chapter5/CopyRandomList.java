package com.gouminger.data.link.chapter5;

import java.util.HashMap;
import java.util.Map;

//复制带随机指针的链表
public class CopyRandomList {

    /**
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
     * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
     * 复制链表中的指针都不应指向原链表中的节点 。
     * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
     * 返回复制链表的头节点。
     * 用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
     * val：一个表示Node.val的整数。
     * random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
     * 你的代码 只 接受原链表的头节点 head 作为传入参数。
     */
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        node1.next = node3;
        node3.next = node5;
        node5.next = node7;
        node7.next = node9;

        node1.random = node9;
        node3.random = node7;
        node5.random = node5;
        node7.random = node5;

        Node result = copyRandomList(node1);
        System.out.println(result);
    }

    public static Node copyRandomList(Node head) {
        Node newHead = new Node(-1);
        Node cur = newHead;
        Map<Node, Node> map = new HashMap<>();
        Node t = head;
        while (head != null) {
            cur.next = new Node(head.val);
            map.put(head, cur.next);
            head = head.next;
            cur = cur.next;
        }
        head = t;
        cur = newHead.next;
        while (head != null) {
            if (head.random == null) {
                head = head.next;
                cur = cur.next;
                continue;
            }
            cur.random = map.get(head.random);
            head = head.next;
            cur = cur.next;
        }
        return newHead.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
