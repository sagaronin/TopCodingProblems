package lists;

public class AddTwoNumbers {
    public static void main(String[] args) {
        //Input: l1 = [2,4,3], l2 = [5,6,4]
        //Output: [7,0,8]
        int arr1[] = { 2,4,3 };
        int arr2[] = { 5,6,4 };
        ListNode l1 = convertArray2SingleLL(arr1);
        ListNode l2 = convertArray2SingleLL(arr2);
        // ListNode head = addTwoNumbers(l1, l2);
        // System.out.println("Sum in reverse order: ");
        // while(head!=null){
        //     System.out.print(" " + head.val);
        //     head = head.next;
        // }

        ListNode head = addTwoLists(l1, l2);
        System.out.println("Sum in reverse order: ");
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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        while(l1!=null || l2!=null){
            // initialize sum with carry from last addition
            int sum = carry + 0;
            //add first number sum
            if(l1!=null){
                sum+= l1.val;
                l1 = l1.next;
            }
            //add second number to sum
            if(l2!=null){
                sum+= l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            sum = sum % 10;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
            
        }
        if(carry!=0){
            ptr.next = new ListNode(carry);
        }
        return result.next;
    }

    public static ListNode addTwoLists(ListNode l1, ListNode l2) {
        ListNode sumlist = new ListNode(0);
        ListNode pointer = sumlist;
        int carry=0;
        while(l1!=null || l2!=null){
            int sum = carry;
            if(l1!=null){
                sum = sum +l1.val;
                l1= l1.next;
            }

            if(l2!=null){
                sum = sum +l2.val;
                l2= l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;
            pointer.next = new ListNode(sum);
            pointer = pointer.next;
        }
        if(carry!=0){
            pointer.next = new ListNode(carry);
        }
        return sumlist.next;

    }
    
}
class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}