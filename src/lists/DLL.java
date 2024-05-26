package lists;

class DLLNode {
    int val;
    DLLNode next;
    DLLNode prev;

    DLLNode() {
    }

    DLLNode(int val) {
        this.val = val;
    }

    DLLNode(int val, DLLNode next, DLLNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

public class DLL {
    public static void main(String[] args) {
        // Input: list1 = [5,4,3,2,1]
        // Output: Delete Head - [4,3,2,1]
        // Output: Delete tail - [5,4,3,2]
        // Output: Delete kth node - [5,4,3,1] k=4
        int arr1[] = { 5, 4, 3, 2, 1 };
        DLLNode l1 = convertArray2DoubleLL(arr1);
        // DLLNode head = l1;
        // DLLNode head = deleteHead(l1);
        // DLLNode head = deleteTail(l1);
        //DLLNode head = deleteKthNode(l1, 4);
        //DLLNode head = insertNewBeforeHead(l1, 6);
        //DLLNode head = insertNewBeforeTail(l1, 0);
        DLLNode head = insertNewBeforeKthNode(l1, 100, 5);
        System.out.print("DLL : ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }

    public static DLLNode convertArray2DoubleLL(int[] arr) {
        DLLNode head = new DLLNode(arr[0]);
        DLLNode mover = head;
        for (int i = 1; i < arr.length; i++) {
            DLLNode temp = new DLLNode(arr[i]);
            mover.next = temp;
            temp.prev = mover;
            mover = temp;
        }
        return head;
    }

    public static DLLNode deleteHead(DLLNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        DLLNode newHead = head.next;
        newHead.prev = null; // or head.prev which is null
        head.next = null;

        return newHead;
    }

    public static DLLNode deleteTail(DLLNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        DLLNode tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }
        DLLNode newTail = tailNode.prev;
        newTail.next = null; // or tailNode.next which is nothing but null
        tailNode.prev = null;

        return head;
    }

    public static DLLNode deleteKthNode(DLLNode head, int k) {
        if (head == null || head.next == null)
            return null;
        DLLNode kthNode = head;
        int count = 0;
        while (kthNode.next!=null) {
            count++;
            if(count==k)
                break;            
            kthNode = kthNode.next;
            
        }
        DLLNode previousNode = kthNode.prev;
        DLLNode nextNode = kthNode.next;
        if (previousNode == null) {
            head = deleteHead(head);
            return head;
        }else if(nextNode==null){
            head = deleteTail(head);
            return head;
        }
        previousNode.next = kthNode.next;
        nextNode.prev = kthNode.prev;
        kthNode.next = null;
        kthNode.prev = null;
        return head;
    }
    public static DLLNode insertNewBeforeHead(DLLNode head, int num) {
        DLLNode newHead = new DLLNode(num,head,null);
        head.prev = newHead;
        return newHead;
    }
    public static DLLNode insertNewBeforeTail(DLLNode head, int num) {  
        if(head.next==null){
            return insertNewBeforeHead(head, num);
        }  
        DLLNode tailNode = head;
        while(tailNode.next!=null){
            tailNode = tailNode.next;
        }
        DLLNode newTail = new DLLNode(num, tailNode, tailNode.prev);
        tailNode.prev.next = newTail;
        tailNode.prev = newTail;
        return head;
    }

    public static DLLNode insertNewBeforeKthNode(DLLNode head, int num, int k) {  
        if(k==1){
            return insertNewBeforeHead(head, num);
        }  
        DLLNode tailNode = head;
        int count=0;
        while(tailNode.next!=null){
            count++;
            if(count==k)
                break;
            tailNode = tailNode.next;
        }
        DLLNode newNode = new DLLNode(num, tailNode, tailNode.prev);
        tailNode.prev.next = newNode;
        tailNode.prev = newNode;
        return head;
    }
}
