/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        int count=0;
        ListNode temp=head;
        boolean prev=false;
        while(temp!=null){
            boolean curr=false;
            for(int i=0;i<nums.length;i++){
                if(temp.val==nums[i]){
                    curr=true;
                    break;
                }
                
            }
            if(curr && !prev){
                count++;
            }
            prev=curr;
            temp=temp.next;
        }
        return count;
        
    }
}