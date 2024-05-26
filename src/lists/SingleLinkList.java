package lists;

public class SingleLinkList {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 , 5};
        Node head = convertArray2SingleLL(arr);
        while (head != null) {
            System.out.println("Data: " + head.data);
            head = head.next;
        }
        head = convertArray2SingleLL(arr);
        System.out.println("Length of Single LL: "+lengthOfSingleLL(head));
        head = convertArray2SingleLL(arr);
        System.out.println("Element Exists? : "+findElementInSingleLL(head, 12));
        head = convertArray2SingleLL(arr);
        System.out.println("Middle Node : "+findMiddleNode(head).data);
    }

    public static Node convertArray2SingleLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static int lengthOfSingleLL(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static int findElementInSingleLL(Node head, int searchtuple) {
        int element=-1;
        while (head != null) {
            if(head.data==searchtuple){
                element  = head.data;
                return element;
            }
            head = head.next;
        }
        return element;
    }

    public static Node findMiddleNode(Node head) {
        Node slow = head, fast=head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }
        return slow;
    }

}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
