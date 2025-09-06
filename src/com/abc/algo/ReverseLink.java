package com.abc.algo;

/**
 * @Author Administrator
 * @Date 2025/9/3 21:49
 * @Version 1.0
 * 翻转链表
 */
public class ReverseLink {

    static ListNode successor = null;
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        traverse(node1);
//        System.out.println("翻转前...");
//        printLink(node1);
//        System.out.println("");
//        ListNode listNode = reverseListBetween(node1,2,5);
//        System.out.println("翻转后...");
//        printLink(listNode);

    }

    public static void traverse(ListNode head){
        if (head == null){
            return;
        }
        System.out.println(head.val);
        traverse(head.next);

    }


    public static ListNode reverseListBetween(ListNode head,int m, int n) {

        if (m == 1){
            return reverseList(head,n);
        }
        head.next = reverseListBetween(head.next,m-1,n-1);
        return head;
    }



    public static ListNode reverseList(ListNode head,int n) {

        if (n == 1){
            successor = head.next;
            return head;
        }

        ListNode last = reverseList(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null){
            if (head!=null){
                System.out.println("head "+head.val);
            }
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;


    }


    public static void printLink(ListNode head){
        while (head != null){
            System.out.print(" "+head.val);
            head = head.next;
        }
    }


}
