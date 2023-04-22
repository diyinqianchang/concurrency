package algo;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2022/2/27 13:24
 * @Version 1.0
 */
public class ListNodeAdd {



    private static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        int carry = 0;
        ListNode dumy = new ListNode(-1);
        ListNode cur = dumy;
        while (l1!=null || l2!=null || carry !=0){
            int t = (l1 == null ? 0:l1.val)+(l2==null?0:l2.val)+carry;
            carry = t/10;
            cur.next = new ListNode(t%10);
            cur = cur.next;
            l1 = l1 == null?null:l1.next;
            l2 = l2 == null?null:l2.next;
        }
        return dumy.next;
    }

    private static void forPrint(ListNode node){
        while (node!=null){
            System.out.print(node.val+"-->");
            node = node.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head){
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;

    }

    private static ListNode removeElements(ListNode head,int val){
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        while (pre!=null&&pre.next!=null){
            if (pre.next.val != val){
                pre = pre.next;
            }else{
                pre.next = pre.next.next; // 指向下一个
            }
        }
        return dummy.next;
    }

    /**
     * 快慢指针找到链表中点，然后分成左右两个链表，递归排序左右链表。最后合并即可
     * @param head
     * @return
     */
    private static ListNode sortList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head,fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode t = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(t);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1!=null && l2!=null){
            if (l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2:l1;
        return dummy.next;
    }


    private static ListNode reverseList(ListNode head){
        ListNode pre = null,p = head;
        while (p!=null){
            ListNode q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        return pre;
    }

    private static ListNode reverseBetween(ListNode head,int m,int n){

        int change_len = n-m+1;
        ListNode preHead = null;
        ListNode result = head;
        while (head !=null && --m > 0){
            preHead = head;
            head = head.next;
        }
        ListNode modifyListTail = head;
        ListNode newHead = null;
        while (head!=null&&change_len>0){
           ListNode next = head.next;
           head.next = newHead;
           newHead = head;
           head = next;
           change_len--;
        }
        modifyListTail.next = head;
        if (preHead!=null){
            preHead.next = newHead;
        }else {
            result = newHead;
        }
        return result;
    }


    public static void main(String[] args) {

        ListNode listNode = new ListNode(-1);
        ListNode curr = listNode;
        int[] num = {1,2,3,4,5};
        for (int i = 0; i < num.length; i++) {
            curr.next = new ListNode(num[i]);
            curr = curr.next;
        }
        ListNode head = reverseBetween(listNode.next,2,4);
        forPrint(head);


    }

}
