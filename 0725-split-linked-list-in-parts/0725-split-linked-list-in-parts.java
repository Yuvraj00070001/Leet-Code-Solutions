
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int totalNodes = 0;
        ListNode temp = head;

        // Step 1: Count total nodes
        while (temp != null) {
            totalNodes++;
            temp = temp.next;
        }

        // Step 2: Calculate base size and extra nodes
        int baseSize = totalNodes / k;
        int extra = totalNodes % k;

        // Step 3: Create result array
        ListNode[] result = new ListNode[k];
        temp = head;

        // Step 4: Divide the linked list into k parts
        for (int i = 0; i < k; i++) {
            result[i] = temp;

            // First 'extra' parts get one additional node
            int partSize = baseSize + (i < extra ? 1 : 0);

            // Move to the last node of the current part
            for (int j = 1; j < partSize; j++) {
                if (temp != null) {
                    temp = temp.next;
                }
            }

            // Disconnect the current part
            if (temp != null) {
                ListNode nextPart = temp.next;
                temp.next = null;
                temp = nextPart;
            }
        }

        return result;
    }
}
