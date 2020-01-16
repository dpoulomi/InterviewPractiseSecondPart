import data.LinkedListNode;

import java.util.Stack;

public class CheckLinkedListIsPalindrome {


    private LinkedListNode previousToMiddle = null;
    public static void main(String[] args) {

        CheckLinkedListIsPalindrome checkLinkedListIsPalindrome = new CheckLinkedListIsPalindrome();
        LinkedListNode n7 = new LinkedListNode(1 , null);
        LinkedListNode n6 = new LinkedListNode(2 , n7);
        LinkedListNode n5 = new LinkedListNode(1 , n6);
        LinkedListNode n4 = new LinkedListNode(3 , n5);
        LinkedListNode n3 = new LinkedListNode(1, n4);
        LinkedListNode n2 = new LinkedListNode(2 , n3);

        LinkedListNode n1 = new LinkedListNode(1 , n2);
        System.out.println(checkLinkedListIsPalindrome.checkIfPalindrome(n1));

    }

    public boolean checkIfPalindrome(LinkedListNode head){
        LinkedListNode root = head;
        if(root . next == null){
            return false;
        }
        LinkedListNode middleHead = getMiddleNode(root);

        LinkedListNode reversedHead = reverseLinkedList(previousToMiddle.data == middleHead.data ? middleHead: middleHead.next);

        previousToMiddle.next = null;
        boolean result = checkForEquality(root , reversedHead);
        previousToMiddle.next = middleHead;
        middleHead.next = reverseLinkedList(reversedHead);
        return result;


    }

    private boolean checkForEquality(LinkedListNode root, LinkedListNode reversedHead) {
        if(root == null && reversedHead == null){
            return true;
        }

        if((root == null && reversedHead != null) || (root != null && reversedHead == null) || root.data != reversedHead.data){
            return false;
        }

         return checkForEquality(root.next , reversedHead.next);

        //return true;


    }

    private LinkedListNode reverseLinkedList(LinkedListNode middleHead) {
        LinkedListNode currentNode = middleHead;
        LinkedListNode prev = null;
        LinkedListNode next = null;
        while(currentNode != null){

            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;


        }
        return prev;


    }

    private LinkedListNode getMiddleNode(LinkedListNode head) {
        LinkedListNode fastPointer = head;
        LinkedListNode slowPointer = fastPointer;

        while(slowPointer != null && slowPointer.next != null){
            slowPointer = slowPointer.next.next;
            previousToMiddle = fastPointer;
            fastPointer = fastPointer.next;
        }
        return fastPointer;
    }
}
