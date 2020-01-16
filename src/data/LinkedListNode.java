package data;

public class LinkedListNode {

    public int data;
    public LinkedListNode next;
    public LinkedListNode arbitrary;

    public LinkedListNode(int d, LinkedListNode next) {
        this.data = d;
        this.next = next;

    }


    public static class AdditionOfLinkedList {

        public class LinkedList{
           private LinkedList next;
            private int data;

            public LinkedList(int data , LinkedList next){
                this.data = data;
                this.next = next;


            }

        }

        public static void main(String[] args) {



        }

        public LinkedList add(LinkedList list1, LinkedList list2){
            int sum = 0 ;
            int carry = 0 ;
            LinkedList head = null;
            LinkedList prev = null;
            LinkedList newNode = null;

            while(list1 != null && list2!= null ) {
                sum = carry + sum + (list1!= null ? list1.data :0) + (list2!=null ? list2.data :0);
              //  if (sum > 9) {
                    carry = sum > 10 ? 1 : 0;
                    sum = sum % 10;
                     newNode = new LinkedList(sum, null);
                    if (head == null) {
                        head = newNode;
                    } else {
                        prev.next = newNode;


                    }
                    prev = newNode;

                if (list1 != null) {
                   list1 = list1.next;
                }
                if (list2 != null) {
                   list2 = list2.next;
                }
            }
            if(carry >0 ){
                newNode.next = new LinkedList(carry, null);
            }

            return head;
        }
    }
}
