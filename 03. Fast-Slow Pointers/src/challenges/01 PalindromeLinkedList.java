package challenges;
class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

class PalindromeLinkedList {
    public static void main(String[] args) {
        // Linked list : 1->2->2->1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean result = isPalindrome(head);

        if (result)
            System.out.println("true");
        else
            System.out.println("false");
    }

    public static boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverseLinkedList(slow.next);
        slow.next = null;

        return isIdentical(head,head2);
    }

    public static ListNode reverseLinkedList(ListNode head){  // slow.next
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

    public static boolean isIdentical(ListNode n1, ListNode n2){
        while(n1 != null && n2 != null){
            if(n1.data != n2.data){
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }
}
