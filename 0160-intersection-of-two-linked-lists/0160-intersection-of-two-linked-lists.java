/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode a=headA;
        ListNode b=headB;
        //if this conditiion becomes true then here is no intersection point
        while(a!=b){
            a=(a==null) ? headB :a.next;
            b=(b==null) ? headA :b.next;
        }
        return a;

    }
    public ListNode getIntersectionNodeAppraoch1(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();
        while(headB!=null){
            set.add(headB);
            headB=headB.next;
        }
        while(headA!=null){
            if(set.contains(headA)){
                return headA;
            }
            headA=headA.next;
        }
        return null;
        
    }
}