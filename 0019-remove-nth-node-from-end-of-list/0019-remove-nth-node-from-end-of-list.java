class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;

        // Count nodes
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // If removing the first node
        if (n == count) {
            return head.next;
        }

        // Move to the node before the one we want to remove
        temp = head;

        for (int i = 1; i < count - n; i++) {
            temp = temp.next;
        }

        // Remove the node
        temp.next = temp.next.next;

        return head;
    }
}