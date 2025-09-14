package com.abc.algo.link;

/**
 * @Author Administrator
 * @Date 2025/9/11 21:23
 * @Version 1.0
 */
public class PrintLinkNode {

    public static void printLink(ListNode node){
        if (node == null){
            System.out.println("链表为空");
        }
        while (node!=null){
            System.out.print(node.val+"-->");
            node = node.next;
        }
        System.out.println("");
    }

}
