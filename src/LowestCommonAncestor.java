public class LowestCommonAncestor {


    public Node findLCA(Node n1 , Node n2 , Node head){
        if(head == null){
            return null;
        }

       if(n1.data == head.data || n2.data == head.data){
           return head;
       }

        Node left = findLCA(n1 , n2 , head.left);
        Node right = findLCA(n1 , n2 , head.right);


        if(left != null && right!= null){
            return head;
        }

        return left == null ? right : left;


    }
}
