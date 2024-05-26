package lists;

public class RemoveNthNodeFromBack {
    public static void main(String[] args) {
        // Input: list1 = [5,4,3,2,1], N=2;
        // Output: [5,4,3,1]
        int arr1[] = { 5,4,3,2,1 };

        ListNode l1 = convertArray2SingleLL(arr1);
        ListNode head = removeFromBack(l1,5);
        System.out.println("Segrregated list based on odd even indexes : ");
        while(head!=null){
            System.out.print(" " + head.val);
            head = head.next;
        }

    }
    public static ListNode convertArray2SingleLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static ListNode removeFromBack(ListNode head, int position) {
        ListNode fast = head;
        for (int i = 0; i < position; i++) {
            fast = fast.next;
        }
        if(fast==null){
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }
        ListNode slow = head;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode delNode = slow.next;
        slow.next = delNode.next;
        delNode.next = null;  
        return head;
    }
}
