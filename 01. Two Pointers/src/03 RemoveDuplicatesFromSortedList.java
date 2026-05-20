//Remove Duplicates from Sorted Linked List

//Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
// Return the linked list sorted as well.

//Example 1:
//Input: head = [1,1,2]
//Output: [1,2]

//Example 2:
//Input: head = [1,1,2,3,3]
//Output: [1,2,3]
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}

class RemoveDuplicatesFromSortedList {
    public static void main(String[] args){
        // Example: 1->1->2
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);

        // Example: 1->1->2->3->3
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);

        System.out.println("Initial linked list 1: ");
        printList(head1);
        ListNode outputNode1 = deleteDuplicates(head1);
        System.out.println("Output 1: ");
        printList(outputNode1);

        System.out.println("Initial linked list 2: ");
        printList(head2);
        ListNode outputNode2 = deleteDuplicates(head2);
        System.out.println("Output 2: ");
        printList(outputNode2);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }

        ListNode left = head;
        ListNode right = head.next;

        while(right !=null){
            while(right !=null && right.val == left.val){
                right = right.next;
            }

            if(right == null){
                left.next = null;
                break;
            }

            left.next = right;
            left = right;
            right = right.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next; // Move to the next node
        }
        System.out.println(); // Print a fresh line at the end
    }
}
