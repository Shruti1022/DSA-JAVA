/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        while(tortoise != null && hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;

            if(tortoise == hare){
                ListNode entry = head;
                while(entry != tortoise){
                    entry = entry.next;
                    tortoise = tortoise.next;
                }
                return entry;
            }
        }
        return null;
    }
}