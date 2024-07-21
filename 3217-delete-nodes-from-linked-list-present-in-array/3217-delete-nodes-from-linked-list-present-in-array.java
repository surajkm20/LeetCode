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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        int n = nums.length;
        ListNode tempHead1 = head;
        for(int i=0;i<n;i++){
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i], 0)+1);
        }

        
        while(head!=null && hashmap.containsKey(head.val)){
            head = head.next;
        }
        ListNode tempHead = head;
        while(tempHead != null && tempHead.next!=null){
            while(tempHead.next!=null && hashmap.containsKey(tempHead.next.val)){
                tempHead.next = tempHead.next.next;
            }
            tempHead = tempHead.next;
        }
        return head;
    }
}