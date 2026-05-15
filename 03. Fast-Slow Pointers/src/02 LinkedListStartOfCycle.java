//Linked List Cycle II
//Medium

//Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

//There is a cycle in a linked list if there is some node in the list
//that can be reached again by continuously following the next pointer.
//
// Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
// It is -1 if there is no cycle. Note that pos is not passed as a parameter.

//Do not modify the linked list.

//Example 1:
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the second node.

//Example 2:
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the first node.

//Example 3:
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.

class LinkedListStartOfCycle {
    public static void main(String[] args){
        // Example 1: [3, 2, 0, -4] pos = 1
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates the cycle back to node with value 2


        // Example 2:  Input: head = [1,2], pos = 0
//        ListNode head = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//
//        head.next = node2;
//        node2.next = head; // cycle is created


        // Example 2:  Input: head = [1], pos = -1
//        ListNode head = new ListNode(1);
        System.out.println("Has Cycle: " + detectCycle(head));

    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){ // meeting point
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
