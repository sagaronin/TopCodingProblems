package lists;

public class MergeSortedLists {
    public static void main(String[] args) {
        // Input: list1 = [1,2,4], list2 = [1,3,4]
        // Output: [1,1,2,3,4,4]
        int arr1[] = { 1,2,4 };
        int arr2[] = { 1,3,4 };
        ListNode l1 = convertArray2SingleLL(arr1);
        ListNode l2 = convertArray2SingleLL(arr2);
        //ListNode head = mergeTwoLists(l1, l2);
        ListNode head = merge2SortedLists(l1, l2);
        System.out.println("Merged lists : ");
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode ptr = result;

        while (list1 != null && list2 != null) {
            int l1 = list1.val;
            int l2 = list2.val;
            if (l1 < l2) {
                ptr.next = new ListNode(l1);
                ptr = ptr.next;
                list1 = list1.next;
            } else if (l1 > l2) {
                ptr.next = new ListNode(l2);
                ptr = ptr.next;
                list2 = list2.next;
            } else {
                ptr.next = new ListNode(l2);
                ptr = ptr.next;
                ptr.next = new ListNode(l1);
                ptr = ptr.next;
                list1 = list1.next;
                list2 = list2.next;

            }
        }
        if (list1 == null) {
            ptr.next = list2;
        } else if(list2==null){
            ptr.next = list1;
        }
        return result.next;

    }

    public static ListNode merge2SortedLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(0);
        ListNode pointer = mergedList;
        while(list1!=null && list2!=null){
            int l1Val = list1.val;
            int l2Val = list2.val;
            
            if(l1Val < l2Val){
                pointer.next = new ListNode(l1Val);
                list1 = list1.next;
                pointer = pointer.next;
            }else if(l1Val > l2Val){
                pointer.next = new ListNode(l2Val);
                list2 = list2.next;
                pointer = pointer.next;
            }else{
                pointer.next = new ListNode(l1Val);
                list1 = list1.next;
                pointer = pointer.next;
                pointer.next = new ListNode(l2Val);
                list2 = list2.next;
                pointer = pointer.next;                
            }
        }
        if(list1!=null){
            pointer.next = list1;
        }else if(list2!=null){
            pointer.next = list2;
        }
        return mergedList.next;
        
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}