package challenges;

class ReOrderList {
    public static void main(String [] args){
        // Linked list : 1->2->3->4->5->null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next= new ListNode(5);

        System.out.print("Initial Linked List: ");
        printList(head);

        reorderList(head);

        System.out.print("Output Linked List : ");
        printList(head);
    }

    public static void reorderList(ListNode head) {
        ListNode initialHead = head;
        ListNode slow = head;
        ListNode fast = head;

        // 1. traverse the linked list to find the middle point
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //2. reverse the second half of the linkedlist
        ListNode head2 = reverseLinkedList(slow.next);
        slow.next = null;

        // 3. manage the references of the 2 newy created LinkedLists
        ListNode next1,next2;
        while(head != null && head2 !=null){
            next1 = head.next;
            next2 = head2.next;

            head.next = head2;
            head2.next = next1;

            head = next1;
            head2 = next2;
        }
    }

    public static ListNode reverseLinkedList(ListNode head){ // slow.next
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    // Helper method to display the lists for comparison
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
