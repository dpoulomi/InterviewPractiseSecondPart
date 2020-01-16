import java.util.ArrayList;
import java.util.List;

public class MaximumSumPathInBinaryTree {

    private List<Node> path = new ArrayList<>();
    private int sum = 0;
   public void findMaxSumPath(Node root){

       sum = sum + root.data;
       path.add(root);




   }
}
