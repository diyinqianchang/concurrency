package com.abc.algo.link;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2025/9/11 21:08
 * @Version 1.0
 */
public class MergeLink {

    private ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode p1 = l1,p2 = l2;
        while (p1!=null && p2!=null){
            if (p1.val <= p2.val){
                cur.next = p1;
                p1 = p1.next;
            }else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        cur.next = p1 == null ? p2:p1;
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0){
            return null;
        }
        if (length == 1){
            return lists[0];
        }
        ListNode cur = lists[0];
        for (int i = 1; i < length; i++) {
            cur = mergeTwoLists(cur,lists[i]);
        }
        return cur;
    }

    ListNode findFromEnd(ListNode head,int k){
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fromEnd = findFromEnd(dummy, n + 1);
        fromEnd.next = fromEnd.next.next;
        return dummy.next;
    }


    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        System.out.println(slow.val);
        System.out.println(fast.val);
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null){
            lenA++;
            p1 = p1.next;
        }
        while (p2 != null){
            lenB++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        int len = lenA > lenB ? lenA - lenB : lenB - lenA;
        System.out.println("len:"+len+"lenA:"+lenA+"lenB:"+lenB);
        if (lenA > lenB) {
            for (int i = 0; i < len; i++) {
                p1 = p1.next;
            }
        }else {
            for (int i = 0; i < len; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != null && p2 != null){
            if (p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MergeLink mergeLink = new MergeLink();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node6 = new ListNode(3);
        node6.next = node4;

//        node5.next = node6;
//        PrintLinkNode.printLink(node1);
//        ListNode listNode = mergeLink.middleNode(node1);
//        PrintLinkNode.printLink(listNode);
        ListNode intersectionNode = mergeLink.getIntersectionNode(node1, node6);
        PrintLinkNode.printLink(intersectionNode);

    }

    private static void mergeLink(MergeLink mergeLink) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node5.next = node6;
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node7.next = node8;
        ListNode listNode = mergeLink.mergeKLists(new ListNode[]{node1, node5, node7});
        PrintLinkNode.printLink(listNode);
    }


}
