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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            // Check if current node starts a duplicate sequence
            boolean isDuplicate = false;
            while (current.next != null && current.val == current.next.val) {
                isDuplicate = true;
                current = current.next; // skip duplicate nodes
            }

            if (isDuplicate) {
                // Skip all nodes with this duplicate value
                prev.next = current.next;
            } else {
                // Move prev only if no duplicates found
                prev = prev.next;
            }

            current = current.next; // move forward
        }

        return dummy.next;
    }
}
