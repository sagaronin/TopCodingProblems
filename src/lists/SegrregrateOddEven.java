package lists;

public class SegrregrateOddEven {
    public static void main(String[] args) {
        // Input: list1 = [5,4,3,2,1]
        // Output: [5,3,1,4,2]
        int arr1[] = { 5,4,3,2,1 };

        ListNode l1 = convertArray2SingleLL(arr1);
        ListNode head = segrregateOddsEven(l1);
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

    public static ListNode segrregateOddsEven(ListNode l1) {
        ListNode odd = l1;
        ListNode even = l1.next;
        ListNode evenHead = even;
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return l1;
    }

}
