package com.linyy.leetcode.answer.from1to25;

/**
 * 两数相加
 */
public class Leetcode2 {

    public static void main(String[] args) {

        ListNode l1_3 = new ListNode(3);
        ListNode l1_2 = new ListNode(4,l1_3);
        ListNode l1_1 = new ListNode(2,l1_2);
        ListNode l2_3 = new ListNode(4);
        ListNode l2_2 = new ListNode(6,l2_3);
        ListNode l2_1 = new ListNode(5,l2_2);
        ListNode result = addTwoNumbers(l1_1,l2_1);
        do{
            System.out.println(result.val);
            result = result.next;
        }while(result != null);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1;
        // 各个相同位置节点数相加，存到l1上
        do{
            l1.val = l1.val + l2.val;
            if(l1.next == null){
                l1.next = l2.next;
                break;
            }
            if(l2.next == null){
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }while(l1 != null || l2 != null);
        // 进1
        boolean add1 = false;
        ListNode curr = result;
        while(curr.next != null){
            if(add1){
                curr.val = curr.val + 1;
            }
            if(curr.val > 9){
                curr.val = curr.val - 10;
                add1 = true;
            }else{
                add1 = false;
            }
            curr = curr.next;
        }
        if(add1){
            curr.val = curr.val + 1;
        }
        if(curr.val > 9){
            curr.val = curr.val - 10;
            curr.next = new ListNode(1);
        }
        return result;
    }
}
