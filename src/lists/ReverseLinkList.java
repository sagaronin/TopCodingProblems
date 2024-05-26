package lists;

public class ReverseLinkList {
    public static void main(String[] args) {
        //Input: head = [4,8,15,16]
        //Output: [16,15,8,4]
        int arr2[] = { 4,8,15,16 };
        ListNode l2 = convertArray2SingleLL(arr2);
        //ListNode head = reverseList(l2);
        ListNode head = reverseGivenList(l2);
        System.out.println("Reversed list : ");
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
    public static ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        
        ListNode previousNode = null;
        ListNode currentNode = head;
        while(currentNode!=null){
            ListNode nextNode = currentNode.next;
            currentNode.next =previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
        return head;

    }

    public static ListNode reverseGivenList(ListNode head) {
        ListNode currentNode = head;
        ListNode previousNode = null;
    
        while(currentNode!=null){
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
        return head;
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